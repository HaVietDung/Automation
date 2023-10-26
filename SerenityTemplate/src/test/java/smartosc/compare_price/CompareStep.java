package smartosc.compare_price;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javassist.compiler.ast.Symbol;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Steps;
import screenplay.actions.ActionCommon;
import screenplay.tasks.Start;
import screenplay.user_interface.CompareComponent;

public class CompareStep {
    @Steps
    ActionCommon action;

    @When("Select Product")
    public void selectProduct(){
        action.clickElement(CompareComponent.listCategory);
        action.clickElement(CompareComponent.subCategory);;
        action.clickElement(CompareComponent.product);
        action.getAttribute(CompareComponent.attributeProduct, "data-sku");
    }

    @Then("Compare Price")
    public void checkPrice(){
        String pricePLP = action.getText(CompareComponent.productPricePLP);
        String pricePDP = action.getText(CompareComponent.productPricePDP);
        if(pricePLP.equals(pricePDP)){
            System.out.println("Price is correct");
        } else {
            System.out.println("Price is false");
        }
    }
}
