package Cellular;

import java.io.*;
import java.net.*;
import java.util.*;

import Cellular.Environment;
import Cellular.Message;
import Cellular.ByeMessage;
import Cellular.RegisterMessage;
import Cellular.MessageFactory;

class Cell {
    public static void main(String[] args) throws IOException {
        Console console = System.console();

        ServerSocket ssock = new ServerSocket(new Integer(args[0]));
        Socket sock = null;

        Map<String, String> messages = new HashMap<>();
        Environment env = new Environment();

        while (true) {
            System.out.print("#");
            sock = ssock.accept();
            System.out.println("!");

            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);

            String input = null;
            String[] parts = null;

            do {
                System.out.print("<- ");
                input = in.readLine();
                if (input == null) {
                    System.out.println("<connection lost>");
                    break;
                }
                parts = input.split("\\s+");
                System.out.println(parts.length + " " + java.util.Arrays.toString(parts));

                Message m = MessageFactory.produce(input);
                System.out.println(m);

                if (m != null) {
                    m.execute(env);
                }

                if (parts.length == 2 && parts[0].equals("unregister")) {
                    System.out.println("unregistered phone: " + parts[1]);
                } else if (parts.length == 3 && parts[0].equals("send")) {
                    messages.put(parts[1], parts[2]);
                } else if (parts.length == 2 && parts[0].equals("receive")) {
                    out.println(messages.get(parts[1]));
                    // if (messages.exists(parts[1])) {
                    //     System.out.println("receive OK");
                    // } else {
                    //     System.out.println("OH NOES!");
                    // }
                }
            } while (env.attached());
        }
    }
}
