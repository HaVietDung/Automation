package screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class Lesson4 {
    public static final Target listCategory1 = Target.the("NameCategory").locatedBy("//button[@id='desktop-gnb_1depth_1']");
    public static final Target subCategory1 = Target.the("NameSubCategory").locatedBy("//a[text()='QNED'][1]");

}
