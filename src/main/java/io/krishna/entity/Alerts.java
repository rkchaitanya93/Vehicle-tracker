package io.krishna.entity;

import javax.persistence.*;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;


@Entity
public class Alerts {


    @Id
    @Column(columnDefinition = "varchar(36)")
    private String id;
    public Alerts() {
        this.id = UUID.randomUUID().toString();
    }
    private String alertVin;
    private Date alertTimeStamp;
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

    public Date getAlertTimeStamp() {
        return alertTimeStamp;
    }
    public void setAlertTimeStamp(Date alertTimeStamp) {
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
