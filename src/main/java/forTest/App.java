package forTest;

import io.javalin.Javalin;
import java.util.List;

public class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        List<String> phones = Data.getPhones();
        List<String> domains = Data.getDomains();
        app.get("/phones", a -> a.json(phones));
        app.get("/domains", b -> b.json(domains));
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
