package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        driver.findElement(By.id("grouptab_0")).click();
        driver.findElement(By.id("moduleTab_9_Leads")).click();
        Thread.sleep(1000);
        List<WebElement> leads_table_name_column= driver.findElements(By.xpath("(//td[@type='name'])"));
        for(WebElement column_name:leads_table_name_column)
        {
            System.out.println("names of the name columns are:"+column_name.getText());
        }
        Thread.sleep(1000);
        List<WebElement> leads_table_users_column= driver.findElements(By.xpath("(//td[@type='relate'])"));
        for(WebElement column_user:leads_table_users_column)
        {
            System.out.println("names of the users are:"+column_user.getText());
        }
        driver.close();
    }
}