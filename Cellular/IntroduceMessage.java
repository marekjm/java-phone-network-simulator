package Cellular;

import java.util.*;

import Cellular.Environment;
import Cellular.Message;

class IntroduceMessage extends Cellular.Message {
    private Integer cell_port;

    public IntroduceMessage(String[] args) {
        super(args);
        cell_port = new Integer(args[1]);
    }
    public void execute(Environment e) {
        e.introduce(cell_port);
    }
}
