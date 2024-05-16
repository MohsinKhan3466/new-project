package pLTestcases;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactUsForm {

    Playwright playwright=Playwright.create();

    BrowserContext context;
    Page page;

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
    public void test_Case06() throws IOException, InterruptedException {

        Properties values=new Properties();
        FileInputStream inputStream= new FileInputStream("D:\\Project_Directory\\FP_01\\src\\main\\java" +
                "\\Configrations\\ContactUsForm.properties");
        values.load(inputStream);

        //3. Verify that home page is visible successfully:
        String actualTitle= page.title();
        assertEquals(actualTitle,"Automation Exercise","Please check the url");
        System.out.println("home page is visible successfully:");

        //4. Click on 'Contact Us' button:
        page.locator(values.getProperty("ContactUsButton")).click();

        //5. Verify 'GET IN TOUCH' is visible:
        String actual_Text=page.locator(values.getProperty("GetInTouchText")).textContent();
        assertEquals(actual_Text,"Get In Touch","You are not on contact Us Page");
        System.out.println("'GET IN TOUCH' is visible:");

        //6. Enter name, email, subject and message:
        page.locator(values.getProperty("CFNameTextBox")).fill(values.getProperty("name"));
        page.locator(values.getProperty("CFEmailTextBox")).fill(values.getProperty("email"));
        page.locator(values.getProperty("CFSubjectTextBox")).fill(values.getProperty("subject"));
        page.locator(values.getProperty("CFMessageTextBox")).fill(values.getProperty("message"));

        //7. Upload file
        page.setInputFiles(values.getProperty("ChooseFileButton"), Paths.get("D:\\Project_Directory\\FP_01\\" +
                "pictures\\brocken sofa.jpg"));


        //8. Click 'Submit' button:
        page.locator(values.getProperty("SubmitButton")).click();


        //9. Click OK button
        //accepting an PopUp Alert:
        Thread.sleep(4000);
        page.onDialog(dialog ->

                dialog.accept());


        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible:
       /* try {
           Locator message= page.getByRole(AriaRole.DEFINITION, new Page.GetByRoleOptions().setName("Success! Your " +
                   "details have been submitted successfully."));
           assertThat(message).isVisible();
        }catch (Exception e){

        }*/
        //11. Click 'Home' button and verify that landed to home page successfully:
        //Click 'Home' button
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Home"))
                .click();
        //verify that landed to home page successfully:
        String actualTitle1= page.title();
        assertEquals(actualTitle1,"Automation Exercise","Please check the url");
        System.out.println("home page is visible successfully:");

        }

    @AfterTest
    public void shutDown(){
        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("ContactUsForm.zip")));
    }

}
