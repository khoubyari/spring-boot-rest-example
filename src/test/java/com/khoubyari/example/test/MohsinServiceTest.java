package com.khoubyari.example.test;

import com.khoubyari.example.model.NotificationData;
import com.khoubyari.example.model.NotificationDataMap;
import com.khoubyari.example.service.MohsinService;
import com.khoubyari.example.utility.ResponseConverterUtility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MohsinServiceTest {

    @InjectMocks
    MohsinService mohsinService;

    @Mock
    ResponseConverterUtility responseConverterUtility;

    @Test
    public void incomingRequestTest(){
        NotificationDataMap notificationDataMap = new NotificationDataMap();
        notificationDataMap.setTemplateCode("abc");
        List<NotificationData> notificationDataList = new ArrayList<>();
        NotificationData notificationData = new NotificationData();
        notificationData.setKey("firstName");
        notificationData.setValue("Mohsin");
        NotificationData notificationData1 = new NotificationData();
        notificationData1.setKey("updatedInfo");
        notificationData1.setValue("");
        notificationData1.setValueType("looparray");
        notificationDataList.add(notificationData);
        notificationDataList.add(notificationData1);
        notificationDataMap.setNotificationDataList(notificationDataList);

        Object x = new Object();

        Mockito.when(responseConverterUtility.test(Mockito.anyString(), Mockito.anyList())).thenReturn(x);
        mohsinService.incomingRequest(notificationDataMap);
    }
}
