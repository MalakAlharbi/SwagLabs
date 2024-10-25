package pages;

import actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    // 1-constructor builder design pattern
    // 2-locaters
    // 3- public action methods

    // define web driver
    WebDriver driver;

    //define constructor
    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //locaters
    private final By userName = By.cssSelector("[data-test='username']");
    private final By password = By.cssSelector("[data-test='password']");
    private final By loginButton = By.cssSelector("[class='btn_action']");

    //public action method
    public P01_LoginPage insertUserName(String userNameValue) {
        new CustomDecorator(driver, userName, 2).sendKeys(userNameValue);
        return this;
    }

    public P01_LoginPage insertPassword(String passwordValue) {
        new CustomDecorator(driver, password, 2000).sendKeys(passwordValue);
        return this;
    }

    public P01_LoginPage clickOnLoginButton() {
        new CustomDecorator(driver, loginButton, 2000).click();
        return this;
    }

    public String getHeaderTest() {
        return driver.findElement(By.xpath("//div[@class=\"product_label\"]")).getText();
    }
}