/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class District {
    private int id;
    private String name;
    private int countyId;

    public District(int id, String name, int countyId) {
        this.id = id;
        this.name = name;
        this.countyId = countyId;
    }

    public District(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    

    // Method to get the ID of the district
    public int getId() {
        return id;
    }
    // Method to set the ID of the district
    public void setId(int id) {
        this.id = id;
    }
    // Method to get the name of the district 
    public String getName() {
        return name;
    }
    
    // Method to set the name of the district
    public void setName(String name) {
        this.name = name;
    }
   // Method to get the ID of the county to which the district belongs
    public int getCountyId() {
        return countyId;
    }
    // Method to set the ID of the county to which the district belongs  
    public void setCountyId(int countyId) {
        this.countyId = countyId;
    }
    
    
    
}
