package screenplay.user_interface;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

public class Lesson4 {
    public static final Target listCategory1 = Target.the("NameCategory").locatedBy("//button[@id='desktop-gnb_1depth_1']");
    public static final Target subCategory1 = Target.the("NameSubCategory").locatedBy("//a[text()='QNED'][1]");

}
