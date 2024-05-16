package SeleniumCoadingChallange;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedBus_Calander {
    public static void main(String[] args) {
        // Set the path to chromedriver
        WebDriver driver= WebDriverManager.chromedriver().create();

        // Open RedBus website
        driver.get("https://www.redbus.in/");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        // Click on the calendar input field
        WebElement calendarInput = driver.findElement(By.xpath("//*[@id='onwardCal']"));
        calendarInput.click();

        // Get current month and year
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();

        // Get the month and year displayed on the calendar
        WebElement monthElement = driver.findElement(By.xpath("//*[@class='sc-kAzzGY llxTcS']"));
        String monthYearText = monthElement.getText();
        String[] monthYear = monthYearText.split(" ");
        String monthString = monthYear[0];
        int year = Integer.parseInt(monthYear[1]);

        // Convert month string to integer
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM");
        LocalDate date = LocalDate.parse(monthString, formatter);
        int month = date.getMonthValue();

        // Check if the displayed month and year match the current month and year
        if (month == currentMonth && year == currentYear) {
            // Find all the dates in the calendar
            List<WebElement> dates = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']//td[@class='wd day']"));

            int holidayCount = 0;
            int weekendCount = 0;

            // Iterate through each date to check if it's a holiday or weekend
            for (WebElement dateElement : dates) {
                String day = dateElement.getText();
                String dayOfWeek = dateElement.getAttribute("title");

                // Check if it's a weekend (Saturday or Sunday)
                DayOfWeek dayOfWeekEnum = DayOfWeek.valueOf(dayOfWeek.toUpperCase());
                if (dayOfWeekEnum == DayOfWeek.SATURDAY || dayOfWeekEnum == DayOfWeek.SUNDAY) {
                    weekendCount++;
                }

                // Check if it's a holiday (if it's disabled)
                if (!dateElement.isEnabled()) {
                    holidayCount++;
                }
            }

            // Print the results
            System.out.println("Number of holidays: " + holidayCount);
            System.out.println("Number of weekends: " + weekendCount);
        } else {
            System.out.println("Calendar is not showing the current month and year.");
        }

        // Close the browser
        driver.quit();
    }

}