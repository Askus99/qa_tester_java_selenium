package cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/cucumber/resources/features/Login.feature",
                "src/test/java/cucumber/resources/features/Cart.feature",
                "src/test/java/cucumber/resources/features/Logout.feature",
                "src/test/java/cucumber/resources/features/Checkout.feature",},
        glue = "cucumber.stepDef",
        plugin = {"html:target/HTML_report.html"}
)
public class run {
}
