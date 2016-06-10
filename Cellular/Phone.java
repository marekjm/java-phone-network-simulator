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

            Command c = CommandFactory.produce(input);
            c.execute(env);
        }
    }
}
