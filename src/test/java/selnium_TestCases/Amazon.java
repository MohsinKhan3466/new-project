package selnium_TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Amazon {

    WebDriver driver;

    Properties values= new Properties();
    FileInputStream is= new FileInputStream("D:\\Project_Directory\\FP_01\\src\\main\\java\\Configrations\\Amazon.properties");

    public Amazon() throws IOException {


    }
    @BeforeTest
    public void setUp() throws IOException {
        values.load(is);
        driver= WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();


    }

    @Test
    public void test() throws AWTException {
        driver.get(values.getProperty("url"));

        WebElement electronics=driver.findElement(By.xpath(values.getProperty("Electronicss")));

        Select selectElectronics= new Select(electronics);
        selectElectronics.selectByValue("search-alias=electronics");

        WebElement button=driver.findElement(By.xpath(values.getProperty("SearchThroughImage")));
        JavascriptExecutor js= ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click()",button);

        Robot rb= new Robot();
        rb.delay(2000);

        StringSelection ss= new StringSelection("D:\\Project_Directory\\FP_01\\pictures\\MT4J3_AV1.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

        //Ctrl+V
        rb.keyPress(KeyEvent.VK_CONTROL); //will press the ctrl+V
        rb.keyPress(KeyEvent.VK_V); //will press the ctrl+V

        rb.keyRelease(KeyEvent.VK_CONTROL); //will release the ctrl+v
        rb.keyRelease(KeyEvent.VK_V);  //will release the ctrl+v

        // Enter Key
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }
}
