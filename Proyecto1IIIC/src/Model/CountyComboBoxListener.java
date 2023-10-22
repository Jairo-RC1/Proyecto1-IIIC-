/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.*;
import javax.swing.JComboBox;

public class CountyComboBoxListener implements ActionListener {

    private CtrlSamplingSite ctss;
    private JComboBox<String> districtComboBox;

    public CountyComboBoxListener(CtrlSamplingSite ctss, JComboBox<String> districtComboBox) {
        this.ctss = ctss;
        this.districtComboBox = districtComboBox;
    }

    public void actionPerformed(ActionEvent e) {
        Object selectedCountyObject = ((JComboBox) e.getSource()).getSelectedItem();
        if (selectedCountyObject != null) {
            String selectedCounty = selectedCountyObject.toString();
            // Continuar con el procesamiento para cargar los distritos
            ctss.loadDistrictsToSamplingDistrictComboBox(districtComboBox, selectedCounty);
        }
    }

}
