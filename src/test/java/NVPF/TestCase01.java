package NVPF;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.emailGenerator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestCase01 {

    String email= emailGenerator.emailCreator();
    WebDriver driver;

    @BeforeTest
    public void setUp(){

        driver= WebDriverManager.chromedriver().create();

        driver.get("https://naveenautomationlabs.com/opencart/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void registrationTest() throws IOException {
        Properties value= new Properties();
        FileInputStream inputStream=new FileInputStream("D:\\Project_Directory\\FP_01\\src\\main\\java" +
                "\\Configrations\\NVRegistration.properties");
        value.load(inputStream);

        WebElement myAccountOption=driver.findElement(By.xpath("//*[@class='hidden-xs hidden-sm hidden-md' and text()='My Account']" ));
                   myAccountOption.click();
        WebElement registerAccntLink=driver.findElement(By.xpath("//*[text()='Register']"));
                   registerAccntLink.click();

        //Registration Form:
        WebElement firstName=driver.findElement(By.xpath("//*[@id='input-firstname']"));
                   firstName .sendKeys(value.getProperty("First_Name"));

        WebElement lastName=driver.findElement(By.xpath("//*[@id='input-lastname']"));
                   lastName.sendKeys(value.getProperty("Last_Name"));

        WebElement emailId=driver.findElement(By.xpath("//*[@id='input-email']"));
                   emailId.sendKeys(email);
        WebElement telephone= driver.findElement(By.xpath("//*[@id='input-telephone']"));
                   telephone.sendKeys(value.getProperty("Telephone"));

        WebElement password= driver.findElement(By.xpath("//*[@id='input-password']"));
                   password.sendKeys(value.getProperty("Password"));

        WebElement confirmPass=driver.findElement(By.xpath("//*[@id='input-confirm']"));
                   confirmPass.sendKeys(value.getProperty("Confirm_Password"));

        WebElement agreeCheckBox=driver.findElement(By.xpath("//*[@name='agree']"));
                   agreeCheckBox.click();

        WebElement continueButton=driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
                   continueButton.click();

        WebElement successText= driver.findElement(By.xpath("//*[@id='content']"));
        System.out.println(successText.getText());

        WebElement nextPageContinueButton=driver.findElement(By.xpath("//a[text()='Continue']"));
                   nextPageContinueButton.click();

        WebElement logoutButton= driver.findElement(By.xpath("//a[@class='list-group-item' and text()='Logout']"));
                   logoutButton.click();
    }

    @AfterTest
    public void closeTest(){
        driver.quit();
    }

}
