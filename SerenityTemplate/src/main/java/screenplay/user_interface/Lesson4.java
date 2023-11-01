package screenplay.user_interface;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

public class Lesson4 {
    public static String listCategory = "(//div[@class='navigation c-gnb c-gnb__desktop']//li[@class='cmp-navigation__item cmp-navigation__item--level-0 c-gnb__item c-gnb__item--depth1'])";
    public static String listSubCategory = "//li[@class='cmp-navigation__item cmp-navigation__item--level-3 c-gnb__item c-gnb__item--detail']";
    public static String listPage = "//li[@class='c-page__item']";
    public static String listProduct = "//li[@class='c-product-list__item productcollection__item']";
    public static String skuProduct = "//div[@class='c-product-item__ufn']//a";
    public static String priceProduct = "//div[@class='c-price__purchase']";

}