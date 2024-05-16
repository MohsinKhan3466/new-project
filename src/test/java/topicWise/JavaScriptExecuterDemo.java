package topicWise;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.JavaScriptUtilities;
import java.io.IOException;

public class JavaScriptExecuterDemo {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver","D:\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.twoplugs.com/");
        driver.manage().window().maximize();

        //Flashing:

//        WebElement joinfree = driver.findElement(By.xpath("/html/body/div/header/div/ul/li[1]/a"));

       // JavaScriptUtilities.flash(joinfree,driver);

        //Draw Border & Screenshot:
//        JavaScriptUtilities.drawBorder(joinfree,driver);
//
//        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        File trg= new File("C:\\Users\\mohsin.khan\\Desktop\\Desktop\\twoplugs.png");
//        FileUtils.copyFile(src, trg);

        //Capturing Title of a page:
        //System.out.println(driver.getTitle());

        String title = JavaScriptUtilities.getTitleByJS(driver);
        System.out.println(title);


      //  WebElement loginBtn = driver.findElement(By.xpath("/html/body/div/header/div/ul/li[1]/a"));

        //Login Button Click by JS
        //JavaScriptUtilities.clikElementByJS(loginBtn, driver);

        //Generate Alert
        //JavaScriptUtilities.generateAlert(driver,"You have Clicked Login Button Successfully");

        //Refreshing page:
        //driver.navigate().refresh(); -->Traditional way
        //By using JS Executer:
        JavaScriptUtilities.refreshBrowserByJS(driver);

        //Scrolling page down till we found element:
//        WebElement image = driver.findElement(By.xpath("//*[@id=\"rslides3_s0\"]/div[1]/img"));
//        JavaScriptUtilities.scrollIntoView(image,driver);
//        Thread.sleep(2000);

        //Srolling page down till end:
        JavaScriptUtilities.scrollPageDown(driver);
        Thread.sleep(2000);

        driver.quit();

    }
}
