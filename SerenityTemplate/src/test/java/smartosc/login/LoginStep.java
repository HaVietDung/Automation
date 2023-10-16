package smartosc.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Steps;
import screenplay.actions.ActionCommon;
import screenplay.page.SSOPage;
import screenplay.tasks.Start;
import screenplay.user_interface.SSOLoginComponent;

public class LoginStep {

    @Steps
    ActionCommon action;

    @Given("{actor} open url {word}")
    public void openUrl(Actor actor, String url) {
        actor.wasAbleTo(Start.openBrowser(url));
    }

    @When("SSO - Input email = {word}, pass = {word} and sign in")
    public void inputEmailAndPass(String email, String pass) {
        action.checkElementDisplayed(SSOLoginComponent.SIGN_IN_FORM);
        action.typeText(SSOLoginComponent.INPUT_EMAIL, email);
        action.typeText(SSOLoginComponent.INPUT_PASSWORD, pass);
        action.clickElement(SSOLoginComponent.BUTTON_SIGNIN);
        ActionCommon.pause(10000);
    }

    @Then("SSO - Check login success and my lg page display")
    public void clickSignInAndCheckLoginSuccess() {
        action.checkElementDisplayed(SSOLoginComponent.HOME_PAGE);
        action.checkElementNotDisplayed(SSOLoginComponent.BUTTON_SIGNIN);
        action.checkElementDisplayed(SSOLoginComponent.MY_PROFILE_INFO.of("namebox"));
        String numberCouponMyLG = action.getText(SSOLoginComponent.MY_PROFILE_INFO.of("coupon__number"));
        System.out.println("numberCouponMyLG: " + numberCouponMyLG);
    }

    @And("SSO - Get auth token")
    public void getAuthToken() {
        String authToken = SSOPage.getAuthToken();
        System.out.println("AUTH_TOKEN = " + authToken);
    }

}
