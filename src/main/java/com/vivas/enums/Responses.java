package com.vivas.enums;

/**
 * Created by duyot on 10/4/2016.
 */
public enum Responses {
    SUCCESS("SUCCESS","200"),ERROR("FAIL","-1");
    public String statusName;
    public String statusCode;
    Responses(String statusCode,String statusName){
        this.statusCode = statusCode;
        this.statusName = statusName;
    }
    public String getName(){
        return this.statusName;
    }
    public String getCode(){
        return this.statusCode;
    }

}
