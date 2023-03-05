package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;

import com.qacart.todo.pages.LoginPage;

import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void SouldBeAbleToLoginWithEmailAndPassword(){

        LoginPage loginPage =new LoginPage(driver);
        boolean isWelcomeDisplayed=
                loginPage
                        .load().
                        login(ConfigUtils.getInstance().getEmail(),
                                ConfigUtils.getInstance().getPassword()).
                        isNoTodosMassageDesplayed();
        Assert.assertTrue(isWelcomeDisplayed);

    }
}
