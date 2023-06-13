package activities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.RemoteWebDriverBuilder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import java.util.Arrays;
public class Activity1 {
    // Driver Declaration
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);

    }


    @Test
    public void addTask() {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();

        // Enter the name of tasks
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='New task']"
        )).sendKeys("Complete Activity with Google Tasks");

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
    }
    @Test
    public void addTask2() {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='New task']"
        )).sendKeys("Complete Activity with Google Keep");

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
    }
    @Test
    public void addTask3() {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='New task']"
        )).sendKeys("Complete Second Activity with Google Keep");

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
    }
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}