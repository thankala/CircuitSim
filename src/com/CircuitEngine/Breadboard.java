package com.CircuitEngine;

public class Breadboard {

    int col=4;
    int pinsPerCol=6;
    public Pin[][] pins;

    public Breadboard(){
        this.pins = new Pin[col][pinsPerCol];
        for(int c=0;c<col;c++){
            for(int r=0;r<pinsPerCol;r++){
                this.pins[c][r]=new Pin(false);
            }
        }
    }
    public void setInput(int c,int r,boolean val){
        this.pins[c][r].setPin(val);
    }
    public boolean getInput(int c, int r){
        return this.pins[c][r].getPin();
    }
    public void pinsClear(){
        for(int c=0;c<col;c++){
            for(int r=0;r<pinsPerCol;r++){
                this.pins[c][r].setPin(false);
            }
        }
    }
    public Pin[] getOutput(){
        Pin[] output = new Pin[pinsPerCol];
        for (int i=0;i<pinsPerCol;i++){
            output[i]=this.pins[i][col-1];
        }
        return output;
    }
    public void showState(){
        for(int r=0;r<pinsPerCol;r++){
            for(int c=0;c<col;c++){
                System.out.print(pins[c][r].getPin()+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean getLastColumn(int index){
        return this.pins[col][index].getPin();
    }
}