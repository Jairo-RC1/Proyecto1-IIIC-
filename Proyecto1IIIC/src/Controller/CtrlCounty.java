/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.County;
import Model.CountyDAO;
import java.util.List;
import javax.swing.JComboBox;

public class CtrlCounty {
    // Load county names into a JComboBox based on the selected province
    public void loadCountiesToSamplingCountyComboBox(JComboBox<String> comboBox, String selectedProvince) {
        CountyDAO CountyDAO = new CountyDAO();
        List<County> counties = CountyDAO.getCountiesForProvince(selectedProvince);

        comboBox.removeAllItems(); // Cleans ComboBox
         // Populate the JComboBox with county names
        for (County county : counties) {
            comboBox.addItem(county.getName());
        }
    }
}
