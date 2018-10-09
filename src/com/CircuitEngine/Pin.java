package com.CircuitEngine;

public class Pin {
    private boolean state;

    public Pin(boolean state) {
        this.state=state;
    }

    public void setPin(boolean state) {
        this.state = state;
    }

    public boolean getPin(){
        return state;
    }

}
