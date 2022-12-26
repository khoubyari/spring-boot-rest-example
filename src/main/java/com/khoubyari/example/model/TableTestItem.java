package com.khoubyari.example.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class TableTestItem {

    @JsonProperty("desc")
    private String description;

    @JsonProperty("no")
    private String number;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "TableTestItem{" +
                "description='" + description + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
