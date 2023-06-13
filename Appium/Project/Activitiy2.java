package activities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.RemoteWebDriverBuilder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Activitiy2 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.dialer");
        options.setAppActivity("com.android.dialer.incall.activity.ui.InCallActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void addNote() {
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();


        // Enter the name of notes
        driver.findElement(AppiumBy.xpath(
                "android.widget.EditText[@text='Title']"
        )).sendKeys("Appium");

       // driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
    }
}