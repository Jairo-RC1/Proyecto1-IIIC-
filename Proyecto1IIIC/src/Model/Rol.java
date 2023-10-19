/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Rol {
    
    private int id;
    private String name;
   // Constructor to initialize a Rol object with an ID and name
    public Rol(int id, String name) {
        this.id = id;
        this.name = name;
    }
     // Getter method to retrieve the ID of the Rol
    public int getId() {
        return id;
    }
    // Setter method to set the ID of the Rol
    public void setId(int id) {
        this.id = id;
    }
     // Getter method to retrieve the name of the Rol
    public String getName() {
        return name;
    }
    // Setter method to set the name of the Rol
    public void setName(String name) {
        this.name = name;
    }
    
}
