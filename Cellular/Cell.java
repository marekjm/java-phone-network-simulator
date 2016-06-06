package Cellular;

import java.io.*;
import java.net.*;

class Cell {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World (from Cell)!");

        Console console = System.console();

        System.out.println("Cell listening on " + args[0]);

        ServerSocket ssock = new ServerSocket(new Integer(args[0]));
        Socket sock = ssock.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter out = new PrintWriter(sock.getOutputStream(), true);

        System.out.println("registered phone: " + in.readLine());

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
                case "connect":
                    System.out.println("connecting...");
                    break;
                default:
                    System.err.println("error: unknown command: " + command);
            }
        }
    }
}
