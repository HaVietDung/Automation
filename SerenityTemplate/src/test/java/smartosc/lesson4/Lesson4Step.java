package smartosc.lesson4;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Steps;
import screenplay.actions.ActionCommon;
import screenplay.tasks.Start;
import screenplay.user_interface.Lesson4;

public class Lesson4Step {
    @Steps
    ActionCommon action;

    @When("Select Random Category")
    public void selectCategory() {
        action.clickElement(Lesson4.listCategory1);
    }
    @And("Select Random SubCategory")
    public void selectSubCategory(){
        action.clickElement(Lesson4.subCategory1);
    }
}
