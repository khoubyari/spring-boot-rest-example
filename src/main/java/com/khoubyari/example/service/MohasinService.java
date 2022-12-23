package com.khoubyari.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * This is an optional class used to inject application specific health check
 * into the Spring Boot health management endpoint.
 */
@Component
public class MohasinService {

    public String incomingRequest(){

        //map with template1
        notificationDataMapConverter("abc", notificationDataMap);

        //map with template2
        notificationDataMapConverter("def", notificationDataMap);
        
        //map with template3
        notificationDataMapConverter("ghi", notificationDataMap);

    }


    public String notificationDataMapConverter(String url, List<NotificationData> notificationData) {
        
        responseConverterUtility.test(url, notificationData);

        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String output = gson.toJson(gson.toJson(template1));

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
