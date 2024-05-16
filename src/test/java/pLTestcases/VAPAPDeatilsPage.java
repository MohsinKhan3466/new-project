package pLTestcases;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class VAPAPDeatilsPage {

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
    public void test_Case09() throws IOException {
        Properties values=new Properties();
        FileInputStream inputStream= new FileInputStream("D:\\Project_Directory\\FP_01\\src\\main\\java" +
                "\\Configrations\\ProductPage.properties");
        values.load(inputStream);

        //3. Verify that home page is visible successfully
        String actual_Title= page.title();
        assertEquals(actual_Title,"Automation Exercise","Please check the URL");
        System.out.println(actual_Title);

        //4. Click on 'Products' button:
        page.locator(values.getProperty("productsButton")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String product_Page= page.title();
        assertEquals(product_Page,"Automation Exercise - All Products","You clicked wrong button");
        System.out.println(product_Page);

        //6. The products list is visible
        Locator productList=page.locator(values.getProperty("allProductsXpath"));
        List<String> allproducts= productList.allTextContents();
        System.out.println(allproducts);

        //7. Click on 'View Product' of first product
        page.locator(values.getProperty("firstProductViewPageXpath")).click();

        //8. User is landed to product detail page
        String firstProductPage=page.title();
        assertEquals(firstProductPage,"Automation Exercise - Product Details","You are not landed on " +
                "first product's details page ");
        System.out.println(firstProductPage);

        //
        List<String> details=page.locator("//div[@class='product-information']").allTextContents();
        System.out.println(details);
    }


    @AfterTest
    public void shutDown(){
        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("Products.zip")));
    }
}
