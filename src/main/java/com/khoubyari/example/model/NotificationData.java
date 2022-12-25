package com.khoubyari.example.model;

import java.io.Serializable;

public class NotificationData implements Serializable {

    public String key;

    public String value;

    public String valueType;

    public String getKey() { return key; }

    public void setKey(String a) { this.key = key; }

    public String getValue() { return value; }

    public void setValue(String mohasin) { this.value = value; }

    public String getValueType() { return valueType; }

    public void setValueType(String looparray) { this.valueType = valueType; }

}