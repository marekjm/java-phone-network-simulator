package Cellular;


class Environment {
    private boolean _attached = false;
    public boolean attached() { return _attached; }
    public Environment attached(boolean __) { _attached = __; return this; }
}
