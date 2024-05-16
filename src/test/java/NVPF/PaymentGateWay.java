package NVPF;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PaymentGateWay {

    WebDriver driver;

    @BeforeTest
    public void setDriver(){

        driver= WebDriverManager.chromedriver().create();

        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void paymentTest(){

        WebElement tabletMenu= driver.findElement(By.xpath("//a[text()='Tablets']"));
                   tabletMenu.click();

        WebElement product_1= driver.findElement(By.xpath("//*[@class='caption']//a[text()='Samsung Galaxy Tab 10.1']"));
                   product_1.click();

        WebElement quantity= driver.findElement(By.xpath("//input[@id='input-quantity']"));
                   quantity.sendKeys("2");

        WebElement addToCartButton= driver.findElement(By.xpath("//button[@id='button-cart']"));
                   addToCartButton.click();

        WebElement cart= driver.findElement(By.xpath("//*[@id='cart-total']"));
                   cart.click();
        WebElement viewCart= driver.findElement(By.xpath("//*[text()=' View Cart']"));
                   viewCart.click();

        WebElement checkout= driver.findElement(By.xpath("//*[@class='btn btn-primary' and text()='Checkout']"));
                   checkout.click();
    }
}
