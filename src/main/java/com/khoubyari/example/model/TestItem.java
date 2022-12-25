package com.khoubyari.example.model;

import java.util.List;

public class TestItem {

    private String lastFour;

    private String icceUrl;

    private String clientName;

    private String bodyMod;

    private String firstName;

    private List<TableTestItem> tableTestItemList;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<TableTestItem> getTableTestItemList() {
        return tableTestItemList;
    }

    public void setTableTestItemList(List<TableTestItem> tableTestItemList) {
        this.tableTestItemList = tableTestItemList;
    }
}
