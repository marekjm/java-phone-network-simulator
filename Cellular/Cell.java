package Cellular;

import java.io.Console;

class Cell {
    public static void main(String[] args) {
        System.out.println("Hello World (from Cell)!");

        Console console = System.console();

        String input = new String("");
        while (true) {
            System.out.print("> ");
            input = console.readLine();
            if (input == null) {
                System.out.println("");
                break;
            }
            System.out.println(input);
        }
    }
}
