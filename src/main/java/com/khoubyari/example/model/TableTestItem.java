package com.khoubyari.example.model;

public class TableTestItem {

    private String description;

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
