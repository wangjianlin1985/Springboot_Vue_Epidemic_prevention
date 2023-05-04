package com.design.covid9server.entity;

import java.util.Date;

public class WatchL3 {
    private Integer id;

    private Integer patientId;

    private Date startDate;

    private Date test4Date;

    private String test4Result;

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

    public Date getTest4Date() {
        return test4Date;
    }

    public void setTest4Date(Date test4Date) {
        this.test4Date = test4Date;
    }

    public String getTest4Result() {
        return test4Result;
    }

    public void setTest4Result(String test4Result) {
        this.test4Result = test4Result == null ? null : test4Result.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}