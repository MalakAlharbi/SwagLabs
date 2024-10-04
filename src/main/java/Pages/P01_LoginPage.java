package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    // 1-constructor builder design pattern
    // 2-locaters
    // 3- public action methods

   // define web driver
   WebDriver driver;
   //define constructor
   public P01_LoginPage(WebDriver driver)
   {
       this.driver=driver;
   }

   //locaters
    private final By userName=By.cssSelector("[data-test='username']");
    private final By password=By.cssSelector("[data-test='password']");
    private final By loginButton=By.cssSelector("[class='btn_action']");

    //public action method
    public P01_LoginPage insertUserName(String userName){
        driver.findElement(this.userName).sendKeys(userName);
        return this;
    }

    public P01_LoginPage insertPassword(String password){
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    public P01_LoginPage clickOnLoginButton(){
        driver.findElement(this.loginButton).click();
        return this;
    }

    public String getHeaderTest(){
        return driver.findElement(By.xpath("//div[@class=\"product_label\"]")).getText();
    }
}