package Cellular;

import java.io.*;
import java.net.*;

import Cellular.CommandFactory;
import Cellular.Command;
import Cellular.UnregisterCommand;
import Cellular.TraceCommand;
import Cellular.UnregisterCommand;

class Phone {
    private static String getline() {
        return System.console().readLine();
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        Integer listening_on = new Integer(args[0]);
        String phone_number = args[1];

        Integer registered_at = 0;

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

            if ((!command.equals("register")) && registered_at == 0) {
                System.out.println("error: phone is not registered at any cell");
                continue;
            } else if (command.equals("register") && registered_at != 0) {
                System.out.println("error: phone is already registered at cell " + registered_at);
                continue;
            } else if (command.equals("register") && registered_at == 0) {
                registered_at = new Integer(operand);
                System.out.println("registering at: " + registered_at);
                Socket sock = null;
                BufferedReader in = null;
                PrintWriter out = null;
                sock = new Socket("localhost", registered_at);
                in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                out = new PrintWriter(sock.getOutputStream(), true);
                out.println("register " + phone_number + " " + listening_on); // send phone number to a cell
                continue;
            }

            Command c = CommandFactory.produce(input);
            c.execute(registered_at, phone_number);

            // switch (command) {
            //     case "bye":
            //         out.println("bye " + phone_number + " " + operand);
            //         break;
            //     case "send":
            //         out.println("send " + parts[1] + " " + parts[2]);
            //         break;
            //     case "receive":
            //         out.println("receive " + phone_number);
            //         System.out.println(in.readLine());
            //         break;
            //     default:
            //         System.err.println("error: unknown command: " + command);
            // }
        }
    }
}
