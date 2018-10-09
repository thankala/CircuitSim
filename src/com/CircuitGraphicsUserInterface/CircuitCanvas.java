package com.CircuitGraphicsUserInterface;

import com.CircuitEngine.*;

import javax.swing.*;
import java.awt.*;

public class CircuitCanvas {

    private JLabel img,input1Label,input2Label,outputLabel;
    private MyPanel breadboardPanel;
    private String gateName;
    private int row,column,input1,input2,output;
    private Breadboard bb;
    private Circuit circuit;

    public CircuitCanvas(String gateName, MyPanel breadboardPanel,Breadboard bb, Circuit circuit) {
        this.breadboardPanel    = breadboardPanel;
        this.gateName           = gateName;
        this.circuit            = circuit;
        this.bb                 = bb;


        column                  = Integer.parseInt(GatePopupWindow.getPropertiesComboItem(0));
        row                     = Integer.parseInt(GatePopupWindow.getPropertiesComboItem(1));
        input1                  = Integer.parseInt(GatePopupWindow.getPropertiesComboItem(2));
        input2                  = Integer.parseInt(GatePopupWindow.getPropertiesComboItem(3));
        output                  = Integer.parseInt(GatePopupWindow.getPropertiesComboItem(4));



        switch(gateName){
            case "AND":
                setGate(gateName,column,row,input1,input2,output,new ImageIcon("images/ANDGate.gif"));
                AND andgate = new AND(bb.pins[column-1][input1-1],bb.pins[column-1][input2-1],bb.pins[column][output-1]);
                circuit.addGate(column-1,row-1,andgate);
                bb.setInput(column,input1,bb.getInput(column-1,input1-1));
                bb.setInput(column,input2,bb.getInput(column-1,input2-1));
                break;
            case "OR":
                setGate(gateName,column,row,input1,input2,output,new ImageIcon("images/ORGate.gif"));
                OR orgate = new OR(bb.pins[column-1][input1-1],bb.pins[column-1][input2-1],bb.pins[column][output-1]);
                circuit.addGate(column-1,row-1,orgate);
                bb.setInput(column-1,input1-1,bb.getInput(column-1,input1-1));
                bb.setInput(column-1,input2-1,bb.getInput(column-1,input2-1));
                break;
            case "NAND":
                setGate(gateName,column,row,input1,input2,output,new ImageIcon("images/NANDGate.gif"));
                NAND nandgate = new NAND(bb.pins[column-1][input1-1],bb.pins[column-1][input2-1],bb.pins[column][output-1]);
                circuit.addGate(column-1,row-1,nandgate);
                bb.setInput(column-1,input1-1,bb.getInput(column-1,input1-1));
                bb.setInput(column-1,input2-1,bb.getInput(column-1,input2-1));
                break;
            case "NOR":
                setGate(gateName,column,row,input1,input2,output,new ImageIcon("images/NORGate.gif"));
                NOR norgate = new NOR(bb.pins[column-1][input1-1],bb.pins[column-1][input2-1],bb.pins[column][output-1]);
                circuit.addGate(column-1,row-1,norgate);
                bb.setInput(column-1,input1-1,bb.getInput(column-1,input1-1));
                bb.setInput(column-1,input2-1,bb.getInput(column-1,input2-1));
                break;
            case "NOT":
                setGate(gateName,column,row,input1,input2,output,new ImageIcon("images/NOTGate.gif"));
                NOT notgate = new NOT(bb.pins[column-1][input1-1],bb.pins[column][output-1]);
                circuit.addGate(column-1,row-1,notgate);
                bb.setInput(column-1,input1-1,bb.getInput(column-1,input1-1));
                break;
            case "XOR":
                setGate(gateName,column,row,input1,input2,output,new ImageIcon("images/XORGate.gif"));
                XOR xorgate = new XOR(bb.pins[column-1][input1-1],bb.pins[column-1][input2-1],bb.pins[column][output-1]);
                circuit.addGate(column-1,row-1,xorgate);
                bb.setInput(column-1,input1-1,bb.getInput(column-1,input1-1));
                bb.setInput(column-1,input2-1,bb.getInput(column-1,input2-1));
                break;
            case "XNOR":
                setGate(gateName,column,row,input1,input2,output,new ImageIcon("images/XNORGate.gif"));
                XNOR xnorgate = new XNOR(bb.pins[column-1][input1-1],bb.pins[column-1][input2-1],bb.pins[column][output-1]);
                circuit.addGate(column-1,row-1,xnorgate);
                bb.setInput(column-1,input1-1,bb.getInput(column-1,input1-1));
                bb.setInput(column-1,input2-1,bb.getInput(column-1,input2-1));
                break;
        }
    }

    public void setGate(String label, int collumn, int row, int input1,int input2,int output, ImageIcon icon) {
        img = new JLabel();
        input1Label = new JLabel(String.valueOf(input1));
        input2Label = new JLabel(String.valueOf(input2));
        outputLabel = new JLabel(String.valueOf(output));


        if (collumn == 1 ) {
            if (row == 1) {
                img.setBounds(180, 22, 60, 60);
                outputLabel.setBounds(248, 41, 20, 20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(170, 25, 20, 20);
                    input2Label.setBounds(170, 55, 20, 20);
                }else{
                    input1Label.setBounds(170,41,20,20);
                    input2Label.setVisible(false);
                }
            } else if (row == 2) {
                img.setBounds(180, 102, 60, 60);
                outputLabel.setBounds(248, 121, 20, 20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(170, 105, 20, 20);
                    input2Label.setBounds(170,135,20,20);
                }else{
                    input1Label.setBounds(170,121,20,20);
                    input2Label.setVisible(false);
                }
            } else if (row == 3) {
                img.setBounds(180, 182, 60, 60);
                outputLabel.setBounds(248,201,20,20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(170, 185, 20, 20);
                    input2Label.setBounds(170, 215, 20, 20);
                }else{
                    input1Label.setBounds(170,201,20,20);
                    input2Label.setVisible(false);
                }

            } else if (row == 4) {
                img.setBounds(180, 262, 60, 60);
                outputLabel.setBounds(248, 281, 20, 20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(170, 265, 20, 20);
                    input2Label.setBounds(170, 295, 20, 20);
                }else{
                    input1Label.setBounds(170, 281, 20, 20);
                    input2Label.setVisible(false);
                }
            } else if (row == 5) {
                img.setBounds(180, 342, 60, 60);
                outputLabel.setBounds(248, 361, 20, 20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(170, 345, 20, 20);
                    input2Label.setBounds(170, 375, 20, 20);
                }else{
                    input1Label.setBounds(170, 361, 20, 20);
                    input2Label.setVisible(false);
                }
            } else if (row == 6) {
                img.setBounds(180, 422, 60, 60);
                outputLabel.setBounds(248, 441, 20, 20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(170, 425, 20, 20);
                    input2Label.setBounds(170, 455, 20, 20);
                }else{
                    input1Label.setBounds(170, 441, 20, 20);
                    input2Label.setVisible(false);
                }
            }
        }
        else if (collumn == 2) {
            if (row == 1) {
                img.setBounds(380, 22, 60, 60);
                outputLabel.setBounds(448, 41, 20, 20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(370, 25, 20, 20);
                    input2Label.setBounds(370, 55, 20, 20);
                }else{
                    input1Label.setBounds(370,41,20,20);
                    input2Label.setVisible(false);
                }
            } else if (row == 2) {
                img.setBounds(380, 102, 60, 60);
                outputLabel.setBounds(448, 121, 20, 20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(370, 105, 20, 20);
                    input2Label.setBounds(370,135,20,20);
                }else{
                    input1Label.setBounds(370,121,20,20);
                    input2Label.setVisible(false);
                }
            } else if (row == 3) {
                img.setBounds(380, 182, 60, 60);
                outputLabel.setBounds(448,201,20,20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(370, 185, 20, 20);
                    input2Label.setBounds(370, 215, 20, 20);
                }else{
                    input1Label.setBounds(370,201,20,20);
                    input2Label.setVisible(false);
                }

            } else if (row == 4) {
                img.setBounds(380, 262, 60, 60);
                outputLabel.setBounds(448, 281, 20, 20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(370, 265, 20, 20);
                    input2Label.setBounds(370, 295, 20, 20);
                }else{
                    input1Label.setBounds(370, 281, 20, 20);
                    input2Label.setVisible(false);
                }
            } else if (row == 5) {
                img.setBounds(380, 342, 60, 60);
                outputLabel.setBounds(448, 361, 20, 20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(370, 345, 20, 20);
                    input2Label.setBounds(370, 375, 20, 20);
                }else{
                    input1Label.setBounds(370, 361, 20, 20);
                    input2Label.setVisible(false);
                }
            } else if (row == 6) {
                img.setBounds(380, 422, 60, 60);
                outputLabel.setBounds(448, 441, 20, 20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(370, 425, 20, 20);
                    input2Label.setBounds(370, 455, 20, 20);
                }else{
                    input1Label.setBounds(370, 441, 20, 20);
                    input2Label.setVisible(false);
                }
            }
        } else if (collumn == 3) {
            if (row == 1) {
                img.setBounds(580, 22, 60, 60);
                outputLabel.setBounds(648, 41, 20, 20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(570, 25, 20, 20);
                    input2Label.setBounds(570, 55, 20, 20);
                }else{
                    input1Label.setBounds(570,41,20,20);
                    input2Label.setVisible(false);
                }
            } else if (row == 2) {
                img.setBounds(580, 102, 60, 60);
                outputLabel.setBounds(648, 121, 20, 20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(570, 105, 20, 20);
                    input2Label.setBounds(570,135,20,20);
                }else{
                    input1Label.setBounds(570,121,20,20);
                    input2Label.setVisible(false);
                }
            } else if (row == 3) {
                img.setBounds(580, 182, 60, 60);
                outputLabel.setBounds(648,201,20,20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(570, 185, 20, 20);
                    input2Label.setBounds(570, 215, 20, 20);
                }else{
                    input1Label.setBounds(570,201,20,20);
                    input2Label.setVisible(false);
                }

            } else if (row == 4) {
                img.setBounds(580, 262, 60, 60);
                outputLabel.setBounds(648, 281, 20, 20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(570, 265, 20, 20);
                    input2Label.setBounds(570, 295, 20, 20);
                }else{
                    input1Label.setBounds(570, 281, 20, 20);
                    input2Label.setVisible(false);
                }
            } else if (row == 5) {
                img.setBounds(580, 342, 60, 60);
                outputLabel.setBounds(648, 361, 20, 20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(570, 345, 20, 20);
                    input2Label.setBounds(570, 375, 20, 20);
                }else{
                    input1Label.setBounds(570, 361, 20, 20);
                    input2Label.setVisible(false);
                }
            } else if (row == 6) {
                img.setBounds(580, 422, 60, 60);
                outputLabel.setBounds(648, 441, 20, 20);
                if(!(label.equals("NOT"))) {
                    input1Label.setBounds(570, 425, 20, 20);
                    input2Label.setBounds(570, 455, 20, 20);
                }else{
                    input1Label.setBounds(570, 441, 20, 20);
                    input2Label.setVisible(false);
                }
            }
        }

        img.setIcon(icon);
        breadboardPanel.add(input1Label);
        breadboardPanel.add(input2Label);
        breadboardPanel.add(outputLabel);
        breadboardPanel.add(img);
        breadboardPanel.revalidate();
        breadboardPanel.repaint();

    }

    public void createLabel(Container container,JLabel label, int x,int y,int width ,int height){
        label.setBounds(x,y,width,height);
        label.setVisible(true);
        container.add(label);

    }


}
