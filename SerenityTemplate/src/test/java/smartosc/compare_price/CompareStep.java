package smartosc.compare_price;

import io.cucumber.java.en.And;
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

    @When("Compare Price PLP & PDP")
    public void selectProduct(){
        action.clickElement(CompareComponent.listCategory);

        action.clickElement(CompareComponent.subCategory);
        String pricePLP = action.getText(CompareComponent.productPricePLP);
        System.out.println(pricePLP);

        action.clickElement(CompareComponent.product);
        String pricePDP = action.getText(CompareComponent.productPricePDP);
        System.out.println("Price in PDP: "+pricePDP);

        String attribute = action.getAttribute(CompareComponent.attributeProduct, "data-sku");
        System.out.println("Attribute: "+ attribute);

        if(pricePLP.equals(pricePDP)){
            System.out.println("Price is correct");
        } else {
            System.out.println("Price is false");
        }
    }


}
