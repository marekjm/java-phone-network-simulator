package Cellular;

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
        e.routeMessage(phone_number, text);
    }
}
