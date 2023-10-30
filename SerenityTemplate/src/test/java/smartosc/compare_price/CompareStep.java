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
//    @And("Select Random Product and Get Price")
//    public void selectRandomProduct(){
//        String pricePLP = action.getText(CompareComponent.productPricePLP);
//        System.out.println(pricePLP);
//        Serenity.setSessionVariable("pricePLP").to(pricePLP);
//    }

    @And("Select Random Product and Get Price")
    public void getListInfo(){
        List<WebElement> listProduct = ThucydidesWebDriverSupport.getDriver().findElements(By.xpath("//li[@class='c-product-list__item productcollection__item']//div[@class='c-product-item__head']"));
        int size = listProduct.size();
        System.out.println(size);
        Random randomListProduct = new Random();
        int randomValue = randomListProduct.nextInt(size);
        WebElement product = listProduct.get(randomValue);
        System.out.println("product >>> "+product);
        product.click();
        action.pause(5000);
    }
    @And("Product Detail and Get Price")
    public void getPricePDP(){
//        action.clickElement(CompareComponent.product);
        String pricePDP = action.getText(CompareComponent.productPricePDP);
        System.out.println("Price in PDP: "+pricePDP);
        Serenity.setSessionVariable("pricePDP").to(pricePDP);

        String attribute = action.getAttribute(CompareComponent.attributeProduct, "data-sku");
        System.out.println("Attribute: "+ attribute);
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

