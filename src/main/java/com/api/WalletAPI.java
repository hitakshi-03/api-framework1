package com.api;

import com.utils.JsonUtil;

import io.qameta.allure.Step;
import io.restassured.response.Response;


public class WalletAPI extends BaseAPI {
    @Step("Adding money to wallet using the generated token")
    public Response addMoney(){

        String body = JsonUtil.readJson("src/test/java/com/resources/test-data/wallet.json");

        Response walletRes = post("/wallet/add", body);

        return walletRes;
    
    }
    
}
