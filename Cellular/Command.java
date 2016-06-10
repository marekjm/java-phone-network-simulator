package Cellular;

import java.util.*;
import java.io.*;
import java.net.*;

class Command {
    protected String[] arguments;

    private Socket _socket = null;
    private BufferedReader _in = null;
    private PrintWriter _out = null;

    protected Socket socket() { return _socket; }
    protected BufferedReader in() { return _in; }
    protected PrintWriter out() { return _out; }

    protected boolean connect(Integer port) {
        boolean success = false;
        try {
            _socket = new Socket("localhost", port);
            _in = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
            _out = new PrintWriter(_socket.getOutputStream(), true);
            success = true;
        } catch (UnknownHostException e) {
            System.out.println("failed to create socket: " + e);
        } catch (IOException e) {
            System.out.println("failed to connect: " + e);
        }
        return success;
    }

    public void execute(Integer port, String phone_number) {
        System.out.println("unknown command: " + java.util.Arrays.toString(arguments));
    }

    public Command(String[] args) {
        arguments = args;
    }
}
