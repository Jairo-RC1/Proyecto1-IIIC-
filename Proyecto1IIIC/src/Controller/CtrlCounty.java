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

    public void loadCountiesToSamplingCountyComboBox(JComboBox<String> comboBox, String selectedProvince) {
        CountyDAO CountyDAO = new CountyDAO();
        List<County> counties = CountyDAO.getCountiesForProvince(selectedProvince);

        comboBox.removeAllItems(); // Limpia el ComboBox

        for (County county : counties) {
            comboBox.addItem(county.getName());
        }
    }
}
