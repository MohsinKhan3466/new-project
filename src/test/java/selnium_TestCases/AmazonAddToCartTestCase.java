package selnium_TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonAddToCartTestCase {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver= WebDriverManager.chromedriver().create();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void addToCart(){

        String amazon_Title= driver.getTitle();
        System.out.println(amazon_Title);

        driver.findElement(By.xpath("//a[text()=' Electronics ']")).click();
        driver.findElement(By.xpath("//*[@class='sl-sobe-carousel-sub-card-footer']" +
                "//*[text()='Home Audio']")).click();
        driver.findElement(By.xpath("//*[@class='a-truncate-cut'and text()='boAt Stone" +
                " 135 Portable Wireless Speaker with…']")).click();
        driver.findElement(By.xpath(" //*[@id='submit.add-to-cart']")).click();

        Boolean cart_Title= driver.getTitle().equalsIgnoreCase("Amazon.in Shopping Cart");
        Assert.assertTrue(cart_Title);
        System.out.println(cart_Title);
    }

    @AfterTest
    public void shutDown(){
        driver.quit();
    }
}
