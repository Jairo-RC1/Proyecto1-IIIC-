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
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String entityId;
    private String roleId;

    private static int ContIdUser = 1;

    public User(int id, String name, String firstName, String lastName, String email, String password, String entityId, String roleId) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.entityId = entityId;
        this.roleId = roleId;
    }

    public User() {

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public static int generateNextId() {
        return ContIdUser++;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + "entityId=" + entityId + ", roleId=" + roleId + '}';
    }

}
