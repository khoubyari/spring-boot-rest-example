package com.khoubyari.example.model;

import java.io.Serializable;
import java.util.List;

public class Template3 implements Serializable {

    public String firstName;

    public String alertTypeCode;

    private String lastFour;

    private String icceUrl;

    private String clientName;

    private String bodyMod;

    private List<TableTestItem> tableTestItemList;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAlertTypeCode() {
        return alertTypeCode;
    }

    public void setAlertTypeCode(String alertTypeCode) {
        this.alertTypeCode = alertTypeCode;
    }

    public String getLastFour() {
        return lastFour;
    }

    public void setLastFour(String lastFour) {
        this.lastFour = lastFour;
    }

    public String getIcceUrl() {
        return icceUrl;
    }

    public void setIcceUrl(String icceUrl) {
        this.icceUrl = icceUrl;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getBodyMod() {
        return bodyMod;
    }

    public void setBodyMod(String bodyMod) {
        this.bodyMod = bodyMod;
    }

    public List<TableTestItem> getTableTestItemList() {
        return tableTestItemList;
    }

    public void setTableTestItemList(List<TableTestItem> tableTestItemList) {
        this.tableTestItemList = tableTestItemList;
    }
}