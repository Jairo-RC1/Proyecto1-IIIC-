/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class ProvinceComboBoxListener implements ActionListener {

    private CtrlSamplingSite ctss;
    private JComboBox<String> countyComboBox;
// Constructor to initialize the listener with the controller and JComboBox
    public ProvinceComboBoxListener(CtrlSamplingSite ctss, JComboBox<String> countyComboBox) {
        this.ctss = ctss;
        this.countyComboBox = countyComboBox;
    }

    @Override
    // Get the selected province from the event source
    public void actionPerformed(ActionEvent e) {
        Object selectedProvinceObject = ((JComboBox) e.getSource()).getSelectedItem();
        if (selectedProvinceObject != null) {
            String selectedProvince = selectedProvinceObject.toString();

           // Continue processing by loading counties into the countyComboBox
            ctss.loadCountiesToSamplingCountyComboBox(countyComboBox, selectedProvince);
        }
    }

}
