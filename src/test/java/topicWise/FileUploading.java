package topicWise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploading {

    public static void main(String[] args) throws AWTException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.foundit.in/seeker/registration");
        driver.manage().window().maximize();

        // We can upload the file using two ways the first one is 1) by using SendKeys;
        // 2) by using Robot class Method:
        WebElement button=driver.findElement(By.xpath("//*[@id=\"basicDetails\"]/div[1]/div[4]/div[1]/div"));
        JavascriptExecutor js= ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click()",button);

        Robot rb= new Robot();
        rb.delay(2000);

        //To put the path of file into clipboard-->(ctrl+c)
        StringSelection ss= new StringSelection("C:\\Users\\mohsin.khan\\Desktop\\Desktop\\pronoune.docx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

        //Ctrl+V
        rb.keyPress(KeyEvent.VK_CONTROL); //will press the ctrl+V
        rb.keyPress(KeyEvent.VK_V); //will press the ctrl+V

        rb.keyRelease(KeyEvent.VK_CONTROL); //will release the ctrl+v
        rb.keyRelease(KeyEvent.VK_V);  //will release the ctrl+v

        // Enter Key
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);








    }
}
