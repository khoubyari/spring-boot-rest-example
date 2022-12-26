package com.khoubyari.example.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class CardholderName<T> {

    @JsonProperty("key")
    public T key;

    public T getKey(){
        return key;
    }

    @Override
    public String toString() {
        return "CardholderName{" +
                "key=" + key +
                '}';
    }
}
