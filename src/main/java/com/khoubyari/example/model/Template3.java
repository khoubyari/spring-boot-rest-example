package com.khoubyari.example.model;

import java.util.List;

public class Template3 extends Template {
    private String lastFour;

    private String icceUrl;

    private String clientName;

    private String bodyMod;

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

    public List<TableTestItem> getTableTestItemList() {
        return tableTestItemList;
    }

    public void setTableTestItemList(List<TableTestItem> tableTestItemList) {
        this.tableTestItemList = tableTestItemList;
    }

    @Override
    public String toString() {
        return "Template3{" +
                "firstName='" + firstName + '\'' +
                ", alertTypeCode='" + alertTypeCode + '\'' +
                ", lastFour='" + lastFour + '\'' +
                ", icceUrl='" + icceUrl + '\'' +
                ", clientName='" + clientName + '\'' +
                ", bodyMod='" + bodyMod + '\'' +
                ", tableTestItemList=" + tableTestItemList +
                '}';
    }
}