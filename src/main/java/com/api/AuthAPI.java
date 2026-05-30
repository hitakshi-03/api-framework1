package com.api;

import com.utils.JsonUtil;
import com.utils.TokenUtil;

import io.qameta.allure.Step;
import io.restassured.response.Response;


public class AuthAPI extends BaseAPI{
    @Step("Generating token for authentication")
    public Response login(){

        String body = JsonUtil.readJson("src/test/java/com/resources/test-data/token.json");

        // Response res = getRequest()
        //                 .body(body)
        //                 .when()
        //                 .post("/auth/login");
        Response res = post("/auth/login", body);

        System.out.println("Auth response: " + res.asString());
        System.out.println("status=" + res.getStatusCode());

        String token = res.jsonPath().getString("token");
        if (token == null) {
            token = res.jsonPath().getString("access_token");
        }
        if (token == null) {
            token = res.jsonPath().getString("data.token");
        }
        if (token == null) {
            token = res.jsonPath().getString("data.access_token");
        }

        System.out.println("resolved token: " + token);
        TokenUtil.setToken(token);

        return res;
    }
    
}
