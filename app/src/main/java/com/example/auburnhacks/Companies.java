package com.example.auburnhacks;

public class Companies {
    String sectionId;
    String compName;
    String major;
    String jobType;
    String location;
    String workAuth;

    public Companies(){

    }
    public Companies(String sectionId, String compName, String major, String jobType, String location, String workAuth) {
        this.sectionId = sectionId;
        this.compName = compName;
        this.major = major;
        this.jobType = jobType;
        this.location = location;
        this.workAuth = workAuth;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWorkAuth() {
        return workAuth;
    }

    public void setWorkAuth(String workAuth) {
        this.workAuth = workAuth;
    }
}
