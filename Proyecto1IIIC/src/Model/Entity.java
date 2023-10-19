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
    
     // Default constructor  
    public Entity() {
    }
    // Getter method for retrieving the entity's ID
    public int getId() {
        return id;
    }
    // Setter method for setting the entity's ID
    public void setId(int id) {
        this.id = id;
    }
    // Getter method for retrieving the entity's legal ID
    public long getLegalId() {
        return legalId;
    }
    // Setter method for setting the entity's legal ID
    public void setLegalId(long legalId) {
        this.legalId = legalId;
    }
    // Getter method for retrieving the entity's name
    public String getName() {
        return name;
    }
    // Setter method for setting the entity's name
    public void setName(String name) {
        this.name = name;
    }
    // Getter method for retrieving the entity's email
    public String getEmail() {
        return email;
    }
    // Setter method for setting the entity's email
    public void setEmail(String email) {
        this.email = email;
    }
    // Getter method for retrieving the entity's phone number
    public int getPhoneNumber() {
        return phoneNumber;
    }
     // Setter method for setting the entity's phone number
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
     // Getter method for retrieving the entity's address
    public String getAddress() {
        return address;
    }
     // Setter method for setting the entity's address
    public void setAddress(String address) {
        this.address = address;
    }
     // Getter method for retrieving the entity's description
    public String getDescription() {
        return description;
    }
    // Setter method for setting the entity's description
    public void setDescription(String description) {
        this.description = description;
    }

    

}
