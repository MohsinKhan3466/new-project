package NVPF;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.emailGenerator;

import java.util.concurrent.TimeUnit;

public class RegistrationAndLogin {

    WebDriver driver;

    String emailId=emailGenerator.emailCreator();

    @BeforeTest
    public void setUp(){

        driver= WebDriverManager.chromedriver().create();

        driver.get("https://naveenautomationlabs.com/opencart/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void registrationTest(){

        WebElement myAccount =driver.findElement(By.xpath("//*[@class='hidden-xs hidden-sm hidden-md' and text()='My Account']"));
                   myAccount.click();

        WebElement registration=driver.findElement(By.xpath("//*[text()='Register']"));
                   registration.click();

        WebElement first_Name= driver.findElement(By.xpath("//*[@id='input-firstname']"));
                   first_Name.sendKeys("Hajra");

        WebElement last_Name= driver.findElement(By.xpath("//*[@id='input-lastname']"));
                   last_Name.sendKeys("Khan");

        WebElement email_Id= driver.findElement(By.xpath("//*[@id='input-email']"));
                   email_Id.sendKeys(emailId);

        WebElement telephone= driver.findElement(By.xpath("//*[@id='input-telephone']"));
                   telephone.sendKeys("99999999999");

        WebElement password= driver.findElement(By.xpath("//*[@id='input-password']"));
                   password.sendKeys("Test@123");

        WebElement confirm_Password= driver.findElement(By.xpath("//*[@id='input-confirm']"));
                   confirm_Password.sendKeys("Test@123");

        WebElement agreeCheckbox= driver.findElement(By.xpath("//*[@name='agree']"));
                   agreeCheckbox.click();

        WebElement continue_Button= driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
                   continue_Button.click();

        WebElement successText= driver.findElement(By.xpath("//*[@id='content']"));
        System.out.println(successText.getText());

        WebElement nextPageContinueButton=driver.findElement(By.xpath("//a[text()='Continue']"));
                   nextPageContinueButton.click();

        WebElement logoutButton= driver.findElement(By.xpath("//a[@class='list-group-item' and text()='Logout']"));
                   logoutButton.click();

        WebElement continue_Button2= driver.findElement(By.xpath("//*[text()='Continue']"));
                   continue_Button2.click();
    }

    @Test(priority = 2,dependsOnMethods = "registrationTest")
    public void logInTest(){

       WebElement myAccount =driver.findElement(By.xpath("//*[@class='hidden-xs hidden-sm hidden-md' and text()='My Account']"));
                  myAccount.click();

       WebElement logInButton= driver.findElement(By.xpath("//*[text()='Login']"));
                  logInButton.click();

       WebElement email= driver.findElement(By.xpath("//*[@id='input-email']"));
                  email.sendKeys(emailId);

       WebElement password= driver.findElement(By.xpath("//*[@id='input-password']"));
                  password.sendKeys("Test@123");

       WebElement logInSubmitButton= driver.findElement(By.xpath("//*[@value='Login' and @class='btn btn-primary']"));
                  logInSubmitButton.click();

        WebElement logoutButton= driver.findElement(By.xpath("//a[@class='list-group-item' and text()='Logout']"));
                   logoutButton.click();

        WebElement continue_Button2= driver.findElement(By.xpath("//*[text()='Continue']"));
                   continue_Button2.click();

    }

    @AfterTest
    public void shutDown(){
        driver.quit();
    }
}
