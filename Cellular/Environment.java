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
    public Environment routeMessage(String phone_number, String text) {
        if (!known_phone_numbers.contains(phone_number)) {
            System.out.println("error: unknown phone number: " + phone_number);
            return this;
        }
        if (!messages.containsKey(phone_number)) {
            messages.put(phone_number, new ArrayList<String>());
        }
        messages.get(phone_number).add(text);
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

    public List<Integer> tracePhone(String phone_number) {
        List<Integer> trc = new ArrayList<Integer>();
        if (known_phone_numbers.contains(phone_number)) {
            trc.add(port);
        } else {
            // FIXME: TODO: implement
        }
        return trc;
    }
}
