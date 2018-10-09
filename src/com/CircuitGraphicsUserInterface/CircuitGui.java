package com.CircuitGraphicsUserInterface;

import com.CircuitEngine.Breadboard;
import com.CircuitEngine.Circuit;
import com.CircuitEngine.Gate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CircuitGui extends JFrame {

    private Circuit         circuit;
    private Breadboard      bb;
    private JButton         btnAND,btnOR,btnNOT,btnNAND,btnNOR,btnXOR,btnXNOR,btnRUN,btnRESET;
    public  MyPanel         canvasPanel;
    private JComboBox       comboBox1 ,comboBox2 ,comboBox3 ,comboBox4 , comboBox5,comboBox6;
    private String[]        array = {"False" ,"True"};
    private static String[] inputComboItem = new String[6];

    public static String getInputComboItem(int index) {
        return inputComboItem[index];
    }

    public void setInputComboItem(int index, String state) {
        inputComboItem[index]=state;
    }

    public CircuitGui(Circuit circuit,Breadboard bb){

        super("Gate Simulator");
        this.circuit = circuit;
        this.bb = bb;

        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e) {
            e.printStackTrace();
        }

        /* The reason behind adding this block of code here instead of before
           the consructor is so that the buttons can take the system look and feel and not feel
           outdated
         */

        btnAND    = new JButton("AND");
        btnOR     = new JButton("OR");
        btnNOT    = new JButton("NOT");
        btnNAND   = new JButton("NAND");
        btnNOR    = new JButton("NOR");
        btnXOR    = new JButton("XOR");
        btnXNOR   = new JButton("XNOR");
        btnRUN    = new JButton("RUN");
        btnRESET  = new JButton("RESET");
        comboBox1 = new JComboBox(new DefaultComboBoxModel(array));
        comboBox2 = new JComboBox(new DefaultComboBoxModel(array));
        comboBox3 = new JComboBox(new DefaultComboBoxModel(array));
        comboBox4 = new JComboBox(new DefaultComboBoxModel(array));
        comboBox5 = new JComboBox(new DefaultComboBoxModel(array));
        comboBox6 = new JComboBox(new DefaultComboBoxModel(array));


        canvasPanel = new MyPanel();
        canvasPanel.setBounds(120,100,770,500);
        canvasPanel.setBackground(Color.white);
        canvasPanel.setVisible(true);
        this.add(canvasPanel);

        addCombo(comboBox1,     canvasPanel,     20,40, 50,20);
        addCombo(comboBox2,     canvasPanel,     20,120,50,20);
        addCombo(comboBox3,     canvasPanel,     20,200,50,20);
        addCombo(comboBox4,     canvasPanel,     20,280,50,20);
        addCombo(comboBox5,     canvasPanel,     20,360,50,20);
        addCombo(comboBox6,     canvasPanel,     20,440,50,20);

        addBtn(this,btnAND,     "AND",      120, 40, 100, 30,   null);
        addBtn(this,btnOR,      "OR",       220, 40, 100, 30,   null);
        addBtn(this,btnNOT,     "NOT",      320, 40, 100, 30,   null);
        addBtn(this,btnNAND,    "NAND",     420, 40, 100, 30,   null);
        addBtn(this,btnNOR,     "NOR",      520, 40, 100, 30,   null);
        addBtn(this,btnXOR,     "XOR",      620, 40, 100, 30,   null);
        addBtn(this,btnXNOR,    "XNOR",     720, 40, 100, 30,   null);
        addBtn(this,btnRUN,     "EUN",      10,  100,100, 30,   Color.red);
        addBtn(this,btnRESET,   "RESET",    10,  150,100, 30,   Color.green);

        this.setLayout(null);
        this.setResizable(false);
        this.setFont(new Font("Helvetica", Font.PLAIN, 14));
        this.setSize(920,650);
        this.addWindowListener(new CloseWindowAndExit());
        this.setVisible(true);
    }

    public void addBtn(Container container,JButton btn,String label,int x,int y,int width,int height,Color color){
        btn.setBounds(x,y,width,height);
        btn.setBackground(color);
        container.add(btn);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                if(object==btnRUN){
                    circuit.run();
                    bb.showState();
                    circuit.showState();
                    resetArray();
                }
                else if(object==btnRESET){
                    resetArray();
                    bb.pinsClear();
                    circuit.circuitClear();
                    canvasPanel.removeAll();
                    comboBox1.setSelectedItem(array[0]);
                    comboBox2.setSelectedItem(array[0]);
                    comboBox3.setSelectedItem(array[0]);
                    comboBox4.setSelectedItem(array[0]);
                    comboBox5.setSelectedItem(array[0]);
                    comboBox6.setSelectedItem(array[0]);
                    bb.setInput(0,0,Boolean.parseBoolean(array[0]));
                    bb.setInput(0,1,Boolean.parseBoolean(array[0]));
                    bb.setInput(0,2,Boolean.parseBoolean(array[0]));
                    bb.setInput(0,3,Boolean.parseBoolean(array[0]));
                    bb.setInput(0,4,Boolean.parseBoolean(array[0]));
                    bb.setInput(0,5,Boolean.parseBoolean(array[0]));
                    canvasPanel.add(comboBox1);
                    canvasPanel.add(comboBox2);
                    canvasPanel.add(comboBox3);
                    canvasPanel.add(comboBox4);
                    canvasPanel.add(comboBox5);
                    canvasPanel.add(comboBox6);
                    canvasPanel.repaint();
                }
                else{
                    new GatePopupWindow(label,canvasPanel,circuit,bb);
                }

            }
        });

    }

    public void addCombo(JComboBox component, Container container,int x,int y ,int width,int height){
        component.setFont(new Font("Helvetica", Font.PLAIN, 10));
        component.setBounds(x,y,width,height);
        component.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                if(object==comboBox1){
                    setInputComboItem(0,(String) comboBox1.getSelectedItem());
                    bb.setInput(0,0,Boolean.parseBoolean((String) comboBox1.getSelectedItem()));
                }
                else if(object==comboBox2){
                    setInputComboItem(1,(String) comboBox2.getSelectedItem());
                    bb.setInput(0,1,(Boolean.parseBoolean((String) comboBox2.getSelectedItem())));
                }
                else if(object==comboBox3){
                    setInputComboItem(2,(String) comboBox3.getSelectedItem());
                    bb.setInput(0,2,Boolean.parseBoolean((String) comboBox3.getSelectedItem()));
                }
                else if(object==comboBox4){
                    setInputComboItem(3,(String) comboBox4.getSelectedItem());
                    bb.setInput(0,3,Boolean.parseBoolean((String) comboBox4.getSelectedItem()));
                }
                else if(object==comboBox5){
                    setInputComboItem(4,(String) comboBox5.getSelectedItem());
                    bb.setInput(0,4,Boolean.parseBoolean((String) comboBox5.getSelectedItem()));
                }
                else if(object==comboBox6){
                    setInputComboItem(5,(String) comboBox6.getSelectedItem());
                    bb.setInput(0,5,Boolean.parseBoolean((String) comboBox6.getSelectedItem()));
                }
            }
        });
        container.add(component);
    }

    public void resetArray(){
        for(int i=0;i<inputComboItem.length;i++){
            inputComboItem[i]="False";
        }
    }
}

class MyPanel extends JPanel {

    public MyPanel() {
        this.setLayout(null);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        //g.drawLine(100,80,180,22);
        g.setColor(Color.gray);
        g.fillRect(95, 0, 30, 500);
        g.fillRect(295, 0, 30, 500);
        g.fillRect(495, 0, 30, 500);
        g.fillRect(695, 0, 30, 500);
        g.setColor(Color.black);
        g.fillRect(100, 40, 20, 20);
        g.fillRect(300, 40, 20, 20);
        g.fillRect(100, 120, 20, 20);
        g.fillRect(300, 120, 20, 20);
        g.fillRect(100, 200, 20, 20);
        g.fillRect(300, 200, 20, 20);
        g.fillRect(100, 280, 20, 20);
        g.fillRect(300, 280, 20, 20);
        g.fillRect(100, 360, 20, 20);
        g.fillRect(300, 360, 20, 20);
        g.fillRect(100, 440, 20, 20);
        g.fillRect(300, 440, 20, 20);
        g.fillRect(500, 40, 20, 20);
        g.fillRect(700, 40, 20, 20);
        g.fillRect(500, 120, 20, 20);
        g.fillRect(700, 120, 20, 20);
        g.fillRect(500, 200, 20, 20);
        g.fillRect(700, 200, 20, 20);
        g.fillRect(500, 280, 20, 20);
        g.fillRect(700, 280, 20, 20);
        g.fillRect(500, 360, 20, 20);
        g.fillRect(700, 360, 20, 20);
        g.fillRect(500, 440, 20, 20);
        g.fillRect(700, 440, 20, 20);
        g.setColor(Color.white);

        /*for(int i=0;i<3;i++){
            for(int j=0;j<6;j++){
                if(circuit.getGate(i,j)!=null) {
                    //g.drawLine(110+j*200, 50+ j*80, 180, 22);
                   // g.drawLine()
                }
            }
        }*/
    }
}


