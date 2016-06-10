package Cellular;

import java.util.*;
import java.io.*;
import java.net.*;

import Cellular.Command;
import Cellular.PhoneEnvironment;

class TraceCommand extends Cellular.Command {
    private String number_to_trace;

    public void execute(PhoneEnvironment env) {
        if (connect(env.cell())) {
            try {
                write("trace " + number_to_trace + " 0,");
                System.out.println(read());
            } catch (IOException e) {
                System.out.println(this + ": failed: " + e);
            }
        }
    }

    public TraceCommand(String[] args) {
        super(args);
        number_to_trace = args[1];
    }
}
