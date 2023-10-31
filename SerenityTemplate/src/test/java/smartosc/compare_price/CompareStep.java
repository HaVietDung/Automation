package smartosc.compare_price;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javassist.compiler.ast.Symbol;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screenplay.actions.ActionCommon;
import screenplay.tasks.Start;
import screenplay.user_interface.CompareComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.isDriverInstantiated;

public class CompareStep {
    @Steps
    ActionCommon action;

    @When("Select Category TV_Audio_Video")
    public void selectCategory() {
        action.clickElement(CompareComponent.listCategory);
    }

    @And("Select SubCategory QNED")
    public void SelectSbuCategory() {
        action.clickElement(CompareComponent.subCategory);
    }

    @And("Select Random Product and Get Price")
    public void getListInfo(){
//        get list product
        List<WebElement> listProduct = ThucydidesWebDriverSupport.getDriver().findElements(By.xpath("//li[@class='c-product-list__item productcollection__item']//div[@class='c-product-item__ufn']//a"));

//        get random product
        int size = listProduct.size();
        Random randomListProduct = new Random();
        int randomValue = randomListProduct.nextInt(size);
        if (randomValue > 0){
            WebElement product = ThucydidesWebDriverSupport.getDriver().findElement(By.xpath("(//li[@class='c-product-list__item productcollection__item'])"+"["+randomValue+"]"));

//        get price in PDP
            System.out.println("Element product: "+product);
            try {
                WebElement elementPricePLP = ThucydidesWebDriverSupport.getDriver().findElement(By.xpath("(//li[@class='c-product-list__item productcollection__item'])"+"["+randomValue+"]"+"//div[@class='c-price__purchase']"));
                String pricePLP = elementPricePLP.getText().replaceAll("[^0-9\\.]", "");
                Serenity.setSessionVariable("pricePLP").to(pricePLP);
                System.out.println("price in PLP: "+pricePLP);
            } catch (Exception e) {
                System.out.println(e);
            }

//        select random product
            try {

                WebElement elementPricePDP = ThucydidesWebDriverSupport.getDriver().findElement(By.xpath("(//li[@class='c-product-list__item productcollection__item'])"+"["+randomValue+"]"+"//div[@class='c-product-item__ufn']//a"));
                action.pause(5000);
                elementPricePDP.click();
                action.pause(3000);
            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            System.out.println("randomValue = "+ randomValue);
        }
    }

    @And("Product Detail and Get Price")
    public void getPricePDP(){
        try{
            WebElement elementPrcePDP = ThucydidesWebDriverSupport.getDriver().findElement(By.xpath("(//div[@class='c-price__purchase'])[1]"));
            String pricePDP = elementPrcePDP.getText().replaceAll("[^0-9\\.]", "");
            Serenity.setSessionVariable("pricePDP").to(pricePDP);
            System.out.println("Price in PDP: "+pricePDP);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Then ("Compare Price")
    public void comparePrice(){
        if(Serenity.sessionVariableCalled("pricePLP")
                .equals(Serenity.sessionVariableCalled("pricePDP"))){
            System.out.println("Price is correct");
        } else {
            System.out.println("Price is false");
        }
    }
}
