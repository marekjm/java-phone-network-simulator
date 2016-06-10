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
import Cellular.IntroduceMessage;

class Cell {
    public static void main(String[] args) throws IOException {
        Map<String, String> messages = new HashMap<>();
        Environment env = new Environment();
        env.listen(new Integer(args[0]));

        for (String nearby_cell : java.util.Arrays.asList(args).subList(1, args.length)) {
            env.send(new Integer(nearby_cell), ("introduce " + args[0]));
            env.introduce(new Integer(nearby_cell));
        }

        while (true) {
            System.out.print("#");
            env.accept();
            System.out.println("!");

            String input = null;
            String[] parts = null;

            System.out.print("<- ");
            input = env.getline();
            if (input == null) {
                System.out.println("<connection lost>");
                continue;
            }
            System.out.println(java.util.Arrays.toString(input.split("\\s+")));

            Message m = MessageFactory.produce(input);
            System.out.println(m);
            m.execute(env);
        }
    }
}
