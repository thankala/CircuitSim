package com.CircuitGraphicsUserInterface;

import com.CircuitEngine.Breadboard;
import com.CircuitEngine.Circuit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GatePopupWindow extends JFrame {

    private String      label;
    private JComboBox   columnCombo, rowCombo, input1Combo, input2Combo, outputCombo;
    private JLabel      column, row, input1, input2, output;
    private JButton     buttonOk;
    private MyPanel     panel;
    private Breadboard  bb;
    private Circuit     circuit;
    private static String[] propertiesComboItem = {"1","1","1","1","1"};

    public static String getPropertiesComboItem(int index) {
        return propertiesComboItem[index];
    }

    public void setPropertiesComboItem(int index, String state) {
        propertiesComboItem[index] = state;
    }


    public GatePopupWindow(String label, MyPanel panel, Circuit circuit, Breadboard bb) {
        super(label + " Properties");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.label = label;
        this.panel = panel;
        this.circuit = circuit;
        this.bb = bb;

        String[] array1 = {"1", "2", "3"};
        String[] array2 = {"1", "2", "3", "4", "5", "6"};

        columnCombo  = new JComboBox(new DefaultComboBoxModel(array1));
        rowCombo     = new JComboBox(new DefaultComboBoxModel(array2));
        input1Combo  = new JComboBox(new DefaultComboBoxModel(array2));
        input2Combo  = new JComboBox(new DefaultComboBoxModel(array2));
        outputCombo  = new JComboBox(new DefaultComboBoxModel(array2));

        column  = new JLabel("Collumn");
        row     = new JLabel("Row");
        input1  = new JLabel("Input 1");
        input2  = new JLabel("Input 2");
        output  = new JLabel("Output");

        addLabel(this, column,      30, 10,     60, 60);
        addLabel(this, row,         30, 70,     60, 60);
        addLabel(this, input1,      30, 130,    60, 60);
        addLabel(this, input2,      30, 190,    60, 60);
        addLabel(this, output,      30, 250,    60, 60);

        addCombo(this, columnCombo, 200, 32,    40, 20);
        addCombo(this, rowCombo,    200, 92,    40, 20);
        addCombo(this, input1Combo, 200, 152,   40, 20);
        addCombo(this, input2Combo, 200, 212,   40, 20);
        addCombo(this, outputCombo, 200, 272,   40, 20);


        buttonOk = new JButton("Ok");
        buttonOk.setFont(new Font("Helvetica", Font.PLAIN, 13));
        buttonOk.setBounds(115, 310, 50, 30);
        buttonOk.setBackground(Color.blue);
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CircuitCanvas(getLabel(), panel, bb, circuit);
                resetComboArray();
                dispose();

            }
        });
        this.add(buttonOk);

        if(label.equals("NOT")) {
            input2.setVisible(false);
            input2Combo.setVisible(false);
            output.setBounds(30, 190, 60, 60);
            outputCombo.setBounds(200, 212,   40, 20);
        }



        this.setSize(300, 400);
        this.setLayout(null);
        this.setVisible(true);

    }

    public String getLabel() {
        return label;
    }

    public void addLabel(Container container, JLabel properties, int x, int y, int width, int height) {
        properties.setBounds(x, y, width, height);
        properties.setFont(new Font("Helvetica", Font.PLAIN, 17));
        container.add(properties);
    }

    public void addCombo(Container container, JComboBox component, int x, int y, int width, int height) {
        component.setFont(new Font("Helvetica", Font.PLAIN, 15));
        component.setBounds(x, y, width, height);
        component.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                if(object==columnCombo){
                    setPropertiesComboItem(0,(String) columnCombo.getSelectedItem());
                }
                else if(object==rowCombo){
                    setPropertiesComboItem(1,(String) rowCombo.getSelectedItem());
                }
                else if(object==input1Combo){
                    setPropertiesComboItem(2,(String) input1Combo.getSelectedItem());
                }
                else if(object==input2Combo){
                    setPropertiesComboItem(3,(String) input2Combo.getSelectedItem());
                }
                else if(object==outputCombo){
                    setPropertiesComboItem(4,(String) outputCombo.getSelectedItem());
                }
            }
        });
        container.add(component);

    }

    public void resetComboArray(){
        for(int i=0;i<propertiesComboItem.length;i++){
            propertiesComboItem[i]="1";
        }
    }
}
