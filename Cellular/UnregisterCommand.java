package Cellular;

import java.util.*;
import java.io.*;
import java.net.*;

import Cellular.Command;
import Cellular.PhoneEnvironment;

class UnregisterCommand extends Cellular.Command {
    public void execute(PhoneEnvironment env) {
        if (connect(env.cell())) {
            write("unregister " + env.number());
        }
    }

    public UnregisterCommand(String[] args) {
        super(args);
    }
}
