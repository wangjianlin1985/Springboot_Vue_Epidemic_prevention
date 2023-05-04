package com.design.covid9server.entity;

import java.util.Date;

public class CheckRecord {
    private Integer id;

    private Integer patientId;

    private String checkType;

    private String result;

    private Date checkDate;

    private Integer orderNo;

    private String patientName;

    private PatientL1 patientL1;

    private PatientL3 patientL3;

    public PatientL3 getPatientL3() {
        return patientL3;
    }

    public void setPatientL3(PatientL3 patientL3) {
        this.patientL3 = patientL3;
    }

    private int patientLevel;

    public int getPatientLevel() {
        return patientLevel;
    }

    public void setPatientLevel(int patientLevel) {
        this.patientLevel = patientLevel;
    }

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

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType == null ? null : checkType.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public PatientL1 getPatientL1() {
        return patientL1;
    }

    public void setPatientL1(PatientL1 patientL1) {
        this.patientL1 = patientL1;
    }
}