package Cellular;

import Cellular.Environment;
import Cellular.Message;

class RegisterMessage extends Cellular.Message {
    private String phone_number;
    public RegisterMessage(String[] args) {
        super(args);
        phone_number = args[1];
    }
    public void execute(Environment e) {
        e.registerPhone(phone_number);
        e.attached(true);
    }
}
