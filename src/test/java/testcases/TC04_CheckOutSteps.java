package testcases;

import pages.P04_CheckOutPage;
import utility.RandomGenerators;
import org.testng.annotations.Test;

public class TC04_CheckOutSteps extends TestBase {
    P04_CheckOutPage checkOutPage;

    String firstName;
    String lastName;
    String postalCode;

    @Test(priority = 1, description = "fill check out fields ")
    public void checkOutSteps() throws InterruptedException {
        checkOutPage = new P04_CheckOutPage(driver);
        firstName = RandomGenerators.generateRandomFirstName();
        lastName = RandomGenerators.generateRandomLastName();
        postalCode = RandomGenerators.generatePostalCode();
        checkOutPage.checkOutSteps(firstName, lastName, postalCode);
        softAssert.assertTrue(checkOutPage.verifySubtotal(), "Subtotal match the expected value.");
        softAssert.assertTrue(checkOutPage.verifyFinalTotal(), "Final total (including tax) match the expected value.");
        softAssert.assertAll();
        checkOutPage.clickOnFinshButton();
        checkOutPage.checkOrderHasBeenPlaced();
    }
}