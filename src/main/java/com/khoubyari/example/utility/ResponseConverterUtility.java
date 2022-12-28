package com.khoubyari.example.utility;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.khoubyari.example.model.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class ResponseConverterUtility {

    //how in java to return different ObjectTypes in a method?? this Object returns NULL value //Vijay
    public Template test(String templateType, List<NotificationData> notificationData){
        Template template = null;
        switch(templateType){
            case "abc":
                template = new Template1();
                executeTemplate((Template1) template, notificationData);
                break;
            case "def":
                template = new Template2();
                executeTemplate((Template2) template, notificationData);
                break;
            case "ghi":
                template = new Template3();
                executeTemplate((Template3) template, notificationData);
                break;
            default:
                return null;
        }
        template.setAlertTypeCode(templateType);
        return template;
    }

    private void executeGenerics(Template template, List<NotificationData> notificationData) {
        for (NotificationData notificationDatum : notificationData) {
            if (notificationDatum.getKey().equals("firstName")) {
                template.setFirstName(notificationDatum.getValue());
            }
        }
    }

    private void executeTemplate(Template1 template, List<NotificationData> notificationData){

        for (NotificationData notificationDatum : notificationData) {
            switch (notificationDatum.getKey()) {
                case "updatedInfo":
                    Type listType = new TypeToken<ArrayList<UpdatedInfoItem>>() {
                    }.getType();
                    List<UpdatedInfoItem> test = new Gson().fromJson(notificationDatum.getValue(), listType);
                    template.setUpdatedInfo(test);
                    break;
                case "firstName":
                    template.setFirstName(notificationDatum.getValue());
                    break;
            }
        }
    }


    private void executeTemplate(Template2 template, List<NotificationData> notificationData){

        for (NotificationData notificationDatum : notificationData) {
            if (notificationDatum.getKey().equals("cardholderNames")) {
                Type listType = new TypeToken<ArrayList<CardholderName>>() {
                }.getType();
                List<CardholderName> test = new Gson().fromJson(notificationDatum.getKey(), listType);
                template.setCardholderNames(test);
            }
        }
    }

    private void executeTemplate(Template3 template, List<NotificationData> notificationData){
        for (NotificationData notificationDatum : notificationData) {
            switch (notificationDatum.getKey()) {
                case "tableItem":
                    Type listType = new TypeToken<ArrayList<TableTestItem>>() {
                    }.getType();
                    System.out.println(listType.toString());
                    List<TableTestItem> test = new Gson().fromJson(notificationDatum.getValue(), listType);
                    template.setTableTestItemList(test);
                    break;
                case "icceUrl":
                    template.setIcceUrl(notificationDatum.getValue());
                    break;
                case "lastFour":
                    template.setLastFour(notificationDatum.getValue());
                    break;
                case "clientName":
                    template.setClientName(notificationDatum.getValue());
                    break;
                case "bodyMod":
                    template.setBodyMod(notificationDatum.getValue());
                    break;
            }
        }
    }



}