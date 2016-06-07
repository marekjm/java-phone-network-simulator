package Cellular;

import Cellular.Environment;
import Cellular.Message;

class ByeMessage extends Cellular.Message {
    public ByeMessage(String[] args) {
        super(args);
    }
    public void execute(Environment e) {
        e.attached(false);
    }
}
