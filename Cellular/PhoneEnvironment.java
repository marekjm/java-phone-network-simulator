package Cellular;

class PhoneEnvironment {
    Integer _cell = 0;
    public Integer cell() { return _cell; }
    public PhoneEnvironment cell(Integer __) { _cell = __; return this; }

    String _number = "";
    public String number() { return _number; }
    public PhoneEnvironment number(String __) { _number = __; return this; }

    Integer _listening_on = 0;
    public Integer listening_on() { return _listening_on; }
    public PhoneEnvironment listening_on(Integer __) { _listening_on = __; return this; }
}
