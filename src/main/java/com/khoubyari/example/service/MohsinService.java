package com.khoubyari.example.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.khoubyari.example.model.NotificationData;
import com.khoubyari.example.model.NotificationDataMap;
import com.khoubyari.example.utility.ResponseConverterUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This is an optional class used to inject application specific health check
 * into the Spring Boot health management endpoint.
 */
@Service
public class MohsinService {

    @Autowired
    ResponseConverterUtility responseConverterUtility;

    //request starts here, this is just skeleton
    public String incomingRequest(NotificationDataMap notificationDataMap){

        if(notificationDataMap.getTemplateCode()=="abc"){
            //map with template1
            return notificationDataMapConverter(notificationDataMap.getTemplateCode(), notificationDataMap.getNotificationDataList());
        }

        if(notificationDataMap.getTemplateCode()=="def"){
            //map with template1
            return notificationDataMapConverter(notificationDataMap.getTemplateCode(), notificationDataMap.getNotificationDataList());
        }

        if(notificationDataMap.getTemplateCode()=="ghi"){
            //map with template1
            return notificationDataMapConverter(notificationDataMap.getTemplateCode(), notificationDataMap.getNotificationDataList());
        }

        return null;
    }


    public String notificationDataMapConverter(String url, List<NotificationData> notificationData) {

        // this returns NULL, how to fix this? //VIJAY
        Object x = responseConverterUtility.test(url, notificationData);

        //output is null as of now
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String output = gson.toJson(gson.toJson(x));

        return output;
    }

    /*
        Response 
        Response1
        Response2

        Class Response {
            toResponse(notificationData, type);
            switch(type){
                case "":
                 new Converter(notificationData);
                 Response1;
                 break;
                case "";
                 new Converter(notificationData);
                 Response2;
                 break;
            }
        }
    */

}
