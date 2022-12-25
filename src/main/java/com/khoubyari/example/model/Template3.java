package com.khoubyari.example.model;

import java.io.Serializable;
import java.util.List;

public class Template3 implements Serializable {

    public String firstName;

    public String alertTypeCode;

    public List<TestItem> testItems;

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getAlertTypeCode() { return alertTypeCode; }

    public void setAlertTypeCode(String alertTypeCode) { this.alertTypeCode = alertTypeCode; }

    public List<TestItem> getTestItems() { return testItems; }

    public void setTestItems(List<TestItem> testItems) { this.testItems = testItems; }

}