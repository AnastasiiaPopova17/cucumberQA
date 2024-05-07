package com.icarro.stepdefinitions;

import com.icarro.pages.HomePage;
import com.icarro.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.icarro.pages.BasePage.driver;

public class HomePageSteps {

    @Given("User launches Chrome browser")
    public void launch_browser() {
        new HomePage(driver).init();
    }

    @When("User opens ilCarro HomePage")
    public void open_icarro_home_page() {
        new HomePage(driver).navigateToMainPage();
    }

    @Then("User verifies HomePage title is displayed")
    public void verify_title_displayed() {
        new HomePage(driver).isHomePageTitleDisplayed();
    }

    @And("User quites browser")
    public void quit_browser() {
        new HomePage(driver).tearDown();
    }

}
