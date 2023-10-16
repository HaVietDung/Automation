package screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class Start {

    public static Performable openBrowser(String url) {
        return Task.where("Open url " + url,
                Open.url(url)
        );
    }

}
