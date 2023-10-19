/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class WaterSpring {

    private int id;
    private String name;
    private String address;
    private String latitude;
    private String longitude;
    private String description;
    private int provinceId;
    private int countyId;
    private int districtId;
    private int entityId;
    // Constructor to create a WaterSpring with essential information
    public WaterSpring(String name, String address, String latitude, String longitude, String description, int provinceId, int countyId, int districtId, int entityId) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.provinceId = provinceId;
        this.countyId = countyId;
        this.districtId = districtId;
        this.entityId = entityId;
    }
    // Constructor to create a WaterSpring with an ID and full information
    public WaterSpring(int id, String name, String address, String latitude, String longitude, String description, int provinceId, int countyId, int districtId, int entityId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.provinceId = provinceId;
        this.countyId = countyId;
        this.districtId = districtId;
        this.entityId = entityId;
    }

    public WaterSpring(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    

    public WaterSpring() {
    }
    // Getter method to retrieve the ID of the WaterSpring
    public int getId() {
        return id;
    }
    // Setter method to set the ID of the WaterSpring
    public void setId(int id) {
        this.id = id;
    }
    // Getter method to retrieve the name of the WaterSpring
    public String getName() {
        return name;
    }
    // Setter method to set the name of the WaterSpring
    public void setName(String name) {
        this.name = name;
    }
    // Getter method to retrieve the address of the WaterSpring
    public String getAddress() {
        return address;
    }
    // Setter method to set the address of the WaterSpring
    public void setAddress(String address) {
        this.address = address;
    }
    // Getter method to retrieve the latitude of the WaterSpring
    public String getLatitude() {
        return latitude;
    }
    // Setter method to set the latitude of the WaterSpring
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    // Getter method to retrieve the longitude of the WaterSpring
    public String getLongitude() {
        return longitude;
    }
    // Setter method to set the longitude of the WaterSpring
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    // Getter method to retrieve the description of the WaterSpring
    public String getDescription() {
        return description;
    }
  // Setter method to set the description of the WaterSpring
    public void setDescription(String description) {
        this.description = description;
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
