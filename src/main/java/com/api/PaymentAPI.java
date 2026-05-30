package com.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class PaymentAPI extends BaseAPI {
@Step("Getting payment details using the generated token")
    public Response getPaymentDetails(){
        
        Response paymentRes = get("/payment/txn_001");
        return paymentRes;
    }

    @Step("Refunding a payment using the generated token")
    public Response paymentRefund(){
        Response paymentRefRes = delete("payment/refund");
        return paymentRefRes;
    }


    
}
