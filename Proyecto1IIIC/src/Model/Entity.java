/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class Entity {

    private int id;
    private long legalId;
    private String name;
    private String email;
    private int phoneNumber;
    private String address;
    private String description;

    public Entity(int id, long legalId, String name, String email, int phoneNumber, String address, String description) {
        this.id = id;
        this.legalId = legalId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.description = description;
    }

    public Entity(long legalId, String name, String email, int phoneNumber, String address, String description) {
        this.legalId = legalId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.description = description;
    }

   

    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }
    

    public Entity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getLegalId() {
        return legalId;
    }

    public void setLegalId(long legalId) {
        this.legalId = legalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

}
