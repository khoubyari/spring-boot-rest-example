package com.khoubyari.example.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdatedInfoItem<T> {

    @JsonProperty("value")
    private T value;

    public T getValue(){
        return value;
    }
}
