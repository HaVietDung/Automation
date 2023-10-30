package screenplay.user_interface;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//import static com.github.rjeschke.txtmark.HTMLElement.i;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class CompareComponent {
    public static final Target listCategory = Target.the("TV_Audio_Video").locatedBy("//button[@id='desktop-gnb_1depth_1']");
    public static final Target subCategory = Target.the("QNED").locatedBy("//a[text()='QNED'][1]");
//    public static  final Target productPricePLP = Target.the("Product_Price_PLP").locatedBy("//li[@class=\"c-product-list__item productcollection__item\"][1]//div[@class='c-price__purchase']");

    public static final Target productPricePDP = Target.the("Product_Price_PDP").locatedBy("//div[@class='price-area__PD0033 price-area']//div[@class='c-price__purchase'][1]");
    public static final Target attributeProduct = Target.the("Product_Attribute").locatedBy("//div[@data-sku='50QNED816RE.AEK.EEUK.UK.C'][1]");
}
