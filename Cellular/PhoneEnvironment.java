package Cellular;

class PhoneEnvironment {
    Integer _cell = 0;
    public Integer cell() { return _cell; }
    public PhoneEnvironment cell(Integer __) { _cell = __; return this; }

    String _number = "";
    public String number() { return _number; }
    public PhoneEnvironment number(String __) { _number = __; return this; }
}
