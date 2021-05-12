package com.example.rest.Springtest.Controller;

import org.springframework.stereotype.Component;

@Component
public class addbookresponse {

    private String resp;
    private String id;

    public String getResp() {
        return resp;
    }
    public void setResp(String resp) {
        this.resp = resp;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
