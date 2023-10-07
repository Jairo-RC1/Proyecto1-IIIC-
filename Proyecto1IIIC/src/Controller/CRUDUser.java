/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import java.util.HashMap;
import java.util.Map;

public class CRUDUser {

    Map<Integer, User> userMap = new HashMap<>();
    String message = "";
    private int nextUserId = 1;

    public CRUDUser() {
    }

    // Method to add a new user
    public String addUser(String name, String firstName, String lastname, int id, String email, String password, String entityId, String roleId) {
        int newId = nextUserId; // Assign the next available ID
        nextUserId++; // Increment the ID counter

        User newUser = new User(newId, name, firstName, lastname, email, password, entityId, roleId);
        userMap.put(newUser.getId(), newUser);
        return "User added successfully";
    }

    // Method to edit an existing user
    public String editUser(int idToUpdate, String name, String firstName, String lastname, int id, String password, String entityId, String roleId) {
        if (userMap.containsKey(idToUpdate)) {
            User updatedUser = userMap.get(idToUpdate);
            updatedUser.setName(name);
            updatedUser.setPassword(password);
            updatedUser.setRoleId(roleId);
            userMap.put(idToUpdate, updatedUser);
            this.message = "User updated successfully.";
        } else {
            this.message = "The searched user does not exist.";
        }
        return this.message;
    }

    // Method to delete a user
    public String deleteUser(int idToDelete) {

        if (userMap.containsKey(idToDelete)) {
            userMap.remove(idToDelete);
            this.message = "The user has been deleted.";
        } else {
            this.message = "The searched user does not exist.";
        }

        return this.message;
    }

    // Method to validate user access
    public boolean validateAccess(String userName, String password) {
        boolean value = false;
        if (this.searchUser(userMap, userName, password)) {
            return true;
        }
        return value;
    }

    // Method to search for a user's role
    private boolean searchUser(Map<Integer, User> userMap, String name, String password) {
        for (User user : userMap.values()) {
            if (user.getFirstName().equals(name) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Private method to search for a user by name
    public String searchUserRole(String firstName) {
        for (User user : this.userMap.values()) {
            if (user.getFirstName().equals(firstName)) {
                this.message = user.getRoleId();
            }
        }
        return this.message;
    }
}
