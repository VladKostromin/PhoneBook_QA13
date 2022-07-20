import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeLoginTesting {

    String url = "https://contacts-app.tobbymarshall815.vercel.app/home";
    WebDriver webDriver;

    @BeforeMethod
    public void inti() {
        webDriver = new ChromeDriver();
        webDriver.navigate().to(url);
        webDriver.findElement(By.xpath("//a[@href='/login']")).click();

    }
    @Test
    public void negativeWrongInput400Test() throws InterruptedException {
        WebElement emailInput = webDriver.findElement(By.xpath("//*[@placeholder='Email']"));
        WebElement passwordInput = webDriver.findElement(By.xpath("//*[@placeholder='Password']"));
        fillInputElement(emailInput, "johndoe$notemail.com");
        fillInputElement(passwordInput, "12345");
        webDriver.findElement(By.xpath("//button[text()=' Login']")).click();
        synchronized (webDriver) {
            webDriver.wait(1500);
        }
        webDriver.switchTo().alert().accept();
        Assert.assertTrue(webDriver.findElement(By.xpath("//div[text()='Login Failed with code 400']")).isDisplayed());
    }
    @Test
    public void negativeWrongInput500Test() throws InterruptedException {
        WebElement emailInput = webDriver.findElement(By.xpath("//*[@placeholder='Email']"));
        WebElement passwordInput = webDriver.findElement(By.xpath("//*[@placeholder='Password']"));
        fillInputElement(emailInput, "abc@def.com");
        fillInputElement(passwordInput, "$Abcdef1234");
        webDriver.findElement(By.xpath("//button[text()=' Login']")).click();
        synchronized (webDriver) {
            webDriver.wait(1500);
        }
        webDriver.switchTo().alert().accept();
        Assert.assertTrue(webDriver.findElement(By.xpath("//div[.='Login Failed with code 500']")).isDisplayed());
    }

    @Test
    public void negativeUserAlreadyExist409Test() throws InterruptedException {
        WebElement emailInput = webDriver.findElement(By.xpath("//*[@placeholder='Email']"));
        WebElement passwordInput = webDriver.findElement(By.xpath("//*[@placeholder='Password']"));
        fillInputElement(emailInput, "abc@def.com");
        fillInputElement(passwordInput, "$Abcdef12345");
        webDriver.findElement(By.xpath("//button[text()=' Registration']")).click();
        synchronized (webDriver) {
            webDriver.wait(1500);
        }
        webDriver.switchTo().alert().accept();
        Assert.assertTrue(webDriver.findElement(By.xpath("//div[text()='Registration failed with code 409']")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {

    }

    private void fillInputElement(WebElement input, String text) {
        input.clear();
        input.click();
        input.sendKeys(text);

    }
}
