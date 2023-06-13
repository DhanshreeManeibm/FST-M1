package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.List;

public class Activity6 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("http://alchemy.hguy.co/crm");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find the username field and enter the username
        driver.findElement(By.id("user_name")).sendKeys("admin");
        // Find the password field and enter the password
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.id("bigbutton"));
        loginButton.click();
        driver.findElement(By.id("toolbar")).click();

        // Validate ACTIVITIES menu exists
        By elementLocator = By.id("grouptab_3");
        List<WebElement> elements = driver.findElements(elementLocator);


        if(elements.size() > 0) {
            System.out.println("ACTIVITIES MENU ITEM EXISTS");
        }
        else
        {
            System.out.println("ACTIVITIES MENU ITEM DOES NOT EXIST");
        }
        driver.close();
    }
}


