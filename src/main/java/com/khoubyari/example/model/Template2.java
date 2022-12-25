package com.khoubyari.example.model;


import java.io.Serializable;
import java.util.List;

public class Template2 implements Serializable {

    public String firstName;

    public String alertTypeCode;

    public List<CardholderName> cardholderNames;

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getAlertTypeCode() { return alertTypeCode; }

    public void setAlertTypeCode(String alertTypeCode) { this.alertTypeCode = alertTypeCode; }

    public List<CardholderName> getCardholderNames() { return cardholderNames; }

    public void setCardholderNames(List<CardholderName> cardholderNames) { this.cardholderNames = cardholderNames; }

}