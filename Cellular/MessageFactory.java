package Cellular;

import Cellular.Message;
import Cellular.ByeMessage;
import Cellular.RegisterMessage;
import Cellular.UnregisterMessage;
import Cellular.SendMessage;
import Cellular.ReceiveMessage;

class MessageFactory {
    static public Message produce(String input) {
        String[] parts = input.split("\\s+");

        Message m = null;

        if (parts.length == 0) {
            // early return if nothing can be done
            return m;
        }

        switch (parts[0]) {
            case "bye":
                m = new ByeMessage(parts);
                break;
            case "register":
                m = new RegisterMessage(parts);
                break;
            case "unregister":
                m = new UnregisterMessage(parts);
                break;
            case "send":
                m = new SendMessage(parts);
                break;
            default:
                m = new Message(parts);
        }

        return m;
    }
}
