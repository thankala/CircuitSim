package com.CircuitEngine;

public class AND extends Gate{

    public AND(Pin input1, Pin input2, Pin output) {
        super("AND", input1, input2, output);
    }

    public void operate(){
        getOutput().setPin(getInput1().getPin() && getInput2().getPin()); //having encapsulation in mind, this is equal to this.output.setPin(this.input1.getPin()&&this.input2.getPin());
    }
}
