package org.example;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.Test;
import pojo.GetOrder;

import java.io.IOException;

import static io.restassured.RestAssured.given;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException {
        String orderToken = "A1KQ7URT63";
        String bearerToken = "qhtfs87hjnc12kkos";

        RestAssured.baseURI = "https://integration.api.scalapay.com";
        GetOrder order = given().header("Authorization", "Bearer "+bearerToken)
                .expect().defaultParser(Parser.JSON)
                .when().get("/v2/payments/" +orderToken).as(GetOrder.class);

        System.out.println("The status of the order: " + order.getStatus());
        System.out.println("The captureStatus of the order: " + order.getCaptureStatus());
        System.out.println("The total price of the order: " + order.getTotalAmount().getAmount());
        System.out.println("The total price of the order: " + order.getTotalAmount().getCurrency());

//                .then().log().all().assertThat().statusCode(200).extract().response().asString();
//        JsonPath js = CommonMethod.rawToJson(resp);

//        String status = js.get("status");
//        String captureStatus = js.get("captureStatus");
//        String currency = js.get("totalAmount.currency");
//        float shippingAmount = js.getFloat("orderDetails.shippingAmount.amount");
//        float totalAmount = js.get("totalAmount.amount");
//        int orderItems = js.getInt("orderDetails.items.size()");
//
//        float itemPrice;
//        int itemQuan;
//        float totalPrice = 0;
//
//        for(int i=0;i<orderItems;i++) {
//            System.out.println( i + 1 + " item name: " + js.get("orderDetails.items[" + i + "].name"));
//            itemPrice = js.getFloat("orderDetails.items[" + i + "].price.amount");
//            System.out.println( i + 1 + " item price: " + itemPrice);
//            itemQuan = js.getInt("orderDetails.items[" + i + "].quantity");
//            System.out.println( i + 1 + " ordered quantities: " + itemQuan);
//            float itemTotal = itemPrice*itemQuan;
//            totalPrice = totalPrice+itemTotal;
//            System.out.println("");
//        }
//
//        System.out.println("The status of the order: " + status);
//        System.out.println("The captureStatus of the order: " + captureStatus);
//        System.out.println("The total price of the order: " + totalAmount);
//        System.out.println("The shippingAmount of the order: " + shippingAmount);
//        System.out.println("The total price exclude shipping: " + totalPrice);
//        System.out.println("The order currency: " + currency);
//        assertEquals("The total price amount of the order is incorrect",shippingAmount+totalPrice,totalAmount,0.00001);
    }
}
