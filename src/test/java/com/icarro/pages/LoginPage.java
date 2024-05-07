package com.icarro.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='header']//a[contains(text(), 'Log in')]")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;

    @FindBy(xpath = "//h2[@class='message']")
    WebElement textMessage;

    public LoginPage clickLoginButton() {
        click(loginBtn);
        return this;
    }

    public LoginPage fillEmailAndPassword(String mail, String password) {
        type(inputEmail,mail);
        type(inputPassword,password);
        return this;
    }

    public LoginPage clickYalla() {
        click(btnYalla);
        return this;
    }

    public LoginPage isSuccessMessageDisplays() {
        String expectedRes ="Logged in success";
        // get text should be in BasePage
        String actualRes = textMessage.getText().trim();
        assert actualRes.equals(expectedRes);
        return this;
    }

    public LoginPage enterValidEmailAndInvalidPassword(DataTable table) {
        List<Map<String,String>> dataTable = table.asMaps();

        Map<String,String> oneData = dataTable.get(0);
        String email = oneData.get("email");
        System.out.println(email);
        String password = oneData.get("password");
        fillEmailAndPassword(email,password);
        return this;
    }

    public LoginPage isErrorMessageDisplayed() {
        String expectedRes ="Login or Password incorrect";
        // get text should be in BasePage
        String actualRes = textMessage.getText().trim();
        System.out.println(actualRes);
        assert actualRes.equals(expectedRes);
        return this;
    }
}
