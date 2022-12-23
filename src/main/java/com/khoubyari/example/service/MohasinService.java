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
        
        
        Template1 template1 = new Template1();

        template1.setAlertTypeCode(url)

        for(int i=0; i<notificationData.size(); i++){
            switch(notificationData.get(i).key){
                case "updatedInfo":
                 Type listType = new TypeToken<ArrayList<UpdatedInfoItem>>(){}.getType();
                 List<UpdatedInfoItem> test = new Gson().fromJson(notificationData.get(i).value, listType);
                 template1.setUpdatedInfo(test);
                 break;
                case "firstName":
                 template1.setFirstName(notificationData.get(i).value);
            }
        }

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
