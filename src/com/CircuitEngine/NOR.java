package com.CircuitEngine;

public class NOR extends Gate{
    public NOR(Pin input1, Pin input2, Pin output) {
        super("NOR", input1, input2, output);
    }

    public void operate(){
        getOutput().setPin(!(getInput1().getPin() || getInput2().getPin())); //having encapsulation in mind, this is equal to this.output.setPin(this.input1.getPin()&&this.input2.getPin());
    }
}
