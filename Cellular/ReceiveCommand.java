package Cellular;

import java.util.*;
import java.io.*;
import java.net.*;

import Cellular.Command;
import Cellular.PhoneEnvironment;

class ReceiveCommand extends Cellular.Command {
    public void execute(PhoneEnvironment env) {
        if (connect(env.cell())) {
            write("receive " + env.number());
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
