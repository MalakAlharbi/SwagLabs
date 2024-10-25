package testcases;

import pages.P02_ProductsPage;
import org.testng.annotations.Test;
import static utility.RandomGenerators.generateRandomInt;

public class TC02_AddRandomProducts extends TestBase {

    @Test(priority = 1, description = "Select Random Products")
    public void selectRandomProducts() throws InterruptedException {
        new P02_ProductsPage(driver).selectRandomProducts(generateRandomInt(1, 6)).clickOnCart();
    }
}