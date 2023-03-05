package com.qacart.todo.API;

import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;


import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    private static List<Cookie> restAssuredCookies;
    private static String accessToken;
    private static String userId;
    private static String firstName;
    public String getFirstName(){
        return this.firstName;
    }
    public String getToken(){
        return this.accessToken;
    }
    public String getUserId(){
        return this.userId;
    }
    public List<Cookie> getCookies(){
        return this.restAssuredCookies;
    }
    public void register(){
        User user = UserUtils.generateRandomUser();
        Response response=
                given()
                    .baseUri("https://todo.qacart.com")
                    .header("Content-Type","application/json")
                    .body(user)
                        .log().all()
                .when()
                    .post("/api/v1/users/register")
                .then()
                        .log().all()
                    .extract().response();
        if (response.statusCode() !=201){

            throw new RuntimeException("some thing went wrong");

        }
        restAssuredCookies= response.detailedCookies().asList();
        accessToken =response.path("access_token");
        userId =response.path("userID");
        firstName=response.path("firstName");
    }
}
