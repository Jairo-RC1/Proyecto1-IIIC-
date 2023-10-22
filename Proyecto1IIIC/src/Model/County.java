/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class County {
    private int id;
    private String name;
    private int provinceId;

    public County(int id, String name, int provinceId) {
        this.id = id;
        this.name = name;
        this.provinceId = provinceId;
    }

    public County(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
    // Getter method to retrieve the ID of the county
    public int getId() {
        return id;
    }
    // Setter method to set the ID of the county
    public void setId(int id) {
        this.id = id;
    }
    
    // Getter method to retrieve the name of the county
    public String getName() {
        return name;
    }
    // Setter method to set the name of the county
    public void setName(String name) {
        this.name = name;
    }
    // Getter method to retrieve the ID of the province to which the county belongs
    public int getProvinceId() {
        return provinceId;
    }
      // Setter method to set the ID of the province to which the county belongs
    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
