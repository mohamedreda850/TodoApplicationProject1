package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {
    public TodoPage (WebDriver driver){
        super(driver);
    }
    @FindBy(css ="[data-testid=\"welcome\"]" )
    private WebElement welcomeMassage;
    @FindBy(css ="[data-testid=\"add\"]")
    private WebElement addButton;
    @FindBy(css = "[data-testid=\"todo-text\"]")
    private WebElement todoText;
    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement deleteButton;
    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement noTodosMassage;
    public boolean isNoTodosMassageDesplayed(){
       return noTodosMassage.isDisplayed();
    }
    public NewTodoPage clickPlusButton(){
     addButton.click();
     return new NewTodoPage(driver);
    }
    public boolean IsWelcomeMassageIsDisplayed(){
        return welcomeMassage.isDisplayed();
    }
    public String getTodoText(){
       return todoText.getText();
    }
    public TodoPage deleteTask (){
        deleteButton.click();
        return this;
    }

}
