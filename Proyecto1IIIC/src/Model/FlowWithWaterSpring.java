/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class FlowWithWaterSpring {
    private int flowid;
    private String capacity;
    private String waterSpringName;

    public FlowWithWaterSpring(int flowid, String capacity, String waterSpringName) {
        this.flowid = flowid;
        this.capacity = capacity;
        this.waterSpringName = waterSpringName;
    }

    public int getFlowid() {
        return flowid;
    }

    public void setFlowid(int flowid) {
        this.flowid = flowid;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getWaterSpringName() {
        return waterSpringName;
    }

    public void setWaterSpringName(String waterSpringName) {
        this.waterSpringName = waterSpringName;
    }

    
    
}
