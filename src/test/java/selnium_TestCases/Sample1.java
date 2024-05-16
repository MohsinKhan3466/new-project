package selnium_TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Sample1 {

    WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver= WebDriverManager.chromedriver().create();
        driver.get("https://www.globalsqa.com/demo-site/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void fstep_Tabs(){

        WebElement tabs_Link= driver.findElement(By.xpath("//a[text()='Tabs']"));
        tabs_Link.click();

        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        WebElement section_2= driver.findElement(By.xpath("//h3[@id='ui-id-3']"));


        section_2.click();

        WebElement section_2_text= driver.findElement(By.xpath("//*[@id='ui-id-4']"));
        System.out.println(section_2_text.getText());

    }
}
