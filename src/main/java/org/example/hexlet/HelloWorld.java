package org.example.hexlet;
import io.javalin.Javalin;

public class HelloWorld {
    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/users/{id}/post/{postId}", ctx -> {
            String usersId = ctx.pathParam("id");
            String postId = ctx.pathParam("postId");
            ctx.result("UsersId" + usersId + "postId" + postId);
        });
        return app;
    }
    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
