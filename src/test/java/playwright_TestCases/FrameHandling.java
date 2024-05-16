package playwright_TestCases;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class FrameHandling {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();

        // Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        Page page =browser.newPage();

        page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

        page.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();
        page
                .frameLocator("//iframe[contains(@id,'frame-one')]")
                        .locator("#RESULT_TextField-1").fill("Vehicle 1");

        page.frameLocator("//iframe[contains(@id,'frame-one')]")
                .locator("#RESULT_TextField-3").fill("India");

        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("reg_form.zip")));


//        String headertitle=page.frameLocator("frame[name='main']").locator("h2").textContent();
//        System.out.println(headertitle);

//          String hearderTitle = page.frame("main").locator("h2").textContent();
//          System.out.println(hearderTitle);

        page.close();


    }
}
