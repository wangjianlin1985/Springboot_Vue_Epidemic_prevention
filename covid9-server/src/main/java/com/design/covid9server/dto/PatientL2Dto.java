package com.design.covid9server.dto;

public class PatientL2Dto {

    private long count;

    private String fromCity;

    private String gender;

    private long age0020;

    private long age2040;

    private long age4060;

    private long age6080;

    private long age80150;

    public long getAge0020() {
        return age0020;
    }

    public void setAge0020(long age0020) {
        this.age0020 = age0020;
    }

    public long getAge2040() {
        return age2040;
    }

    public void setAge2040(long age2040) {
        this.age2040 = age2040;
    }

    public long getAge4060() {
        return age4060;
    }

    public void setAge4060(long age4060) {
        this.age4060 = age4060;
    }

    public long getAge6080() {
        return age6080;
    }

    public void setAge6080(long age6080) {
        this.age6080 = age6080;
    }

    public long getAge80150() {
        return age80150;
    }

    public void setAge80150(long age80150) {
        this.age80150 = age80150;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }
}
