class ResponseConverterUtility {

    public void test(String templateType, List<NotificationData> notificationData){

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
        
    
    }

    private void executeTemplate1(){
        Template1 template1 = new Template1();
        template1.setAlertTypeCode(url);

        for(int i=0; i<notificationData.size(); i++){
            switch(notificationData.get(i).key){
                case "updatedInfo":
                    Type listType = new TypeToken<ArrayList<UpdatedInfoItem>>(){}.getType();
                    List<UpdatedInfoItem> test = new Gson().fromJson(notificationData.get(i).value, listType);
                    template1.setUpdatedInfo(test);
                    break;
                case "firstName":
                    template1.setFirstName(notificationData.get(i).value);
                    break;
            }
        }
    }


    private void executeTemplate2(){
        Template2 template2 = new Template2();
        template2.setAlertTypeCode(url);

        for(int i=0; i<notificationData.size(); i++){
            switch(notificationData.get(i).key){
                case "updatedInfo":
                    Type listType = new TypeToken<ArrayList<CardholderName>>(){}.getType();
                    List<CardholderName> test = new Gson().fromJson(notificationData.get(i).value, listType);
                    template2.setCardholderNames(test);
                    break;
                case "firstName":
                    template2.setFirstName(notificationData.get(i).value);
                    break;
            }
        }
    }

    private void executeTemplate3(){
        Template3 template3 = new Template3();
        template3.setAlertTypeCode(url);

        for(int i=0; i<notificationData.size(); i++){
            switch(notificationData.get(i).key){
                case "updatedInfo":
                    Type listType = new TypeToken<ArrayList<TestItem>>(){}.getType();
                    List<TestItem> test = new Gson().fromJson(notificationData.get(i).value, listType);
                    template3.setTestItems(test);
                    break;
                case "firstName":
                    template3.setFirstName(notificationData.get(i).value);
                    break;
            }
        }
    }



}