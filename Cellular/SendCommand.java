package Cellular;

import java.util.*;
import java.io.*;
import java.net.*;

import Cellular.Command;
import Cellular.PhoneEnvironment;

class SendCommand extends Cellular.Command {
    private String recipient;
    private String message;

    public void execute(PhoneEnvironment env) {
        if (connect(env.cell())) {
            write("send " + recipient + " " + message);
        }
    }

    public SendCommand(String[] args) {
        super(args);
        recipient = args[1];
        message = args[2];
    }
}
