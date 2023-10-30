package screenplay.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class SSOPage {

    public static String getAuthToken() {
        for (Cookie c : getDriver().manage().getCookies()) {
            if (c.toString().contains("AUTH_TOKEN")) {
                return c.getValue();
            }
        }
        return "Not found AUTH_TOKEN";
    }

}
