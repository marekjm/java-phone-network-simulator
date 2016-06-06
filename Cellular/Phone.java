package Cellular;

import java.io.*;
import java.net.*;

class Phone {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Hello World (from Phone)!");

        Integer listening_on = new Integer(args[0]);
        String phone_number = args[1];
        System.out.println("phone: " + phone_number);

        Console console = System.console();

        Integer registered_at = 0;
        Socket sock = null;
        BufferedReader in = null;
        PrintWriter out = null;

        String input = new String("");
        while (true) {
            System.out.print("> ");
            input = console.readLine();
            if (input == null) {
                System.out.println("");
                break;
            }

            String[] parts = input.split("\\s+");
            System.out.println(parts.length + " " + java.util.Arrays.toString(parts));

            // we need a command and at least one operand
            if (parts.length < 2) {
                continue;
            }

            String command = parts[0];
            String operand = (parts.length > 1 ? parts[1] : "");


            switch (command) {
                case "register":
                    registered_at = new Integer(operand);
                    System.out.println("registering at: " + registered_at);
                    sock = new Socket("localhost", registered_at);
                    in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                    out = new PrintWriter(sock.getOutputStream(), true);
                    out.println("register " + phone_number + " " + listening_on); // send phone number to a cell
                    break;
                case "unregister":
                    System.out.println("unregistering from: " + registered_at);
                    out.println("unregister " + phone_number);
                    break;
                case "bye":
                    out.println("bye " + phone_number + " " + operand);
                    break;
                default:
                    System.err.println("error: unknown command: " + command);
            }
        }
    }
}
