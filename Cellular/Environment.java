package Cellular;

import java.util.*;

class Environment {
    private boolean _attached = false;
    public boolean attached() { return _attached; }
    public Environment attached(boolean __) { _attached = __; return this; }

    List<String> known_phone_numbers = new ArrayList<String>();
    public Environment registerPhone(String p) {
        known_phone_numbers.add(p);
        return this;
    }
}
