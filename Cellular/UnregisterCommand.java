package Cellular;

import java.util.*;
import java.io.*;
import java.net.*;

import Cellular.Command;

class UnregisterCommand extends Cellular.Command {
    public void execute(Integer port, String phone_number) {
        if (connect(port)) {
            write("unregister " + phone_number);
        }
    }

    public UnregisterCommand(String[] args) {
        super(args);
    }
}
