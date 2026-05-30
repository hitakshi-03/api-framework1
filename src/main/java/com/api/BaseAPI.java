package com.api;
import com.utils.config;
import com.utils.TokenUtil;

import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BaseAPI{
    public RequestSpecification request;
    public void setup()
    {

        RestAssured.baseURI = config.get("baseURI.url");
        
    }

    public RequestSpecification getRequest(){
         request = RestAssured.given().header("Content-Type", "application/json");
         

         if(TokenUtil.getToken() != null)
            request.header("Authorization", "Bearer " + TokenUtil.getToken());

         return request;
    }

    @Attachment(value = "Response", type = "application/json")
    public Response get(String endpoint){
        return getRequest().when().get(endpoint);
    }

    
    public Response post(String endpoint, Object body){
        return getRequest().body(body).when().post(endpoint);
    }

    public Response delete(String endpoint){
        return getRequest().when().delete(endpoint);
    }

}