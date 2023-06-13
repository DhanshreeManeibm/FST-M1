package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.awt.*;
import static java.awt.SystemColor.window;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.awt.*;
import static java.awt.SystemColor.window;
public class Activity7 {
    public static <JavaScriptexecutor> void main(String args[]) throws InterruptedException {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/crm/");
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        WebElement sales = driver.findElement(By.id("grouptab_0"));
        WebElement leads = driver.findElement(By.id("moduleTab_9_Leads"));
        Actions action = new Actions(driver);
        action.moveToElement(sales).perform();
        action.moveToElement(leads).click().perform();
        Thread thread = new Thread();
        thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        thread.sleep(1000);
        WebElement additionalinfo_icon = driver.findElement(By.xpath("(//span[@title='Additional Details'])[10]"));
        additionalinfo_icon.click();
        thread.sleep(1000);
        WebElement Mobile_number = driver.findElement(By.xpath("//span[@class='phone']"));
        System.out.println(Mobile_number.getText());
        thread.sleep(1000);
        driver.close();
    }
}