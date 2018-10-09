package com.CircuitEngine;

public class XNOR extends Gate{

    public XNOR(Pin input1, Pin input2, Pin output) {
        super("XNOR", input1, input2, output);
    }

    public void operate(){
        getOutput().setPin((getInput1().getPin() && getInput2().getPin()) || (!(getInput1().getPin()) && (!(getInput2().getPin()))));
    }
}
