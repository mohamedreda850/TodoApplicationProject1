package com.qacart.todo.testcases;

import com.qacart.todo.API.RegisterApi;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class dummy {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();

        driver.get(ConfigUtils.getInstance().getBaseUrl());
        driver.manage().window().maximize();

        RegisterApi registerApi =new RegisterApi();
        registerApi.register();
        List<Cookie> restAssuredCookies = registerApi.getCookies();
        for (Cookie cookie: restAssuredCookies){
            org.openqa.selenium.Cookie seleniumCookie =new org.openqa.selenium.Cookie(cookie.getName(),cookie.getValue());
            driver.manage().addCookie(seleniumCookie);

        }
        driver.get(ConfigUtils.getInstance().getBaseUrl());

        Thread.sleep(60000);
        driver.quit();

    }

}
