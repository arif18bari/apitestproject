package com.arif.apitestproject.entity;

import org.springframework.stereotype.Component;

@Component
public class APITest {
    private String actionMethod;
    private String apiURL;

    public String getApiURL() {
        return apiURL;
    }

    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }



    public String getActionMethod() {
        return actionMethod;
    }

    public void setActionMethod(String actionMethod) {
        this.actionMethod = actionMethod;
    }



}
