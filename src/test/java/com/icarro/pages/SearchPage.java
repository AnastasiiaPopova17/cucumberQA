package com.icarro.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='city']")
    WebElement inputCity;

    @FindBy(xpath = "//input[@id='dates']")
    WebElement inputDates;

    @FindBy(xpath = "//div[@class='search-results']")
    List<WebElement> allAvailableCars;

    public SearchPage fillCityField(String city) {
    type(inputCity, city);
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    Actions actions = new Actions(driver);
    actions.sendKeys(Keys.ARROW_DOWN).perform();
    actions.sendKeys(Keys.ENTER).perform();
    return this;
}
    public SearchPage fillDatesField(String dates) {
        click(inputDates);
        inputDates.sendKeys(dates);
        inputDates.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public SearchPage getAvailableCars() {
    for (WebElement el: allAvailableCars) {
        el.getText().trim();
    }
        return this;
    }

}
