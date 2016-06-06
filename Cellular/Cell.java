package Cellular;

import java.io.Console;

class Cell {
    public static void main(String[] args) {
        System.out.println("Hello World (from Cell)!");

        Console console = System.console();

        String command = new String("");
        while (command != null) {
            System.out.print("> ");
            command = console.readLine();
            System.out.println(command);
        }
    }
}
