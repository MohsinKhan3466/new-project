package playwright_TestCases;


import com.microsoft.playwright.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextSelector {
    Playwright playwright = Playwright.create();
    Page page;

    @BeforeTest
    public void setUp(){

      Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

    page = browser.newPage();
    page.navigate("https://demo.opencart.com/index.php?route=account/login");

    }

    @Test
   public void youTest(){
    String newCustomerText= page.locator("h2:New Customer").textContent();
    System.out.println(newCustomerText);


   }
}
