package pages;

import actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.RandomGenerators;
import java.util.List;

public class P02_ProductsPage {
    WebDriver driver;
    static double totalprice = 0;

    public P02_ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By shoppingCartButton = By.cssSelector("[id='shopping_cart_container']");
    private final By addToCartButtons = By.cssSelector("[class*='btn_inventory']");

    public P02_ProductsPage selectRandomProducts(int count) throws InterruptedException {
        // Reset totalprice at the beginning of the method
        totalprice = 0;
        // Get all available 'Add to Cart' buttons
        List<WebElement> allAddToCartButtons = driver.findElements(addToCartButtons);
        // Generate unique random product indices
        List<Integer> productsIndex = RandomGenerators.generateUniqueRandomNumbers(count, allAddToCartButtons.size());
        // Loop through the random indices and add corresponding products to the cart
        for (int i = 0; i < count; i++) {
            Thread.sleep(1000); // Adjust sleep time as necessary
            int index = productsIndex.get(i);
            System.out.println("Adding product at index: " + index);
            // Find the 'Add to Cart' button for the randomly selected product
            WebElement addToCartButton = allAddToCartButtons.get(index - 1);
            // Click the 'Add to Cart' button
            addToCartButton.click();
            // Retrieve and parse the price of the selected product
            String priceText = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[" + index + "]")).getText();
            totalprice += RandomGenerators.trimFirstCharAndConvertToDouble(priceText);
        }

        System.out.println("Total Price of Selected Products: " + totalprice);
        return this;
    }

    public P02_ProductsPage clickOnCart() {
        new CustomDecorator(driver, shoppingCartButton, 2000).click();
        return this;
    }

    public static double getTotalPrice() {
        return totalprice;
    }
}