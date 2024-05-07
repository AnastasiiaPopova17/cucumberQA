package com.icarro.stepdefinitions;

import com.icarro.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.icarro.pages.BasePage.driver;

public class SearchSteps{
    @And("User enters city in the field")
    public void typeYourCity() {
        new SearchPage(driver).fillCityField("Tel Aviv");
    }

    @And("User selects the dates")
    public void typeYourDates() {
        new SearchPage(driver).fillDatesField("5/7/2024 - 5/14/2024");
    }

    @Then("User sees available cars in entered city for the entered dates")
    public void availableCarsShow() {
        new SearchPage(driver).getAvailableCars();
    }

}
