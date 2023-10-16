package smartosc.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.IOException;

public class Setup {

    @ParameterType(".*")
    public Actor actor(String actor) {
        return OnStage.theActorCalled(actor);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

//    @After
//    public void runSerenityAggregate() {
//        String os = System.getProperty("os.name");
//        if (!os.startsWith("Windows")) {
//            return;
//        }
//        try {
//            Runtime.getRuntime().exec("cmd.exe /c mvn serenity:aggregate");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
