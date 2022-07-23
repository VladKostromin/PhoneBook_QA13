package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationPositiveTest extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if(app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginPositiveTest() {
        String email = "abc@def.com";
        String password = "$Abcdef12345";

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isElementPreset(By.xpath("//button")));
        app.getHelperUser().pause(3000);
    }
    @Test
    public void registrationPositiveTest() {
        int time =  (int)((System.currentTimeMillis()/1000) % 3600);
        String email = "name" + time + "@mail.com";
        String password = "$Name12345";
        System.out.println("Email: " + email);

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitRegistration();

    }
    @Test
    public void registrationNegativeTest() {
        int time =  (int)((System.currentTimeMillis()/1000) % 3600);
        String email = "name" + time + "@mail.com";
        String password = "@Name12345";
        System.out.println("Email: " + email);

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isElementPreset(By.xpath("//button")));

    }

}
