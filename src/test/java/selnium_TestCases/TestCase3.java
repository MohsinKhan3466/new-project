package selnium_TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase3 {

    WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver= WebDriverManager.chromedriver().create();
        driver.get("http://automationexercise.com");
        driver.manage().window().maximize();
    }

    @Test
    public void testCase3(){

        //3. Verify that home page is visible successfully:
        String expected_Title="Automation Exercise";
        String actual_Title = driver.getTitle();
        if (expected_Title == actual_Title){
            System.out.println("Home Page is visible");
        }

        //4. Click on 'Signup / Login' button:
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //5. Verify 'Login to your account' is visible:
        boolean logInDisplayed= driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed();
        System.out.println("'Login to your account' is visible: "+logInDisplayed);

        //6. Enter incorrect email address and password:
        driver.findElement(By.xpath("//*[@action='/login']//*[@name='email']")).sendKeys("tester.khan34545@test.com");
        driver.findElement(By.xpath("//*[@action='/login']//*[@name='password']")).sendKeys("ter2373");

        //7. Click 'login' button:
        driver.findElement(By.xpath("//*[@action='/login']//*[text()='Login']")).click();

        //8. Verify error 'Your email or password is incorrect!' is visible:
        boolean errormsgDisplayed= driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).isDisplayed();
        System.out.println("'Your email or password is incorrect!..' is visible: "+errormsgDisplayed);

    }
}
