/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.*;
import javax.swing.JTextField;

public class DateButtonListener implements ActionListener {

    private CtrlFlow ctf;
    private JTextField dateField;

    public DateButtonListener(CtrlFlow ctf, JTextField dateField) {
        this.ctf = ctf;
        this.dateField = dateField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (dateField != null) {
            // Call the method to generate a random date and set it in the text field
            ctf.generateRandomDate(dateField);
        } else {
        }
    }

}
