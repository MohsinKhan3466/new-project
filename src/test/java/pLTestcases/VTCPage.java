package pLTestcases;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;

public class VTCPage {

    Playwright playwright= Playwright.create();
    BrowserContext context;
    Page page;

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
    public void test_Case07(){
        //3. Verify that home page is visible successfully
        String actual_Title= page.title();
        assertEquals(actual_Title,"Automation Exercise","Please check the URL");
        System.out.println(actual_Title);

        //4. Click on 'Test Cases' button
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Test Cases")).click();

        //5. Verify user is navigated to test cases page successfully
        String testCasePageTitle= page.title();
        assertEquals(testCasePageTitle,"Automation Practice Website for UI Testing - Test Cases",
                "Wrong Button Clicked");
        System.out.println("\n"+testCasePageTitle);
    }

    @AfterTest
    public void shutDown(){
        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("TEST_CASE_PAGE.zip")));
    }
}
