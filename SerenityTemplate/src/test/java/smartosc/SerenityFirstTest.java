package smartosc;

import org.openqa.selenium.By;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class SerenityFirstTest {
    public static void main(String[] args) {
        getDriver().get("https://www.lg.com/uk/login/");

        getDriver().findElement(By.xpath("(//a[@class='cmp-button c-button c-button--default highlight m-medium w-large only-pc'])[1]")).click();
        System.out.println("Done");
    }
}