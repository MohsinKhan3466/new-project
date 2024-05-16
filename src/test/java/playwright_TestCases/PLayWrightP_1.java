package playwright_TestCases;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class PLayWrightP_1 {

    public static void main(String[] args) {
     try (Playwright playwright = Playwright.create()) {

         Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
         BrowserContext context= browser.newContext();
         // Start tracing before creating / navigating a page.

         context.tracing().start(new Tracing.StartOptions()
                 .setScreenshots(true)
                 .setSnapshots(true)
                 .setSources(true));

         Page page = context.newPage();
         page.navigate("https://www.amazon.com/gp/css/homepage.html/ref=nav_bb_ya");

         String title = page.title();
         System.out.println("Page title is:" + title);

         String url = page.url();
         System.out.println("Page url is:" + url);

         page.click("text=Hello, sign in");

         // Stop tracing and export it into a zip archive.
         context.tracing().stop(new Tracing.StopOptions()
                 .setPath(Paths.get("trace.zip")));

         browser.close();
         playwright.close();

     }
    }
}
