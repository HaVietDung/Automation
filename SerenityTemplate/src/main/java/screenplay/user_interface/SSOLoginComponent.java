package screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class SSOLoginComponent {

    public static final Target SIGN_IN_FORM = Target.the("Sign in form").locatedBy("//*[@id='signinForm']");
    public static final Target INPUT_EMAIL = Target.the("Input email").locatedBy("//input[@id='email']");
    public static final Target INPUT_PASSWORD = Target.the("Input password").locatedBy("//input[@id='password']");
    public static final Target BUTTON_SIGNIN = Target.the("Button SignIn").locatedBy("//button[@id='button_user-login']");
    public static final Target HOME_PAGE = Target.the("Home Page").locatedBy("//*[contains(@class,'after-login')]");
    public static final Target MY_PROFILE_INFO = Target.the("My profile {0} display")
            .locatedBy("//*[contains(@class,'my-profile__{0}') or contains(@class,'my-profile-{0}')]");

}
