package Cellular;

import java.io.*;
import java.net.*;

class Phone {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Hello World (from Phone)!");

        String phone_number = args[0];
        System.out.println("phone: " + phone_number);

        Console console = System.console();

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

            //Socket sock = new Socket(new Integer(args[1]));
            Socket sock = null;
            BufferedReader in = null;
            PrintWriter out = null;

            switch (command) {
                case "register":
                    System.out.println("registering...");
                    sock = new Socket("localhost", new Integer(operand));
                    in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                    out = new PrintWriter(sock.getOutputStream(), true);
                    out.println(phone_number);
                    break;
                default:
                    System.err.println("error: unknown command: " + command);
            }
        }
    }
}
