/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;


public class Flow {
    
    private int id;
    private String capacity;
    private String method;
    private String observation;
    private Date date;
    private String climate;
    private String done;
    private int waterSpringId;
    private int samplingId;
    // Parameterized constructor for creating a Flow instance
    public Flow(String capacity, String method, String observation, Date date, String climate, String done, int waterSpringId, int samplingId) {
        this.capacity = capacity;
        this.method = method;
        this.observation = observation;
        this.date = date;
        this.climate = climate;
        this.done = done;
        this.waterSpringId = waterSpringId;
        this.samplingId = samplingId;
    }
      // Parameterized constructor for creating a Flow instance with an ID
    public Flow(int id, String capacity, String method, String observation, Date date, String climate, String done, int waterSpringId, int samplingId) {
        this.id = id;
        this.capacity = capacity;
        this.method = method;
        this.observation = observation;
        this.date = date;
        this.climate = climate;
        this.done = done;
        this.waterSpringId = waterSpringId;
        this.samplingId = samplingId;
    }
    
    public Flow(){}
    // Getter and setter methods for class attributes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public int getWaterSpringId() {
        return waterSpringId;
    }

    public void setWaterSpringId(int waterSpringId) {
        this.waterSpringId = waterSpringId;
    }

    public int getSamplingId() {
        return samplingId;
    }

    public void setSamplingId(int samplingId) {
        this.samplingId = samplingId;
    }
}
