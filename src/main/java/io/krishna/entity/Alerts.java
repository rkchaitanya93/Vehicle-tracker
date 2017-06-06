package io.krishna.entity;

import javax.persistence.*;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Created by Krishna on 6/6/2017.
 */
@Entity
public class Alerts {


    @Id
    @Column(columnDefinition = "varchar(36)")
    private String id;
    public Alerts() {
        this.id = UUID.randomUUID().toString();
    }
    private String alertVin;
    private ZonedDateTime alertTimeStamp;
    private String alertMessage;
    private String priority;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAlertVin() {
        return alertVin;
    }
    public void setAlertVin(String alertVin) {
        this.alertVin = alertVin;
    }

    public ZonedDateTime getAlertTimeStamp() {
        return alertTimeStamp;
    }
    public void setAlertTimeStamp(ZonedDateTime alertTimeStamp) {
        this.alertTimeStamp = alertTimeStamp;
    }
    public String getAlertMessage() {
        return alertMessage;
    }
    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }




}
