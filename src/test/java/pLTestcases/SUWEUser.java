package pLTestcases;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class SUWEUser {

    String name="Thomas";
    String email="armohkhan9@gmail.com";

    Playwright playwright= Playwright.create();
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
    public void test_Case05() throws IOException {
        Properties values = new Properties();
        FileInputStream inputStream = new FileInputStream("D:\\Project_Directory\\FP_01\\src\\main\\java" +
                "\\Configrations\\SignupConfig.properties");
        values.load(inputStream);

        //3. Verify that home page is visible successfully
        String actual_Title=page.title();
        assertEquals(actual_Title,"Automation Exercise","Please Check the Url");
        System.out.println("home page is visible successfully");

        //4. Click on 'Signup / Login' button
        page.locator(values.getProperty("Signup/Login_Button")).click();

        //5. Verify 'New User Signup!' is visible:
        String actualAlertMsg=page.locator(values.getProperty("NewUserSignupAlert")).textContent();
        assertEquals(actualAlertMsg,"New User Signup!","Please click on proper Signup_Button");
        System.out.println("'New User Signup!' is visible:");

        //6. Enter name and already registered email address:
        //Enter Name:
        page.locator(values.getProperty("NameTextBox")).fill(name);
        //Enter Email:
        page.locator(values.getProperty("SignUpEmailTextBox")).fill(email);

        //7. Click 'Signup' button:
        page.locator(values.getProperty("SignUpButton")).click();

        //8. Verify error 'Email Address already exist!' is visible
        String addressExistAlert=page.locator(values.getProperty("AlreadyExistingAddressAlert")).textContent();
        assertEquals(addressExistAlert,"Email Address already exist!","You Have Entered Already " +
                "Existing User Details");
        System.out.println("error 'Email Address already exist!' is visible");


    }
    @AfterTest
    public void shutDown(){
        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("SignUpWithExistingUser.zip")));
}
}
