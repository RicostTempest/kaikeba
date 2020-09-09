package com.windsoft.management.express.dao;

import com.windsoft.management.express.bean.Express;

public class ExpressDao {
    private Express[] data = new Express[100];

    public boolean add(Express express){
        for(int i = 0; i < data.length; i++){
            if (data[i] == null){
                data[i] = express;
                express = null;
            }
        }
        return express == null;
    }

    public Express findByNumber(String number){
        for (Express datum : data) {
            if (datum != null && datum.getNumber().equals(number)) {
                return datum;
            }
        }
        return null;
    }
    public Express findByCode(int code){
        for (Express datum : data) {
            if (datum != null && datum.getCode() == code) {
                return datum;
            }
        }
        return null;
    }

    public void update(Express oldExpress,Express newExpress){
        oldExpress.setNumber(newExpress.getNumber());
        oldExpress.setCompany(newExpress.getCompany());
    }

    public boolean delete(Express express){
        for (int i =  0; i < data.length; i++){
            if (express.equals(data[i])){
                data[i] = null;
                return true;
            }
        }
        return false;
    }

    public Express[] findAll(){
        return data;
    }
}
