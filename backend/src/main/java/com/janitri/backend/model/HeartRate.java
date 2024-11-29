package com.janitri.backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity(name = "heartRateData")
public class HeartRate {
    @Id
    @UuidGenerator
    private String heartrateId;

    private int heartRate;
    private LocalDateTime timestamp;

    private String status;

    private String monitoringDeviceId;

    private String monitoringDeviceType;

    private String activityType;

    private double bodyTemperature;

    private Boolean regular;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    public String getHeartrateId() {
        return heartrateId;
    }

    public void setHeartrateId(String heartrateId) {
        this.heartrateId = heartrateId;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMonitoringDeviceId() {
        return monitoringDeviceId;
    }

    public void setMonitoringDeviceId(String monitoringDeviceId) {
        this.monitoringDeviceId = monitoringDeviceId;
    }

    public String getMonitoringDeviceType() {
        return monitoringDeviceType;
    }

    public void setMonitoringDeviceType(String monitoringDeviceType) {
        this.monitoringDeviceType = monitoringDeviceType;
    }

    public Boolean getRegular() {
        return regular;
    }

    public void setRegular(Boolean regular) {
        this.regular = regular;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }



    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


}
