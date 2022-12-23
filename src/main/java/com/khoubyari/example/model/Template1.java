public class Template1 implements Serializable {

    public String firstName;

    public String alertTypeCode;

    public List<UpdatedInfoItem> updatedInfo;

    public String getfirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getAlertTypeCode() { return alertTypeCode; }

    public void setAlertTypeCode(String alertTypeCode) { this.alertTypeCode = alertTypeCode; }

    public List<UpdatedInfoItem> getUpdatedInfo() { return updatedInfo; }

    public void setUpdatedInfo(List<UpdatedInfoItem> updatedInfo) { this.updatedInfo = updatedInfo; }

}