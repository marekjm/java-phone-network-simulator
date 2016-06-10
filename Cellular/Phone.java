package Cellular;

import java.io.*;
import java.net.*;

import Cellular.PhoneEnvironment;
import Cellular.CommandFactory;
import Cellular.Command;
import Cellular.RegisterCommand;
import Cellular.UnregisterCommand;
import Cellular.TraceCommand;
import Cellular.SendCommand;
import Cellular.ReceiveCommand;

class Phone {
    private static String getline() {
        return System.console().readLine();
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        Integer listening_on = new Integer(args[0]);

        PhoneEnvironment env = new PhoneEnvironment();
        env.number(args[1]);

        String input = new String("");
        while (true) {
            System.out.print("> ");
            input = Phone.getline();
            if (input == null) {
                System.out.println("");
                break;
            }

            String[] parts = input.split("\\s+");
            System.out.println(parts.length + " " + java.util.Arrays.toString(parts));

            // we need a command and at least one operand
            if (parts.length < 1) {
                continue;
            }

            String command = parts[0];
            String operand = (parts.length > 1 ? parts[1] : "");

            if (command.equals("bye")) {
                break;
            }

            Command c = CommandFactory.produce(input);
            c.execute(env);
        }
    }
}
