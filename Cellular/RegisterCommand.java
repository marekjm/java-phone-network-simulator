package Cellular;

import java.util.*;
import java.io.*;
import java.net.*;

import Cellular.Command;
import Cellular.PhoneEnvironment;

class RegisterCommand extends Cellular.Command {
    private String port;

    public void execute(PhoneEnvironment env) {
        env.cell(new Integer(port));
        if (connect(env.cell())) {
            write("register " + env.number() + " " + env.listening_on()); // send phone number to a cell
        }
    }

    public RegisterCommand(String[] args) {
        super(args);
        port = args[1];
    }
}
