package topicWise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class WindowsHandling {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","D:\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test_Case() {
        driver.get("https://demo.automationtesting.in/Windows.html");

        driver.findElement(By.xpath("//a[@href='http://www.selenium.dev']/button[@class='btn btn-info' and text()='    click   ']")).click();
        System.out.println(driver.getTitle());

        Set <String> handles= driver.getWindowHandles();
        Iterator <String> it= handles.iterator();

        String parent_Window = it.next();
        System.out.println(parent_Window);

        String child_window= it.next();
        System.out.println(child_window);

        driver.switchTo().window(child_window);
        driver.findElement(By.xpath("//a[@class='nav-link']/span[text()='Documentation']")).click();

       String page_source= driver.getPageSource();
       System.out.println(page_source);

       driver.switchTo().window(parent_Window);

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
