package com.khoubyari.example.model;

import java.util.List;

public class Template1 extends Template {
    public List<UpdatedInfoItem> updatedInfo;

    public List<UpdatedInfoItem> getUpdatedInfo() { return updatedInfo; }

    public void setUpdatedInfo(List<UpdatedInfoItem> updatedInfo) { this.updatedInfo = updatedInfo; }

    @Override
    public String toString() {
        return "Template1{" +
                "firstName='" + firstName + '\'' +
                ", alertTypeCode='" + alertTypeCode + '\'' +
                ", updatedInfo=" + updatedInfo +
                '}';
    }
}