package com.khoubyari.example.model;

import java.io.Serializable;

public class Template implements Serializable {

    public String firstName;

    public String alertTypeCode;
    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getAlertTypeCode() { return alertTypeCode; }

    public void setAlertTypeCode(String alertTypeCode) { this.alertTypeCode = alertTypeCode; }
}