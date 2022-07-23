package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver webDriver;
    HelperUser user;
    String url = "https://contacts-app.tobbymarshall815.vercel.app/home";


    public void inti() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        user = new HelperUser(webDriver);
    }

    public void stop() {
        webDriver.quit();
    }

    public HelperUser getHelperUser() {
        return user;
    }
}
