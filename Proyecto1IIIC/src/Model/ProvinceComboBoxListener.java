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

    public ProvinceComboBoxListener(CtrlSamplingSite ctss, JComboBox<String> countyComboBox) {
        this.ctss = ctss;
        this.countyComboBox = countyComboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object selectedProvinceObject = ((JComboBox) e.getSource()).getSelectedItem();
        if (selectedProvinceObject != null) {
            String selectedProvince = selectedProvinceObject.toString();

            // Continuar con el procesamiento
            ctss.loadCountiesToSamplingCountyComboBox(countyComboBox, selectedProvince);
        }
    }

}
