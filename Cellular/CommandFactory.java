package Cellular;

import Cellular.Command;
import Cellular.UnregisterCommand;
import Cellular.TraceCommand;

class CommandFactory {
    public static Command produce(String input) {
        String parts[] = input.split("\\s+");

        Command c = null;

        if (parts.length == 0) {
            // early return if nothing can be done
            return c;
        }

        switch (parts[0]) {
            case "unregister":
                c = new UnregisterCommand(parts);
                break;
            case "trace":
                c = new TraceCommand(parts);
                break;
        }

        return c;
    }
}
