package com.icarro.stepdefinitions;

import com.icarro.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.icarro.pages.BasePage.driver;

public class LoginSteps {

    @And("User clicks on Login link")
    public void click_login_button() {
        new LoginPage(driver).clickLoginButton();
    }

    @And("User enters valid data")
    public void user_enter_valid_data() {
        new LoginPage(driver).fillEmailAndPassword("proba@gmail.com","1234Qwer!");
    }

    @And("User clicks on Yalla button")
    public void click_login_on_yalla_button() {
    new LoginPage(driver).clickYalla();
    }

    @Then("User verifies Success Message is displayed")
    public void verify_success_login() {
        new LoginPage(driver).isSuccessMessageDisplays();
    }

    @And("User enters valid email and invalid password")
    public void user_enters_valid_email_and_invalid_password(DataTable table) {
        new LoginPage(driver).enterValidEmailAndInvalidPassword(table);
    }

    @Then("User verifies Error is displayed")
    public void verify_error_displayed() {
        new LoginPage(driver).isErrorMessageDisplayed();
    }
}
