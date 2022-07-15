import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class PhoneBook {
    WebDriver webDriver;
    String url = "https://www.w3schools.com/";


    @BeforeTest
    public void init() {
        webDriver = new ChromeDriver();
        webDriver.navigate().to(url);
        webDriver.findElement(By.xpath("//a[text()='Learn CSS'] [@class='w3-button w3-block tut-button']")).click();
        webDriver.findElement(By.xpath("//a[text()='CSS Tables']")).click();
    }
    @Test
    public void amountOfTableRows() {
        List<WebElement> webElementList = webDriver.findElements(By.xpath("//table[@id='customers']//tr"));
        int numberOfElements = webElementList.size();
        Assert.assertEquals(numberOfElements, 9);
    }
    @Test
    public void amountOfTableColumns() {
        List<WebElement> webElementList = webDriver.findElements(By.xpath("//table[@id='customers']//th"));
        int numberOfElements = webElementList.size();
        Assert.assertEquals(numberOfElements, 3);
    }
    @Test
    public void contentOfRow3() {
        List<WebElement> webElementList = webDriver.findElements(By.xpath("//table[@id='customers']//tr[3]/td"));
        System.out.println("--------Row3---------");
        for (WebElement element : webElementList) {
            System.out.println(element.getText());
        }

    }
    @Test
    public void contentOfLastColumn() {
        List<WebElement> webElementList = webDriver.findElements(By.xpath("//table[@id='customers']//td[last()]"));
        System.out.println("--------LastColumn---------");
        for (WebElement element : webElementList) {
            System.out.println(element.getText());
        }
    }
    @Test
    public void numberOfRowWithName() {
        String rowTarget = "Philip Cramer";
        List<WebElement> webElementList = webDriver.findElements(By.xpath("//table[@id='customers']//td[2]"));
        for (WebElement element : webElementList) {
            if(element.getText().contains(rowTarget)) {
                System.out.println("-----RowWithName-----");
                System.out.println("Row number is: " + (webElementList.indexOf(element) + 1));
            }
        }


    }

    @AfterTest
    public void tearDown (){
        webDriver.quit();
    }
}
