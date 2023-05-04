package com.design.covid9server.entity;

import java.util.Date;

public class WatchL2 {
    private Integer id;

    private Integer patientId;

    private Date startDate;

    private Date test3Date;

    private String test3Result;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getTest3Date() {
        return test3Date;
    }

    public void setTest3Date(Date test3Date) {
        this.test3Date = test3Date;
    }

    public String getTest3Result() {
        return test3Result;
    }

    public void setTest3Result(String test3Result) {
        this.test3Result = test3Result == null ? null : test3Result.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}