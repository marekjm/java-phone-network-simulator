package Cellular;

import java.util.*;
import java.io.*;
import java.net.*;

import Cellular.PhoneEnvironment;

class Command {
    protected String[] arguments;

    protected Socket socket = null;
    protected BufferedReader in = null;
    protected PrintWriter out = null;

    protected void write(String s) {
        out.println(s);
    }

    protected String read() throws IOException {
        return in.readLine();
    }

    // protected Socket socket() { return _socket; }
    // protected BufferedReader in() { return _in; }
    // protected PrintWriter out() { return _out; }

    protected boolean connect(Integer port) {
        boolean success = false;
        try {
            socket = new Socket("localhost", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            success = true;
        } catch (UnknownHostException e) {
            System.out.println("failed to create socket: " + e);
        } catch (IOException e) {
            System.out.println("failed to connect: " + e);
        }
        return success;
    }

    public void execute(PhoneEnvironment env) {
        System.out.println("unknown command: " + java.util.Arrays.toString(arguments));
    }

    public Command(String[] args) {
        arguments = args;
    }
}
