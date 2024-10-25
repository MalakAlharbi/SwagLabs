package testcases;

import common.MyScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import static drivers.DriverFactory.getNewInstance;
import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;
import static common.PageBase.quitBrowser;

public class TestBase {
    static WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void beforeSuite() throws Exception {
        MyScreenRecorder.startRecording("SwagLabs TestCases");
    }

    @Parameters("browsername")
    @BeforeTest
    public void setupDriver(String browsername) {
        setDriver(getNewInstance(browsername));
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.saucedemo.com/v1/");
    }

    @AfterTest
    public void teardown() {
        quitBrowser(driver);
    }

    @AfterSuite
    public void afterSuite() throws Exception {
        MyScreenRecorder.stopRecording();
    }
}