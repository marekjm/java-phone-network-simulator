package Cellular;

import java.util.*;

import Cellular.Environment;
import Cellular.Message;

class TraceMessage extends Cellular.Message {
    private String phone_number;

    public TraceMessage(String[] args) {
        super(args);
        phone_number = args[1];
    }
    public void execute(Environment e) {
        e.println(java.util.Arrays.toString(e.tracePhone(phone_number).toArray()));
    }
}
