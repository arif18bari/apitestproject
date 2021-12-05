package com.arif.apitestproject.controller;

import com.arif.apitestproject.entity.APITest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/apitest")
public class APITestController {
    @GetMapping("/getTestForm")
    public String getTestForm(Model model) {

        // create model attribute to bind form data
        APITest apitest = new APITest();

        model.addAttribute("apitest", apitest);
        return "apitest/apitestform";
    }

    @GetMapping("/getTestResult")
    public String getTestResult(@ModelAttribute("apitest") APITest apitest,Model model) {
        String url = apitest.getApiURL();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity request = new HttpEntity(headers);

        // make a request
        ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, request, String.class);

        // get JSON response
        String json = response.getBody();
        System.out.println(json);
        model.addAttribute("json", json);

        return "apitest/apitestform";
    }


}
