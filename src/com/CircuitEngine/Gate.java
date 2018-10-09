package com.CircuitEngine;

public abstract class Gate {

    private Pin input1;
    private Pin input2;
    private Pin output;
    private String label;

    public Gate(String label , Pin input1,Pin input2, Pin output){
        this.label = label;
        this.input1 = input1;
        this.input2 = input2;
        this.output = output;
    }

    public abstract void operate();


    public Pin getInput1() {
        return input1;
    }

    public Pin getInput2() {
        return input2;
    }

    public Pin getOutput() {
        return output;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
