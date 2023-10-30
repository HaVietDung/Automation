package smartosc.lesson4;

import com.paulhammant.ngwebdriver.ByAngular;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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
        List<WebElement> listCategory = ThucydidesWebDriverSupport.getDriver().findElements(By.xpath("//div[@class='c-gnb__container']//li[@class='cmp-navigation__item cmp-navigation__item--level-0 c-gnb__item c-gnb__item--depth1']"));
        int size = listCategory.size()/2 - 1;
        Random randomCategory = new Random();
        int valueRandom = randomCategory.nextInt(size);
        WebElement category = listCategory.get(valueRandom);
        category.click();
    }
    @And("Select Random SubCategory")
    public void selectSubCategory(){
        List<WebElement> listSubcategory = ThucydidesWebDriverSupport.getDriver().findElements(By.xpath("//li[@class='cmp-navigation__item cmp-navigation__item--level-3 c-gnb__item c-gnb__item--detail']"));
        int size = listSubcategory.size()/2;
        Random randomSubcategory = new Random();
        int valueRandom = randomSubcategory.nextInt(size/4);
        WebElement subCategory = listSubcategory.get(valueRandom);
        subCategory.click();
    }
}
