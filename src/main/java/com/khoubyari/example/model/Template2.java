package com.khoubyari.example.model;

import java.util.List;

public class Template2 extends Template {

    public List<CardholderName> cardholderNames;

    public List<CardholderName> getCardholderNames() { return cardholderNames; }

    public void setCardholderNames(List<CardholderName> cardholderNames) { this.cardholderNames = cardholderNames; }

    @Override
    public String toString() {
        return "Template2{" +
                "firstName='" + firstName + '\'' +
                ", alertTypeCode='" + alertTypeCode + '\'' +
                ", cardholderNames=" + cardholderNames +
                '}';
    }
}