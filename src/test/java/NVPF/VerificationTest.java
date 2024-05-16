package NVPF;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VerificationTest {

    WebDriver driver;

    @BeforeTest
    public void setUP(){

        driver= WebDriverManager.chromedriver().create();

        driver.get("https://naveenautomationlabs.com/opencart/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void logoTest(){
    //Verify that the company logo and name are clearly visible:

        //identify image
        WebElement i = driver.findElement
                (By.xpath("//img[@title='naveenopencart']"));
        // Javascript executor to check image
        Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

        //verify if status is true
        if (p) {
            System.out.println("Logo present");
        } else {
            System.out.println("Logo not present");
        }


    }
    @Test
    public void navigateThroughProductList(){

        //Verify that the user is able to navigate through all the products across different categories:
        List<WebElement> productsList= driver.findElements(By.xpath("//*[@class='collapse navbar-collapse " +
                "navbar-ex1-collapse']"));

        for (WebElement products:productsList){

            System.out.println(products.getText());
        }

    }

    @Test
    public void allLinksTest(){
        //Verify that all the links and banners are redirecting to the correct
        //product/category pages and none of the links are broken:

        String links;
        List<WebElement> allLinks= driver.findElements(By.tagName("a"));
        System.out.println("all the links on the webpage:"+allLinks.size());

        //iterate through all the links:

        for (WebElement allLink : allLinks) {
            links = allLink.getText();
            System.out.println(links);
        }
    }

    @Test
    public void infoDisplayed() {

        //Verify that all the information displayed – product name, category name, price, and product
        // description is clearly visible.


        WebElement iphone = driver.findElement(By.xpath("//a[text()='iPhone']"));
        iphone.click();

        WebElement productName = driver.findElement(By.xpath("//h1[text()='iPhone']"));
        Boolean isProductNameDisplayed = productName.isDisplayed();
        System.out.println("Is product name is displayed 'Yes-->true' and 'No-->false' : " + isProductNameDisplayed);

        WebElement brandName = driver.findElement(By.xpath("//*[text()='Apple']"));
        Boolean isBrandNameVisible = brandName.isDisplayed();
        System.out.println("Is brand or category is visible?: " + isBrandNameVisible);

        WebElement initialPrice = driver.findElement(By.xpath("//h2[text()='$123.20']"));
        String initialV = initialPrice.getText();
        initialV = initialV.replaceAll("[^0-9]+", "");
        int initalValue = Integer.parseInt(initialV);

        WebElement taxes = driver.findElement(By.xpath("//li[text()='Ex Tax: $101.00']"));
        String exTax = taxes.getText();
        exTax = exTax.replaceAll("[^0-9]+", "");
        int exTaxes = Integer.parseInt(exTax);

        int totalPrice = initalValue + exTaxes;
        System.out.println("Overall/Total price of product Is: " + totalPrice);

        WebElement description = driver.findElement(By.xpath("//*[@class='intro']"));
        Boolean isDescriptionDisplayed = description.isDisplayed();

        System.out.println("Is Description is Displayed?: (Y/N) " + isDescriptionDisplayed);
        System.out.println("Description : " + description.getText());
    }
    @Test
    public void bannerImagesTest(){
        //Verify that all the images – product and banner are clearly visible.

        String images;
        List<WebElement> allImages=  driver.findElements(By.tagName("img"));

        System.out.println("all the Images on the webpage:"+allImages.size());

        //iterate through all the links:

        for (WebElement allImage : allImages) {
            images = allImage.getText();
            System.out.println(images);
            Boolean isAllImagesDisplayed=allImage.isDisplayed();
            System.out.println("Is All the Images are Visible(True/False): "+isAllImagesDisplayed);
        }


    }
}
