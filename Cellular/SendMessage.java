package Cellular;

import java.net.*;
import java.io.*;

import Cellular.Environment;
import Cellular.Message;

class SendMessage extends Cellular.Message {
    private String phone_number;
    private String text;

    public SendMessage(String[] args) {
        super(args);
        phone_number = args[1];
        text = args[2];
    }
    public void execute(Environment e) {
        try {
            e.routeMessage(phone_number, text);
        } catch (UnknownHostException ex) {
            // do nothing, the exception must be trapped since
            // .execute() is no-throw
        } catch (IOException ex) {
            // do nothing, the exception must be trapped since
            // .execute() is no-throw
        }
    }
}
