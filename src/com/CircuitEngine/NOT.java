package com.CircuitEngine;

public class NOT extends Gate{

    public NOT(Pin input1, Pin output) {
        super("NOT", input1,null, output);
    }

    public void operate(){
        getOutput().setPin(!(getInput1().getPin()));
    }
}
