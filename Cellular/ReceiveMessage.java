package Cellular;

import Cellular.Environment;
import Cellular.Message;

class ReceiveMessage extends Cellular.Message {
    private String phone_number;

    public ReceiveMessage(String[] args) {
        super(args);
        phone_number = args[1];
    }
    public void execute(Environment e) {
        e.fetchMessage(phone_number);
    }
}
