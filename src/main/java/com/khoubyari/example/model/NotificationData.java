package com.khoubyari.example.model;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.Optional;

public class NotificationData implements Serializable {

    private String key;

    private String value;

    private String valueType;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Nullable
    public Optional<String> getValueType() {
        return Optional.ofNullable(valueType);
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }
}