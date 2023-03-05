package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;

import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TodoTest extends BaseTest {

    @Test
    public void shouldBeAbleToAddNewTodo(){
        LoginPage loginPage =new LoginPage(driver);
        String actualResult= loginPage.load()
        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword() )
       .clickPlusButton().addNewTask("learn selenium")
        .getTodoText();
        Assert.assertEquals(actualResult,"learn selenium");
    }
    @Test(enabled = false)
    public void shouldBeAbleToDeleteNewTodo(){
        LoginPage loginPage =new LoginPage(driver);
        boolean isDisplayed= loginPage.load()
        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword() )
                .clickPlusButton()
                .addNewTask("learn selenium")
                .deleteTask()
                .isNoTodosMassageDesplayed();
        Assert.assertTrue(isDisplayed);

    }
}
