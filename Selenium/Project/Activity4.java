package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
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

            // Close the browser
            driver.close();
        }
    }

