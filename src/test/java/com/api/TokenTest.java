package com.api;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.utils.TokenUtil;
import io.qameta.allure.*;

@Listeners(
    {io.qameta.allure.testng.AllureTestNg.class}
)
public class TokenTest extends BaseAPI {

    

    @BeforeTest
    public void setupTest(){
        setup();
    }
    
    @Test(priority = 1)
    @Description
    public void testTokenGeneration(){
        AuthAPI auth = new AuthAPI();
        Response response = auth.login();
        String token = TokenUtil.getToken();
        System.out.println("Token id: " + token);
        Assert.assertEquals(response.getStatusCode(), 200, "Login response status should be 200");
        Assert.assertNotNull(token, "Token should not be null");
    }

    @Test(priority = 2)
    @Description("Test to add money to wallet using the generated token")
    public void addMoneyToWalllet(){
        WalletAPI wallet = new WalletAPI();
        Response response = wallet.addMoney();
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Add money response: " + response.asString());

    }

    @Test(priority = 3)
    @Description("Test to get payment details using the generated token")
    public void getPaymentDetails(){
        PaymentAPI payment = new PaymentAPI();
        Response response = payment.getPaymentDetails();
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Payment details response: " + response.asString());
    }

    @Test(priority = 4)
    @Description("Test to refund a payment using the generated token")
    public void paymentRefund(){
        PaymentAPI payment = new PaymentAPI();
        Response response = payment.paymentRefund();
        Assert.assertEquals(response.getStatusCode(), 202);
        System.out.println("Payment refund response: " + response.asString());
    }}
