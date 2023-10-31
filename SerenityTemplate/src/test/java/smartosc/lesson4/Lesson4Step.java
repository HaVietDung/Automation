package smartosc.lesson4;

import com.paulhammant.ngwebdriver.ByAngular;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import screenplay.actions.ActionCommon;
import screenplay.page.SSOPage;
import screenplay.tasks.Start;
import screenplay.user_interface.CompareComponent;
import screenplay.user_interface.Lesson4;

import java.lang.reflect.Array;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Lesson4Step {
    @Steps
    ActionCommon action;


    @When("Select Random Category")
    public void selectCategory() {
        List<WebElement> listCategory = ThucydidesWebDriverSupport.getDriver().findElements(By.xpath("(//div[@class='navigation c-gnb c-gnb__desktop']//li[@class='cmp-navigation__item cmp-navigation__item--level-0 c-gnb__item c-gnb__item--depth1'])"));
        int size = listCategory.size();
        Random randomCategory = new Random();
//        int valueRandom = randomCategory.nextInt(size);
        int valueRandom = 2;
        Serenity.setSessionVariable("valueRandomCategory").to(valueRandom);
        String xpathCategory = "(//div[@class='navigation c-gnb c-gnb__desktop']//li[@class='cmp-navigation__item cmp-navigation__item--level-0 c-gnb__item c-gnb__item--depth1'])";
        Serenity.setSessionVariable("xpathCategory").to(xpathCategory);
        if (valueRandom > 0) {
            WebElement category = ThucydidesWebDriverSupport.getDriver().findElement(By.xpath("(//div[@class='navigation c-gnb c-gnb__desktop']//li[@class='cmp-navigation__item cmp-navigation__item--level-0 c-gnb__item c-gnb__item--depth1'])" + "[" + valueRandom + "]"));
            category.click();
            action.pause(5000);

        } else {
            System.out.println("value random = "+valueRandom);
        }

    }
    @And("Select Random SubCategory")
    public void selectSubCategory(){

//        call variable
        int valueRandomCategory = Serenity.sessionVariableCalled("valueRandomCategory");
        String xpathCategory = Serenity.sessionVariableCalled("xpathCategory");

//        get xpath subcategory
        List<WebElement> listSubcategory = ThucydidesWebDriverSupport.getDriver().findElements(By.xpath(xpathCategory + "[" + valueRandomCategory + "]" + "//li[@class='cmp-navigation__item cmp-navigation__item--level-3 c-gnb__item c-gnb__item--detail']"));
        int size = listSubcategory.size();
        Random randomSubcategory = new Random();
//        int valueRandom = randomSubcategory.nextInt(size);
        int valueRandom = 2;
//        select randomsub category
        WebElement subCategory = listSubcategory.get(valueRandom);
        subCategory.click();
        System.out.println(subCategory);
        action.pause(5000);
    }

    @And("Get Data In PDP")
    public void getDataInPDP(){

        List<WebElement> listPage = ThucydidesWebDriverSupport.getDriver().findElements(By.xpath("//li[@class='c-page__item']"));
        List<WebElement> listProduct = ThucydidesWebDriverSupport.getDriver().findElements(By.xpath("//li[@class='c-product-list__item productcollection__item']"));
        int sizePage = listPage.size();
        int sizeProduct = listProduct.size();
        System.out.println("size pase: "+sizePage);
        System.out.println("size product: "+sizeProduct);
        for (int i=1; i < sizePage; i++){
            for (int j=1; j < sizeProduct; j++){
                WebElement data_s = ThucydidesWebDriverSupport.getDriver().findElement(By.xpath("//li[@class='c-product-list__item productcollection__item']"+"[" + j + "]" + "//div[@class='c-product-item__ufn']//a"));
                String atrtibute = data_s.getAttribute("data-s");
                System.out.println("list attribute: " + atrtibute);
            }
            WebElement numPage = listPage.get(i);
            numPage.click();
        }
    }
}
