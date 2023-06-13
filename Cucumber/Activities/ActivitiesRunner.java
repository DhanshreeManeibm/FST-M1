package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




/* @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/java/Features",
            glue = {"stepDefinitions"},
            tags = "@Activity1"
    )

    public class ActivitiesRunner {
        //empty
    }
import org.junit.runner.RunWith;
        import io.cucumber.junit.Cucumber;
        import io.cucumber.junit.CucumberOptions;  */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@SmokeTest",
        plugin = {"pretty"},
        monochrome = true
)


public class ActivitiesRunner {

}
