/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class FlowWithWaterSpring {
    private int flowid;
    private String capacity;
    private String waterSpringName;
      // Constructor to initialize the object with flow information
    public FlowWithWaterSpring(int flowid, String capacity, String waterSpringName) {
        this.flowid = flowid;
        this.capacity = capacity;
        this.waterSpringName = waterSpringName;
    }
     // Getter method for retrieving the flow identifier
    public int getFlowid() {
        return flowid;
    }
    // Setter method to set the flow identifier
    public void setFlowid(int flowid) {
        this.flowid = flowid;
    }
     // Getter method for retrieving the flow capacity
    public String getCapacity() {
        return capacity;
    }
    // Setter method to set the flow capacity
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    // Getter method for retrieving the associated water spring's name
    public String getWaterSpringName() {
        return waterSpringName;
    }
    // Setter method to set the associated water spring's name
    public void setWaterSpringName(String waterSpringName) {
        this.waterSpringName = waterSpringName;
    }
}
