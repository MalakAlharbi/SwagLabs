package testcases;

import Pages.P01_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_Login extends TestBase{

    P01_LoginPage loginPage;

    String userName="standard_user";
    String password="secret_sauce";

    @Test(priority = 1,description = "Login with valid username and password")
    public void loginWithValidUserNameAndPassword(){
        loginPage=new P01_LoginPage(driver);
        loginPage.insertUserName(userName).insertPassword(password).clickOnLoginButton();
        Assert.assertEquals(new P01_LoginPage(driver).getHeaderTest(),"Products");
    }
}
