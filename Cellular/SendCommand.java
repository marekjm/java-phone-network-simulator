package Cellular;

import java.util.*;
import java.io.*;
import java.net.*;

import Cellular.Command;

class SendCommand extends Cellular.Command {
    private String recipient;
    private String message;

    public void execute(Integer port, String phone_number) {
        if (connect(port)) {
            write("send " + recipient + " " + message);
        }
    }

    public SendCommand(String[] args) {
        super(args);
        recipient = args[1];
        message = args[2];
    }
}
