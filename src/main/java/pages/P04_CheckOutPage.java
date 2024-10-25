package pages;

import actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.RandomGenerators;

public class P04_CheckOutPage {
    WebDriver driver;

    //define constructor
    public P04_CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstName = By.cssSelector("[data-test='firstName']");
    private final By lastName = By.cssSelector("[data-test='lastName']");
    private final By postalCode = By.cssSelector("[data-test='postalCode']");
    private final By continueButton = By.cssSelector("[class*='cart_button']");
    private final By totalItems = By.cssSelector("[class='summary_subtotal_label']");
    private final By taxLabel = By.cssSelector("[class='summary_tax_label']");
    private final By totalLabel = By.cssSelector("[class='summary_total_label']");
    private final By finishButton = By.cssSelector("[class*='btn_action']");

    public void checkOutSteps(String firstNameValue, String lastNameValue, String postalCodeValue) throws InterruptedException {
        new CustomDecorator(driver, firstName, 2000).sendKeys(firstNameValue);
        new CustomDecorator(driver, lastName, 2000).sendKeys(lastNameValue);
        new CustomDecorator(driver, postalCode, 2000).sendKeys(postalCodeValue);
        new CustomDecorator(driver, continueButton, 2000).click();
    }

    public boolean verifySubtotal() {
        String subtotalText = driver.findElement(this.totalItems).getText();
        double displayedSubtotal = RandomGenerators.round(RandomGenerators.trimFirstCharAndConvertToDouble(subtotalText.split(": ")[1]), 2);
        double expectedSubtotal = RandomGenerators.round(P02_ProductsPage.getTotalPrice(), 2);

        System.out.println("Displayed Subtotal: " + displayedSubtotal);
        System.out.println("Expected Subtotal: " + expectedSubtotal);

        // Compare rounded values
        return Double.compare(displayedSubtotal, expectedSubtotal) == 0;
    }

    public boolean verifyFinalTotal() {
        String subtotalText = driver.findElement(this.totalItems).getText();
        String taxText = driver.findElement(this.taxLabel).getText();
        String finalTotalText = driver.findElement(this.totalLabel).getText();

        double subtotal = RandomGenerators.round(RandomGenerators.trimFirstCharAndConvertToDouble(subtotalText.split(": ")[1]), 2);
        double tax = RandomGenerators.round(RandomGenerators.trimFirstCharAndConvertToDouble(taxText.split(": ")[1]), 2);
        double finalTotal = RandomGenerators.round(RandomGenerators.trimFirstCharAndConvertToDouble(finalTotalText.split(": ")[1]), 2);
        double calculatedFinalTotal = RandomGenerators.round(subtotal + tax, 2);

        System.out.println("Displayed Subtotal: " + subtotal);
        System.out.println("Displayed Tax: " + tax);
        System.out.println("Displayed Final Total: " + finalTotal);
        System.out.println("Expected Final Total (Subtotal + Tax): " + calculatedFinalTotal);

        // Compare rounded values
        return Double.compare(finalTotal, calculatedFinalTotal) == 0;
    }

    public P04_CheckOutPage clickOnFinshButton() {
        new CustomDecorator(driver, finishButton, 2000).click();
        return this;
    }

    public boolean checkOrderHasBeenPlaced() {
        return driver.findElement(By.cssSelector("[class='complete-text']")).getText().equals("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
}