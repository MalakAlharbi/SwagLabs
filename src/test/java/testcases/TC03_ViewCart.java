package testcases;

import pages.P03_CartPage;
import org.testng.annotations.Test;

public class TC03_ViewCart extends TestBase {

    P03_CartPage cartPage;

    @Test(priority = 1, description = "click on check out ")
    public void clickOnCheckOut() throws InterruptedException {
        cartPage = new P03_CartPage(driver);
        softAssert.assertTrue(cartPage.checkCartPage());
        cartPage.clickOnCheckOutButton();
    }
}