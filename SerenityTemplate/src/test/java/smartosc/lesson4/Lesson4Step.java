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
import screenplay.common.HandleFile;
import screenplay.page.SSOPage;
import screenplay.tasks.Start;
import screenplay.user_interface.CompareComponent;
import screenplay.user_interface.Lesson4;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Lesson4Step {
    @Steps
    ActionCommon action;
    HandleFile handleFile = new HandleFile();


    @When("Select Random Category")
    public void selectCategory() {
        List<WebElement> listCategory = ThucydidesWebDriverSupport.getDriver().findElements(By.xpath(Lesson4.listCategory));
        int size = listCategory.size();
        Random randomCategory = new Random();
//        int indexRandom = randomCategory.nextInt(size);
        int indexRandom = 3;
        Serenity.setSessionVariable("valueRandomCategory").to(indexRandom);

        if (indexRandom == 2 || indexRandom == 3 || indexRandom == 5) {
            WebElement category = ThucydidesWebDriverSupport.getDriver().findElement(By.xpath(Lesson4.listCategory + "[" + indexRandom + "]"));
            category.click();
            action.pause(5000);

        } else {
            System.out.println("value random = " + indexRandom);
        }

    }

    @And("Select Random SubCategory")
    public void selectSubCategory() {
        int valueRandomCategory = Serenity.sessionVariableCalled("valueRandomCategory");
//        get xpath subcategory
        List<WebElement> listSubcategory = ThucydidesWebDriverSupport.getDriver().findElements(By.xpath(Lesson4.listCategory + "[" + valueRandomCategory + "]" + Lesson4.listSubCategory));
        int size = listSubcategory.size();
        Random randomSubcategory = new Random();
//        int valueRandom = randomSubcategory.nextInt(size);
        int valueRandom = 1;

//        select randomsub category
        WebElement subCategory = listSubcategory.get(valueRandom);
        subCategory.click();
        System.out.println(subCategory);
        action.pause(5000);
    }

    @And("Get Info Product")
    public void getDataInPDP() throws IOException {

        List<WebElement> listPage = ThucydidesWebDriverSupport.getDriver().findElements(By.xpath(Lesson4.listPage));
        List<WebElement> listProduct = ThucydidesWebDriverSupport.getDriver().findElements(By.xpath(Lesson4.listProduct));
        int sizePage = listPage.size();
        int sizeProduct = listProduct.size();
        Serenity.setSessionVariable("sizeProduct").to(sizeProduct);
        System.out.println("size page: " + sizePage);
        System.out.println("size product: " + sizeProduct);
        if (sizePage == 0) {
            handleFile.createFile();
            for (int i = 1; i <= sizeProduct; i++) {
                try {
                    System.out.println("---------- Infomation Product " + i + " ----------");

                    WebElement elementData_s = ThucydidesWebDriverSupport.getDriver().findElement(By.xpath(Lesson4.listProduct + "[" + i + "]" + Lesson4.skuProduct));

                    String data_s = elementData_s.getAttribute("data-s");
                    Serenity.setSessionVariable("data-s").to(data_s);
                    System.out.println("data-s: " + data_s);

                    String nameProduct = elementData_s.getText();
                    Serenity.setSessionVariable("nameProduct").to(nameProduct);
                    System.out.println("name: " + nameProduct);

                    String linkProduct = elementData_s.getAttribute("href");
                    Serenity.setSessionVariable("linkProduct").to(linkProduct);
                    System.out.println("link: " + linkProduct);

                    WebElement elementPrice = ThucydidesWebDriverSupport.getDriver().findElement(By.xpath(Lesson4.listProduct + "[" + i + "]" + Lesson4.priceProduct));
                    String priceProduct = elementPrice.getText();
                    Serenity.setSessionVariable("priceProduct").to(priceProduct);
                    System.out.println("price: " + priceProduct);

                    handleFile.writeFile();

                } catch (Exception e) {
                    System.out.println(e);
                }
                handleFile.readFile();
            }
        } else {
            for (int i = 1; i < sizePage; i++) {
//                WebElement numPage = listPage.get(i);
//                numPage.click();
                for (int j = 1; j < sizeProduct; j++) {
                    try {
                        System.out.println("---------- Infomation Product " + j + " ----------");

                        //get attibute
                        WebElement elementData_s = ThucydidesWebDriverSupport.getDriver().findElement(By.xpath(Lesson4.listProduct + "[" + j + "]" + Lesson4.skuProduct));

                        String data_s = elementData_s.getAttribute("data-s");
                        Serenity.setSessionVariable("data-s").to(data_s);
                        System.out.println("data-s: " + data_s);

                        String nameProduct = elementData_s.getText();
                        Serenity.setSessionVariable("nameProduct").to(nameProduct);
                        System.out.println("name: " + nameProduct);

                        String linkProduct = elementData_s.getAttribute("href");
                        Serenity.setSessionVariable("linkProduct").to(linkProduct);
                        System.out.println("link: " + linkProduct);

                        WebElement elementPrice = ThucydidesWebDriverSupport.getDriver().findElement(By.xpath(Lesson4.listProduct + "[" + i + "]" + Lesson4.priceProduct));
                        String priceProduct = elementPrice.getText();
                        Serenity.setSessionVariable("priceProduct").to(priceProduct);
                        System.out.println("price: " + priceProduct);

                        handleFile.writeFile();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }
        System.out.println("Done");
    }
}
