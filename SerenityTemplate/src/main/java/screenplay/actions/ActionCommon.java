package screenplay.actions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.ResolvableElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ActionCommon {

    public void clickElement(Target targetLocators) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(targetLocators, isVisible()),
                Click.on(targetLocators));
    }

    public void typeText(Target targetLocators, String value) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(targetLocators, isVisible()),
                Enter.theValue(value).into(targetLocators));
    }

    public void waitVisible(Target targetLocators) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(targetLocators, isVisible()));
    }

    public void waitNotVisible(Target targetLocators) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(targetLocators, isNotVisible()));
    }

    public void checkElementDisplayed(Target targetLocators) {
        waitVisible(targetLocators);
        theActorInTheSpotlight().attemptsTo(Ensure.that(targetLocators).isDisplayed());
    }

    public void checkElementNotDisplayed(Target targetLocators) {
        waitNotVisible(targetLocators);
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(targetLocators).isNotDisplayed());
    }

    public void scrollElement(Target targetLocators) {
        theActorInTheSpotlight().attemptsTo(
                Scroll.to(targetLocators));
    }

    public void scrollElementIntoMiddle(Target targetLocators) {
        WebElement element = getDriver().findElement(By.xpath(targetLocators.getCssOrXPathSelector()));
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) getDriver()).executeScript(scrollElementIntoMiddle, element);
        pause(1000);
        System.out.println("Done scrollElementIntoMiddle: " + targetLocators.getName());
    }

    public static void pause(int time) {
        try {
            if (time > 1000) {
                for (int i = 0; i < time / 1000; i++) {
                    System.out.println("Sleep " + (i + 1) + "s");
                    Thread.sleep(1000);
                }
            } else {
                Thread.sleep(time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getText(Target targetLocators) {
        waitVisible(targetLocators);
        scrollElementIntoMiddle(targetLocators);
        theActorInTheSpotlight().attemptsTo(Ensure.that(targetLocators).isDisplayed());
        String text = theActorInTheSpotlight().asksFor(Text.of(targetLocators));
        Serenity.recordReportData().withTitle("Text of " + targetLocators.getName()).andContents(text);
        return text;
    }
    public String getAttribute (Target targetLocators, String attributeName) {
        String valueAttribute = theActorInTheSpotlight().asksFor(Attribute.of(targetLocators).named(attributeName));
        return valueAttribute;
    }

}
