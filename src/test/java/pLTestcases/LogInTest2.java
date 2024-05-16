package pLTestcases;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;

public class LogInTest2 {

    //All Xpaths:
    String signup_Login_buttonXpath="//*[text()=' Signup / Login']";
    String logInToAccTextXpath="//*[text()='Login to your account']";
    String emailXpath="//*[@action='/login']//*[@name='email']";
    String passXpath="//*[@action='/login']//*[@name='password']";
    String logInButtonXpath="//*[text()='Login']";
    String wrongMSGXpath="//*[text()='Your email or password is incorrect!']";



    //Necessary Values:
    String email="Tester12456@test.com";
    String password="Test@123";

    //Initializations:
    Playwright playwright=Playwright.create();
    Page page;
    BrowserContext context;

    @BeforeTest
    public void setUp(){

        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context= browser.newContext();
        // Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
        page= context.newPage();
        page.navigate("https://automationexercise.com/");
    }

    @Test
    public void test_Case3(){

        //3. Verify that home page is visible successfully:
        String actual_HomePage=page.title();
        assertEquals(actual_HomePage,"Automation Exercise","Please check the Url");
        System.out.println("The Title is:  "+actual_HomePage);

        //4. Click on 'Signup / Login' button:
        page.locator(signup_Login_buttonXpath).click();

        //5. Verify 'Login to your account' is visible:
       String actual_Text=page.locator(logInToAccTextXpath).textContent();
       assertEquals(actual_Text,"Login to your account","'Login to your account' is Not visible:");
        System.out.println("The login account Message is:  "+actual_Text);

       //6. Enter incorrect email address and password:
        page.locator(emailXpath).fill(email);
        page.locator(passXpath).fill(password);

        //7. Click 'login' button:
        page.locator(logInButtonXpath).click();

        //8. Verify error 'Your email or password is incorrect!' is visible:
        String wrongDetailsMSG=page.locator(wrongMSGXpath).textContent();
        assertEquals(wrongDetailsMSG,"Your email or password is incorrect!","'Your email or password is incorrect!' is not visible:");
        System.out.println("The alert Message is:  "+wrongDetailsMSG);
    }

    @AfterTest
    public void shutDown(){
        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("LogInTest2.zip")));
    }
}
