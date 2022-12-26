package com.khoubyari.example.test.utility;

import com.khoubyari.example.model.NotificationData;
import com.khoubyari.example.utility.ResponseConverterUtility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ResponseConverterUtiltiyTest {

    @InjectMocks
    ResponseConverterUtility responseConverterUtility;

    // this test case has conversion issue
    @Test
    public void testTestTemplate3(){
        List<NotificationData> notificationDataList = new ArrayList<>();
        NotificationData notificationData = new NotificationData();
        notificationData.setKey("firstName");
        notificationData.setValue("Mohsin");

        NotificationData notificationData1 = new NotificationData();
        notificationData1.setKey("tableItem");
        notificationData1.setValue("[{\"number\":\"1\", \"description\":\"test1\"},{\"number\":\"2\", \"description\":\"test2\"},{\"number\":\"3\", \"description\":\"test3\"}]");
        notificationData1.setValueType("table");

        NotificationData notificationData2 = new NotificationData();
        notificationData2.setKey("icceUrl");
        notificationData2.setValue("icceUrl");

        NotificationData notificationData3 = new NotificationData();
        notificationData3.setKey("lastFour");
        notificationData3.setValue("1234");

        NotificationData notificationData4 = new NotificationData();
        notificationData4.setKey("clientName");
        notificationData4.setValue("Test");

        NotificationData notificationData5 = new NotificationData();
        notificationData5.setKey("bodyMod");
        notificationData5.setValue("1");

        notificationDataList.add(notificationData);
        notificationDataList.add(notificationData1);
        notificationDataList.add(notificationData2);
        notificationDataList.add(notificationData3);
        notificationDataList.add(notificationData4);
        notificationDataList.add(notificationData5);

        responseConverterUtility.test("ghi", notificationDataList);
    }

    @Test
    public void testTestTemplate1(){
        List<NotificationData> notificationDataList = new ArrayList<>();
        NotificationData notificationData = new NotificationData();
        notificationData.setKey("firstName");
        notificationData.setValue("Mohsin");

        NotificationData notificationData1 = new NotificationData();
        notificationData1.setKey("updatedInfo");
        notificationData1.setValue("[{\"value\": \"email address\"}, {\"value\": \"test code\"}, {\"value\": \"name\"}]");
        notificationData1.setValueType("looparray");


        NotificationData notificationData5 = new NotificationData();
        notificationData5.setKey("bodyMod");
        notificationData5.setValue("1");

        notificationDataList.add(notificationData);
        notificationDataList.add(notificationData1);
        notificationDataList.add(notificationData5);

        responseConverterUtility.test("abc", notificationDataList);
    }

}
