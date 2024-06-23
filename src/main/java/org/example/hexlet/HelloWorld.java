package org.example.hexlet;
import io.javalin.Javalin;

public class HelloWorld {
    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/hello", ctx -> {
            String name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            String greeting = "Hello, " + name + "!";
            ctx.result(greeting);
        });
        return app;
    }
    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
