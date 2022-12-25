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
    public Object test(String templateType, List<NotificationData> notificationData){
        switch(templateType){
            case "abc":
            executeTemplate1(templateType, notificationData);
            break;
            case "def":
            executeTemplate2(templateType, notificationData);
            break;
            case "ghi":
            executeTemplate3(templateType, notificationData);
            break;
        }
        
    return null;
    }

    //how to refactor this common executeTemplate1, executeTemplate2, executeTemplate3 into a generic function ?? //VIJAY

    private Template1 executeTemplate1(String templateType, List<NotificationData> notificationData){
        Template1 template1 = new Template1();
        template1.setAlertTypeCode(templateType);

        for(int i=0; i<notificationData.size(); i++){
            switch(notificationData.get(i).getKey()){
                case "updatedInfo":
                    Type listType = new TypeToken<ArrayList<UpdatedInfoItem>>(){}.getType();
                    List<UpdatedInfoItem> test = new Gson().fromJson(notificationData.get(i).getValue(), listType);
                    template1.setUpdatedInfo(test);
                    break;
                case "firstName":
                    template1.setFirstName(notificationData.get(i).getValue());
                    break;
            }
        }

        return template1;
    }


    private Template2 executeTemplate2(String templateType, List<NotificationData> notificationData){
        Template2 template2 = new Template2();
        template2.setAlertTypeCode(templateType);

        for(int i=0; i<notificationData.size(); i++){
            switch(notificationData.get(i).getKey()){
                case "cardholderNames":
                    Type listType = new TypeToken<ArrayList<CardholderName>>(){}.getType();
                    List<CardholderName> test = new Gson().fromJson(notificationData.get(i).getKey(), listType);
                    template2.setCardholderNames(test);
                    break;
                case "firstName":
                    template2.setFirstName(notificationData.get(i).getValue());
                    break;
            }
        }
        return template2;
    }

    //template 3 is different use case with key,value pair in case TableTestItem. //Vijay
    private Template3 executeTemplate3(String templateType, List<NotificationData> notificationData){
        Template3 template3 = new Template3();
        template3.setAlertTypeCode(templateType);

        for(int i=0; i<notificationData.size(); i++){
            switch(notificationData.get(i).getKey()){
                case "TableTestItem":
                    // need to rewrite this logic for this case request
//                    Type listType = new TypeToken<ArrayList<TestItem>>(){}.getType();
//                    List<TestItem> test = new Gson().fromJson(notificationData.get(i).getValue(), listType);
//                    template3.setTestItems(test);
                    break;
                case "firstName":
                    template3.setFirstName(notificationData.get(i).getValue());
                    break;
            }
        }
        return template3;
    }



}