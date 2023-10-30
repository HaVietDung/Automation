package smartosc.cucumber;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = "pretty",
        features = "src/test/resources/features/login",
        glue = {"smartosc.hook", "smartosc.login", "smartosc.compare_price", "smartosc.lesson4"},
        tags = "@compare"
//        tags = "@lesson4"
)
public class LoginTestSuite {
}
