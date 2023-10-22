/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.*;
import javax.swing.JTextField;

public class CapacityButtonListener implements ActionListener {
    private CtrlFlow ctf;
    private JTextField capacityField;

    public CapacityButtonListener(CtrlFlow ctf, JTextField capacityField) {
        this.ctf = ctf;
        this.capacityField = capacityField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Call the method to generate a random capacity and set it in the text field
        ctf.generateRandomCapacity(capacityField);
    }
}
