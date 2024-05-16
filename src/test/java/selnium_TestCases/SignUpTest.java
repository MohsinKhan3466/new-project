package selnium_TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.emailGenerator;

public class SignUpTest {

    WebDriver driver;
    @BeforeTest
    public void setUp(){
       driver= WebDriverManager.chromedriver().create();
       driver.get("https://automationexercise.com/");
       driver.manage().window().maximize();
    }
    //TestCase 1
    @Test
    public void test_Case1()  {

        String userName="Tester1";
        String email= emailGenerator.emailCreator();
        //3. Verify that home page is visible successfully
        String expected_Title="Automation Exercise";
        String actual_Title = driver.getTitle();
       if (expected_Title == actual_Title){
           System.out.println("home page is visible");
       }

      //4. Click on 'Signup / Login' button:
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

     //5. Verify 'New User Signup!' is visible:
     boolean Displayed= driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed();
     System.out.println("New User Signup is Visible:"+Displayed);

     //6. Enter name and email address:
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys(userName);
        driver.findElement(By.xpath("//form[@action='/signup']//*[@name='email']"))
                .sendKeys(email);

     //7. Click 'Signup' button:
     driver.findElement(By.xpath("//*[text()='Signup']")).click();
     System.out.println("Successfully SignedUp");

     //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible:

     //9. Fill details: Title, Name, Email, Password, Date of birth:

     driver.findElement(By.xpath("//*[@id='id_gender1']")).click();

     driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Test@123");

     WebElement days= driver.findElement(By.xpath("//*[@id='days']"));
        Select sc = new Select(days);
        sc.selectByValue("10");

     WebElement month= driver.findElement(By.xpath("//*[@id='months']"));
        Select sc1= new Select(month);
        sc1.selectByIndex(4);

     WebElement year= driver.findElement(By.xpath("//*[@id='years']"));
        Select sc2= new Select(year);
        sc2.selectByValue("1995");

     //10. Select checkbox 'Sign up for our newsletter!':
     driver.findElement(By.xpath("//input[@id='newsletter']")).click();


     //11. Select checkbox 'Receive special offers from our partners!':

     driver.findElement(By.xpath("//input[@id='optin']")).click();

     // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number:
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("HAJRA");

     driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("KHAN");

     driver.findElement(By.xpath("//*[@id='company']")).sendKeys("Vaisesika");

     driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("Kochi,Kerala");

     driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Kerala");

     driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Kochi");

     driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("4004567");

     driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys("+919850781901");

     //13. Click 'Create Account button':
     driver.findElement(By.xpath("//*[text()='Create Account']")).click();

     //14. Verify that 'ACCOUNT CREATED!' is visible:

        boolean ACDisplayed= driver.findElement(By.xpath("//*[@class='col-sm-9 col-sm-offset-1']")).isDisplayed();
        System.out.println("'ACCOUNT CREATED!'--> is Visible:"+ACDisplayed);

     //15. Click 'Continue' button:

     driver.findElement(By.xpath("//*[text()='Continue']")).click();

     //16. Verify that 'Logged in as username' is visible:
        boolean UNDisplayed= driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed();
        System.out.println(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).getText()+" isplayed-->"+UNDisplayed);

     //17. Click 'Delete Account' button:
     driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

     //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button:
        boolean ADDisplayed= driver.findElement(By.xpath("//*[@class='col-sm-9 col-sm-offset-1']")).isDisplayed();
        System.out.println("'ACCOUNT DELETED!' is visible-->"+ ADDisplayed);

        driver.findElement(By.xpath("//a[text()='Continue']")).click();

    }
    @AfterTest
    public void tearDown(){
      driver.close();
    }
}
