package NVPF;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageFunctions {


    public void homePageButtonsandFunctions(WebDriver driver){

        WebElement currency= driver.findElement(By.xpath("//*[text()='Currency']"));

        WebElement myAccountOption=driver.findElement(By.xpath("//*[@class='hidden-xs hidden-sm hidden-md' and text()='My Account']" ));

        WebElement wishList= driver.findElement(By.xpath("//*[text()='Wish List (0)']"));

        WebElement cart= driver.findElement(By.xpath("//*[text()='Shopping Cart']"));

        WebElement checkout= driver.findElement(By.xpath("//*[text()='Checkout']"));

        WebElement searchBar= driver.findElement(By.xpath("//*[@name='search']"));

        WebElement searchButton= driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));

    }
}
