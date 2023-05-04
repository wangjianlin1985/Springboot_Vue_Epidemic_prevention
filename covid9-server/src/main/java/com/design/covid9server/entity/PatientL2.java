package com.design.covid9server.entity;

import java.util.Date;

public class PatientL2 {
    private Integer id;

    private String name;

    private String gender;

    private Integer age;

    private String idcardNo;

    private String hotCough;

    private String fromCity;

    private Date setoutDate;

    private Integer trafficType;

    private String trafficNo;

    private String sitNo;

    private Integer status;

    private int currPage;

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo == null ? null : idcardNo.trim();
    }

    public String getHotCough() {
        return hotCough;
    }

    public void setHotCough(String hotCough) {
        this.hotCough = hotCough == null ? null : hotCough.trim();
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity == null ? null : fromCity.trim();
    }

    public Date getSetoutDate() {
        return setoutDate;
    }

    public void setSetoutDate(Date setoutDate) {
        this.setoutDate = setoutDate;
    }

    public Integer getTrafficType() {
        return trafficType;
    }

    public void setTrafficType(Integer trafficType) {
        this.trafficType = trafficType;
    }

    public String getTrafficNo() {
        return trafficNo;
    }

    public void setTrafficNo(String trafficNo) {
        this.trafficNo = trafficNo == null ? null : trafficNo.trim();
    }

    public String getSitNo() {
        return sitNo;
    }

    public void setSitNo(String sitNo) {
        this.sitNo = sitNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}