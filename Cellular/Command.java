package Cellular;

import java.util.*;

class Command {
    private String[] arguments;

    public void execute(Integer port, String phone_number) {
        System.out.println("unknown command: " + java.util.Arrays.toString(arguments));
    }

    public Command(String[] args) {
        arguments = args;
    }
}
