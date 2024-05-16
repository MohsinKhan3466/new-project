package selnium_TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.JavaScriptUtilities;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AmazonTestCase2 {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.amazon.in/");
    }

    @Test
    public void addToCart2() throws InterruptedException {

        String homePage_Title = driver.getTitle();
        System.out.println(homePage_Title);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one leg cycle for kids 3 to 5");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']")).click();

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);


       WebElement addToCart= driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
       System.out.println(addToCart.isDisplayed());



    }
}
