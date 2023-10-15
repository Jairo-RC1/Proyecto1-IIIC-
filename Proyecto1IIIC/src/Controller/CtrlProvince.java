/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DBConnectionJava;
import Model.Province;
import Model.ProvinceDAO;
import javax.swing.JComboBox;
import java.util.List;

public class CtrlProvince {

    public void loadProvincesToComboBox(JComboBox<String> comboBox) {
        ProvinceDAO provinceDao = new ProvinceDAO();
        List<Province> provinces = provinceDao.readProvinces();

        comboBox.removeAllItems(); // Limpia el ComboBox

        for (Province province : provinces) {
            comboBox.addItem(province.getName());
        }
    }
}
