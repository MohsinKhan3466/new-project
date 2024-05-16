package pLTestcases;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;

public class LogOutTest {
    //All Xpaths:
    String signup_Login_buttonXpath="//*[text()=' Signup / Login']";
    String logInToAccTextXpath="//*[text()='Login to your account']";
    String emailXpath="//*[@action='/login']//*[@name='email']";
    String passXpath="//*[@action='/login']//*[@name='password']";
    String logInButtonXpath="//*[text()='Login']";
    String adminNameXpath="//*[text()=' Logged in as ']";
    String logOutXpath="//*[text()=' Logout']";


    //Necessary Values:
    String email="armohkhan9@gmail.com";
    String password="Test@123";

    //Initializations:
    Playwright playwright=Playwright.create();
    Page page;
    BrowserContext context;

    @BeforeTest
    public void setUp(){

        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
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
    public void test_Case2(){

        //3. Verify that home page is visible successfully:

        String actual_Title=page.title();
        assertEquals(actual_Title,"Automation Exercise","HomePage is Not visible");
        System.out.println(actual_Title);


        //4. Click on 'Signup / Login' button:
        page.locator(signup_Login_buttonXpath).click();

        //5. Verify 'Login to your account' is visible:
        String expected_Text=page.locator(logInToAccTextXpath).textContent();
        assertEquals(expected_Text,"Login to your account","'Login to your account' is Not visible:");
        System.out.println(expected_Text);

        //6. Enter correct email address and password:
        page.locator(emailXpath).fill(email);
        page.locator(passXpath).fill(password);

        //7. Click 'login' button:
        page.locator(logInButtonXpath).click();

        //8. Verify that 'Logged in as username' is visible:
        String actual_user_Name=page.locator(adminNameXpath).textContent();
        assertEquals(actual_user_Name," Logged in as Tester","'Logged in as username' is Not visible:");
        System.out.println(actual_user_Name);

        //9. Click 'Logout' button:
        page.locator(logOutXpath).click();

        //10. Verify that user is navigated to login page:
        String navigation=page.title();
        assertEquals(navigation,"Automation Exercise - Signup / Login","user is not navigated to login page:");
        System.out.println(navigation);
    }

    @AfterTest
    public void shutDown(){
        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("LogOutTest.zip")));
    }
}
