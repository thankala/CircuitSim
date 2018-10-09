package com.CircuitEngine;

import com.CircuitGraphicsUserInterface.CircuitGui;

public class Main {

    public static void main(String[] args){
        Circuit c = new Circuit();
        Breadboard bb = new Breadboard();
        CircuitGui cg = new CircuitGui(c,bb);
    }
}
