/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class SamplingSite {

    private int id;
    private String name;
    private int provinceId;
    private int countyId;
    private int districtId;
    private int entityId;
    // Constructor to create a SamplingSite with essential information
    public SamplingSite(String name, int provinceId, int countyId, int districtId, int entityId) {
        this.name = name;
        this.provinceId = provinceId;
        this.countyId = countyId;
        this.districtId = districtId;
        this.entityId = entityId;
    }
    // Constructor to create a SamplingSite with an ID and full information
    public SamplingSite(int id, String name, int provinceId, int countyId, int districtId, int entityId) {
        this.id = id;
        this.name = name;
        this.provinceId = provinceId;
        this.countyId = countyId;
        this.districtId = districtId;
        this.entityId = entityId;
    }
     // Getter method to retrieve the ID of the SamplingSite
    public int getId() {
        return id;
    }
    // Setter method to set the ID of the SamplingSite
    public void setId(int id) {
        this.id = id;
    }
    // Getter method to retrieve the name of the SamplingSite
    public String getName() {
        return name;
    }
    // Setter method to set the name of the SamplingSite
    public void setName(String name) {
        this.name = name;
    }
    // Getter method to retrieve the province ID
    public int getProvinceId() {
        return provinceId;
    }
    
    // Setter method to set the province ID
    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
    // Getter method to retrieve the county ID
    public int getCountyId() {
        return countyId;
    }
    // Setter method to set the county ID
    public void setCountyId(int countyId) {
        this.countyId = countyId;
    }
     // Getter method to retrieve the district ID
    public int getDistrictId() {
        return districtId;
    }
     // Setter method to set the district ID
    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }
    // Getter method to retrieve the entity ID
    public int getEntityId() {
        return entityId;
    }
    // Setter method to set the entity ID
    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

}
