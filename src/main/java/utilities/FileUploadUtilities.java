package utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploadUtilities {

    public static void uploadFile(WebDriver driver, WebElement webElement) throws AWTException {


        JavascriptExecutor js= ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click()",webElement);

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
