package manager;

import org.openqa.selenium.WebDriver;

public class HelperBase {
    WebDriver webDriver;

    public HelperBase(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
