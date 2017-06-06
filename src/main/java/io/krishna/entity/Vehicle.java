package io.krishna.entity;

/**
 * Created by Krishna on 5/30/2017.
 */
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {


    @Id
    private String vin;
    private String make;
    private String model;
    private int year;
    private int redlineRpm;
    private double maxFuelVolume;
    private ZonedDateTime lastServiceDate;

    public ZonedDateTime getLastServiceDate() {
        return lastServiceDate;
    }
    public void setLastServiceDate(ZonedDateTime lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getRedlineRpm() {
        return redlineRpm;
    }
    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }
    public double getMaxFuelVolume() {
        return maxFuelVolume;
    }
    public void setMaxFuelVolume(double maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }
    public String getVin() {
        return vin;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Vehicle [vin=" + vin + ", make=" + make + ", model=" + model + ", year=" + year + ", redlineRpm="
                + redlineRpm + ", maxFuelVolume=" + maxFuelVolume + ", lastServiceDate=" + lastServiceDate + "]";
    }


}