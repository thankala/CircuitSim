package com.CircuitEngine;

public class XOR extends Gate{

    public XOR(Pin input1, Pin input2, Pin output) {
        super("XOR", input1, input2, output);
    }

    public void operate(){
        getOutput().setPin((getInput1().getPin() && getInput2().getPin()) && (!(getInput1().getPin()) && (!(getInput2().getPin()))));

    }
}
