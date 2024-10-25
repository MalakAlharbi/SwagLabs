package pages;

import actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_CartPage {
    WebDriver driver;

    //define constructor
    public P03_CartPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private final By checkOutButton = By.cssSelector("[class*='checkout_button']");

    public void clickOnCheckOutButton() {
        new CustomDecorator(driver,checkOutButton,2000).click();
    }

    public boolean checkCartPage(){
        return driver.findElement(By.cssSelector("[class='subheader']")).getText().equals("Your Cart");
    }
}