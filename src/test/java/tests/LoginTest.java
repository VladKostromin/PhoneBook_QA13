package tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {

    @Test
    public void loginPositiveTest1() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("abc@def.com", "$Abcdef12345");
        app.getHelperUser().submitLogin();
//        app.getHelperUser().click(By.xpath("//button"));
        app.getHelperUser().logout();
        Assert.assertFalse(app.getHelperUser().isLogged());
    }
}
