/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jairo
 */
public class User {

    private static int NextUserId = 1;
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private int entityId;
    private int roleId;

    private static int ContIdUser = 1;

    public User(String name, String lastName, String email, String password, int entityId, int roleId) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.entityId = entityId;
        this.roleId = roleId;
    }
    
    
    
    public User(int id, String name, String lastName, String email, String password, int entityId, int roleId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.entityId = entityId;
        this.roleId = roleId;
    }

    public static int getNextUserId() {
        return NextUserId;
    }

    public static void setNextUserId(int NextUserId) {
        User.NextUserId = NextUserId;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public static int getContIdUser() {
        return ContIdUser;
    }

    public static void setContIdUser(int ContIdUser) {
        User.ContIdUser = ContIdUser;
    }

    

}
