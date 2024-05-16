package selnium_TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

import static java.util.Map.*;


public class Amazon1 {

    public static void main(String[] args) {

        WebDriver driver= WebDriverManager.chromedriver().create();

        driver.get("https://www.amazon.in/");

        driver.manage().window().maximize();


        WebElement searchBox=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Mobile phones");

        WebElement searchButton= driver.findElement(By.xpath("//*[@id='nav-search-submit-button']"));
        searchButton.click();

        List<WebElement> itemsPrices= driver.findElements(By.cssSelector("[class='a-price-whole']"));

        Map<WebElement,Integer> map= new HashMap<>();
        for (int i=0; i<=itemsPrices.size()-1; i++) {

            if (!Objects.equals(itemsPrices.get(i).getText(), "")) {
               map.put(itemsPrices.get(i), Integer.parseInt(itemsPrices.get(i).getText().replaceAll(",", "")));
            }
        }

        List<Map.Entry<WebElement,Integer>> le = new ArrayList<>(map.entrySet());
        le.sort(Entry.comparingByValue());

        for (Entry e:le){
            System.out.println(e.getValue());
        }
        le.get(0).getKey().click();

        System.out.println("Mobile phone in lowest price is:"+le.get(0).getKey());

        driver.close();
    }
}
