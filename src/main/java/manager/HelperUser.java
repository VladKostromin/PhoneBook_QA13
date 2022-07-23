package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);

    }
    public boolean isElementPreset(By locator) {
        return webDriver.findElements(locator).isEmpty();
    }

    public void type(By locator, String input) {
        if(input != null) {
            WebElement element = webDriver.findElement(locator);
            element.clear();
            element.sendKeys(input);
        }

    }
    public void click(By locator) {
        webDriver.findElement(locator).click();
    }


    public void openLoginRegistrationForm() {
        click(By.xpath("//a[.='LOGIN']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[2]"));
    }

    public void submitLogin() {
        click(By.xpath("//button[1]"));
    }
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isLogged() {
        try {
            webDriver.findElement(By.xpath("//button[text()='Sign Out']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

}
