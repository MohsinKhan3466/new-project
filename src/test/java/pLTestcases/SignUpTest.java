package pLTestcases;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.emailGenerator;

import java.nio.file.Paths;

public class SignUpTest {

    public String email = emailGenerator.emailCreator();
    public String name = "Hajra";
    Playwright playwright = Playwright.create();
    Page page;
    BrowserContext context;

    @BeforeTest
    public void setUp(){

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        // Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
        page = context.newPage();
        page.navigate("https://automationexercise.com/");

    }

    @Test
    public void test_Case1(){

        //3. Verify that home page is visible successfully:
        boolean displayed = page.locator("xpath=//title[text()='Automation Exercise']").isVisible();
        System.out.println("IS HomePage is visible:--->" + displayed);

        //4. Click on 'Signup / Login' button:
        page.locator("xpath=//*[text()=' Signup / Login']").click();

        //5. Verify 'New User Signup!' is visible:
        boolean nusDisplayed = page.locator("xpath=//h2[text()='New User Signup!']").isVisible();
        System.out.print("IS 'New User Signup!' is visible:--->" + nusDisplayed);

        //6. Enter name and email address:
        page.locator("xpath=//*[@name='name']").fill(name);
        page.locator("xpath=//form[@action='/signup']//*[@name='email']").fill(email);

        //7. Click 'Signup' button:
        page.locator("//*[text()='Signup']").click();

        //9. Fill details: Title, Name, Email, Password, Date of birth:
        //1.Title--Radio Button:
        page.locator("xpath=//*[@id='id_gender2']").click();
        //4.Password:
        page.locator("xpath=//*[@id='password']").fill("Test123");
        //Date of birth: Day
        Locator selectDay = page.locator("#days");
        selectDay.selectOption("6");
        //Month
        Locator selectMonth = page.locator("#months");
        selectMonth.selectOption("May");
        //Year
        Locator selectYear = page.locator("#years");
        selectYear.selectOption("1996");

        //10. Select checkbox 'Sign up for our newsletter!':
        page.locator("xpath=//*[@id='newsletter']").click();

        //11. Select checkbox 'Receive special offers from our partners!':
        page.locator("xpath=//*[@id='optin']").click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number:
        //First name:
        page.locator("xpath=//*[@id='first_name']").fill("Hajra Tasneem");
        //Last name:
        page.locator("//*[@id='last_name']").fill("Mohsin Khan");
        //Company:
        page.locator("//*[@id='company']").fill("House Making pvt ltd");
        //Address :
        page.locator("//*[@id='address1']").fill("Narsing Colony");
        //Address 2:
        page.locator("//*[@id='address2']").fill("Old City Akola");
        //Country:
        Locator country = page.locator("xpath=//select[@id='country']");
        country.selectOption("India");
        //State:
        page.locator("//*[@id='state']").fill("Maharashtra");
        //City
        page.locator("//*[@id='city']").fill("Akola");
        //Zipcode
        page.locator("//*[@id='zipcode']").fill("444004");
        //Mobile Number
        page.locator("//*[@id='mobile_number']").fill("+911234567890");

        //13. Click 'Create Account button':
        page.locator("//*[text()='Create Account']").click();

        //14. Verify that 'ACCOUNT CREATED!' is visible:
        Locator accountCreated = page.locator("//div[@class='col-sm-9 col-sm-offset-1']");
        System.out.println("\nVerification Message:\n " + accountCreated.textContent());

        //15. Click 'Continue' button:
        page.locator("//*[text()='Continue']").click();

        //16. Verify that 'Logged in as username' is visible:
        Locator username = page.locator("//*[text()=' Logged in as ']");
        System.out.println("IS username is visible:"+username.isVisible());
        System.out.println("Visible userName is:  " + username.textContent());

        //17. Click 'Delete Account' button:
        page.locator("//*[text()=' Delete Account']").click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button:
        //Verify that 'ACCOUNT DELETED!'
        Locator accountDeleted= page.locator("//*[@class='col-sm-9 col-sm-offset-1']");
        System.out.println("\n'ACCOUNT DELETED' is Visible: "+accountDeleted.textContent());
        //Click 'Countinue' button:
        page.locator("//*[text()='Continue']").click();


    }

    @AfterTest
    public void shutDown(){
        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("SignUPTest.zip")));
        page.close();
    }
}
