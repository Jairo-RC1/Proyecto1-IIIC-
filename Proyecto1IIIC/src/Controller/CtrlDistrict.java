/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.District;
import Model.DistrictDAO;
import java.util.List;
import javax.swing.JComboBox;

public class CtrlDistrict {
    // Load district names into a JComboBox based on the selected county
    public void loadDistrictsForCounty(JComboBox<String> comboBox, String countyName) {
       
        DistrictDAO districtDAO = new DistrictDAO();
        List<District> districts = districtDAO.getDistrictsForCounty(countyName);

        comboBox.removeAllItems(); 
        // Populate the JComboBox with district names
        for (District district : districts) {
            comboBox.addItem(district.getName());
        }
    }
}
