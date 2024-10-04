package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static drivers.DriverFactory.getNewInstance;
import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;

public class TestBase {
    static WebDriver driver;

    @Parameters("browsername")
    @BeforeTest
    public void setUpDriver(String browsername) {
        setDriver(getNewInstance(""));
        driver=getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.saucedemo.com/v1/");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
