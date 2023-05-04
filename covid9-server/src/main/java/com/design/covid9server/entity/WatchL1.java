package com.design.covid9server.entity;

import java.util.Date;

public class WatchL1 {

    private Integer id;

    private Integer patientId;

    private Date startDate;

    private Date test1Date;

    private String test1Result;

    private Date test2Date;

    private String test2Result;

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

    public Date getTest1Date() {
        return test1Date;
    }

    public void setTest1Date(Date test1Date) {
        this.test1Date = test1Date;
    }

    public String getTest1Result() {
        return test1Result;
    }

    public void setTest1Result(String test1Result) {
        this.test1Result = test1Result == null ? null : test1Result.trim();
    }

    public Date getTest2Date() {
        return test2Date;
    }

    public void setTest2Date(Date test2Date) {
        this.test2Date = test2Date;
    }

    public String getTest2Result() {
        return test2Result;
    }

    public void setTest2Result(String test2Result) {
        this.test2Result = test2Result == null ? null : test2Result.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}