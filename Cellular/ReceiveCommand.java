package Cellular;

import java.util.*;
import java.io.*;
import java.net.*;

import Cellular.Command;

class ReceiveCommand extends Cellular.Command {
    public void execute(Integer port, String phone_number) {
        if (connect(port)) {
            write("receive " + phone_number);
            try {
                System.out.println(read());
            } catch (IOException e) {
                System.out.println("receiving failed: " + e);
            }
        }
    }

    public ReceiveCommand(String[] args) {
        super(args);
    }
}
