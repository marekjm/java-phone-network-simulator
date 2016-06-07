package Cellular;

import Cellular.Environment;
import Cellular.Message;

class UnregisterMessage extends Cellular.Message {
    private String phone_number;
    public UnregisterMessage(String[] args) {
        super(args);
        phone_number = args[1];
    }
    public void execute(Environment e) {
        e.removePhone(phone_number);
        e.attached(true);
    }
}
