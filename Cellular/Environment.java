package Cellular;

import java.util.*;
import java.io.*;
import java.net.*;

class Environment {
    private boolean _attached = false;
    public boolean attached() { return _attached; }
    public Environment attached(boolean __) { _attached = __; return this; }


    List<String> known_phone_numbers = new ArrayList<String>();
    public Environment registerPhone(String p) {
        if (!known_phone_numbers.contains(p)) {
            known_phone_numbers.add(p);
        }
        return this;
    }
    public Environment removePhone(String p) {
        known_phone_numbers.remove(p);
        return this;
    }


    private Integer port = -1;
    private ServerSocket ssock = null;
    private Socket _socket = null;
    private BufferedReader _in = null;
    private PrintWriter _out = null;
    public Environment listen(Integer n) throws IOException {
        port = n;
        ssock = new ServerSocket(n);
        return this;
    }
    public Environment accept() throws IOException {
        _socket = ssock.accept();
        _in = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
        _out = new PrintWriter(_socket.getOutputStream(), true);
        return this;
    }
    public String getline() throws IOException {
        return _in.readLine();
    }
    public Environment println(String line) {
        _out.println(line);
        return this;
    }


    Map<String, List<String>> messages = new HashMap<String, List<String>>();
    public Environment routeMessage(String phone_number, String text) throws UnknownHostException, IOException {
        List<Integer> cells = tracePhone(phone_number, "0,");
        if (cells.size() == 0) {
            System.out.println("error: unknown phone number: " + phone_number);
            return this;
        }
        if (port == cells.get(0) && known_phone_numbers.contains(phone_number)) {
            if (!messages.containsKey(phone_number)) {
                messages.put(phone_number, new ArrayList<String>());
            }
            messages.get(phone_number).add(text);
        } else {
            send(cells.get(1), ("send " + phone_number + " " + text));
        }

        return this;
    }
    public Environment fetchMessage(String phone_number) {
        String msg = null;

        if (messages.containsKey(phone_number)) {
            if (messages.get(phone_number).size() > 0) {
                msg = messages.get(phone_number).remove(0);
            }
        }

        if (msg == null) {
            msg = "";
        }

        println(msg);
        return this;
    }


    private List<Integer> nearby_cells = new ArrayList<Integer>();
    public Environment introduce(Integer n) {
        if (!nearby_cells.contains(n)) {
            nearby_cells.add(n);
        }
        return this;
    }
    public Environment adieu(Integer n) {
        nearby_cells.remove(n);
        return this;
    }

    public void send(Integer cell_port, String message) throws UnknownHostException, IOException {
        Socket send_socket = new Socket("localhost", cell_port);
        (new PrintWriter(send_socket.getOutputStream(), true)).println(message);
    }
    public String communicate(Integer cell_port, String message) throws UnknownHostException, IOException {
        Socket send_socket = new Socket("localhost", cell_port);
        (new PrintWriter(send_socket.getOutputStream(), true)).println(message);
        return (new BufferedReader(new InputStreamReader(send_socket.getInputStream()))).readLine();
    }

    public List<Integer> tracePhone(String phone_number, String already_visited) throws UnknownHostException, IOException {
        List<Integer> trc = new ArrayList<Integer>();

        already_visited.concat(port.toString() + ",");

        if (known_phone_numbers.contains(phone_number)) {
            trc.add(port);
        } else {
            for (Integer nearby : nearby_cells) {
                if (!already_visited.contains(nearby.toString())) {
                    String r = communicate(nearby, ("trace " + phone_number + " " + already_visited + port + ","));
                    if (!r.equals("[]")) {
                        trc.add(port);
                        r = r.substring(1, r.length()-1);
                        System.out.println(r);
                        String[] nos = r.split(", *");
                        for (String s : nos) {
                            trc.add(new Integer(s));
                        }
                        break;
                    }
                }
            }
        }
        return trc;
    }
}
