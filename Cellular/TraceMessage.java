package Cellular;

import java.io.*;
import java.util.*;
import java.net.*;

import Cellular.Environment;
import Cellular.Message;

class TraceMessage extends Cellular.Message {
    private String phone_number;
    private String already_visited;

    public TraceMessage(String[] args) {
        super(args);
        phone_number = args[1];
        already_visited = args[2];
    }
    public void execute(Environment e) {
        String s = "[]";
        try {
            s = java.util.Arrays.toString(e.tracePhone(phone_number, already_visited).toArray());
        } catch (UnknownHostException ex) {
            // do nothing
        } catch (IOException ex) {
            // do nothing
        }
        e.println(s);
    }
}
