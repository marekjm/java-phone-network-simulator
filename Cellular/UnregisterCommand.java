package Cellular;

import java.util.*;
import java.io.*;
import java.net.*;

import Cellular.Command;

class UnregisterCommand extends Cellular.Command {
    public void execute(Integer port, String phone_number) {
        try {
            Socket sock = new Socket("localhost", port);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            out.println("unregister " + phone_number);
        } catch (UnknownHostException e) {
            System.out.println(this + ": failed: " + e);
        } catch (IOException e) {
            System.out.println(this + ": failed: " + e);
        }
    }

    public UnregisterCommand(String[] args) {
        super(args);
    }
}
