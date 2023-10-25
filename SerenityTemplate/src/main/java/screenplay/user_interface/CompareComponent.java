package screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class CompareComponent {
    public static final Target listCategory = Target.the("TV_Audio_Video").locatedBy("//button[@id='desktop-gnb_1depth_1']");
    public static final Target subCategory = Target.the("QNED").locatedBy("//a[text()='QNED'][1]");
    public static final Target product = Target.the("Product").locatedBy("//li[@class=\"c-product-list__item productcollection__item\"][1]");
    public static  final Target productPricePLP = Target.the("Product_Price_PLP").locatedBy("//li[@class=\"c-product-list__item productcollection__item\"][1]//div[@class='c-price__purchase']");
    public static final Target getProductPricePDP = Target.the("Product_Price_PDP").locatedBy("//div[@class='price-area__PD0033 price-area']//div[@class='c-price__purchase'][1]");
}
