package com.CircuitEngine;

public class Circuit {
    int col=4;
    int pinsPerCol=6;
    Gate[][] gates;

    public Circuit() {
        this.gates = new Gate[col][pinsPerCol];
    }

    public void addGate(int c, int p, Gate addgate) {
        this.gates[c][p] = addgate;
    }

    public void run() {
        for (int c = 0; c < col-1; c++) {
            for (int r = 0; r < pinsPerCol; r++) {
                if (this.gates[c][r] != null) {
                    this.gates[c][r].operate();
                }
            }
        }
    }

    public void showState(){
        for(int r=0;r<pinsPerCol;r++){
            for(int c=0;c<col-1;c++){
                if(gates[c][r]!=null){
                    System.out.print(gates[c][r].getClass().getName()+"\t\t\t");
                }
                else{
                    System.out.print("null\t\t\t\t\t\t\t");
                }
            }
            System.out.println();
        }
    }

    public void circuitClear(){
        for(int c=0;c<col-1;c++){
            for(int r=0;r<pinsPerCol;r++){
                gates[c][r]=null;
            }
        }
    }

    public Gate getGate(int c,int r){
        return this.gates[c][r];

    }
}
