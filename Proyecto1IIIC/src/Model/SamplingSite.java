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

    public SamplingSite(String name, int provinceId, int countyId, int districtId, int entityId) {
        this.name = name;
        this.provinceId = provinceId;
        this.countyId = countyId;
        this.districtId = districtId;
        this.entityId = entityId;
    }

    public SamplingSite(int id, String name, int provinceId, int countyId, int districtId, int entityId) {
        this.id = id;
        this.name = name;
        this.provinceId = provinceId;
        this.countyId = countyId;
        this.districtId = districtId;
        this.entityId = entityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCountyId() {
        return countyId;
    }

    public void setCountyId(int countyId) {
        this.countyId = countyId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

}
