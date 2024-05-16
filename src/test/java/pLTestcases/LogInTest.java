package pLTestcases;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class LogInTest {


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
    public void test_Case2() throws IOException {

        Properties values= new Properties();
        FileInputStream inputStream= new FileInputStream("D:\\Project_Directory\\FP_01\\src\\main\\java" +
                "\\Configrations\\LogINConfig.properties");
        values.load(inputStream);

        //3. Verify that home page is visible successfully:

        String actual_Title=page.title();
        assertEquals(actual_Title,"Automation Exercise","HomePage is Not visible");


        //4. Click on 'Signup / Login' button:
        page.locator(values.getProperty("SignUp/LogInButton")).click();

        //5. Verify 'Login to your account' is visible:
        String expected_Text=page.locator(values.getProperty("LogInToUrAccntText")).textContent();
        assertEquals(expected_Text,"Login to your account","'Login to your account' is Not visible:");

        //6. Enter correct email address and password:
        page.locator(values.getProperty("LogInEmailTextBox")).fill(email);
        page.locator(values.getProperty("LogInPassWordTextBox")).fill(password);

        //7. Click 'login' button:
        page.locator(values.getProperty("LogINButton")).click();

        //8. Verify that 'Logged in as username' is visible:
        String actual_Admin_Name=page.locator(values.getProperty("AdminName")).textContent();
        assertEquals(actual_Admin_Name," Logged in as Tester","'Logged in as username' is Not visible:");

    }

    @AfterTest
    public void shutDown(){
        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("LogInTest.zip")));
    }

}
