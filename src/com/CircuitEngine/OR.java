package com.CircuitEngine;

public class OR extends Gate{
    public OR(Pin input1, Pin input2, Pin output) {
        super("OR", input1, input2, output);
    }

    public void operate(){
        getOutput().setPin(getInput1().getPin() || getInput2().getPin());
    }
}
