package Cellular;

import java.io.*;
import java.net.*;
import java.util.*;

import Cellular.Environment;
import Cellular.MessageFactory;
import Cellular.Message;
import Cellular.ByeMessage;
import Cellular.RegisterMessage;
import Cellular.UnregisterMessage;
import Cellular.SendMessage;
import Cellular.TraceMessage;

class Cell {
    public static void main(String[] args) throws IOException {
        Console console = System.console();

        Map<String, String> messages = new HashMap<>();
        Environment env = new Environment();
        env.listen(new Integer(args[0]));

        while (true) {
            System.out.print("#");
            env.accept();
            System.out.println("!");

            String input = null;
            String[] parts = null;

            do {
                System.out.print("<- ");
                input = env.getline();
                if (input == null) {
                    System.out.println("<connection lost>");
                    break;
                }
                parts = input.split("\\s+");
                System.out.println(java.util.Arrays.toString(parts));

                Message m = MessageFactory.produce(input);
                System.out.println(m);
                m.execute(env);
            } while (env.attached());
        }
    }
}
