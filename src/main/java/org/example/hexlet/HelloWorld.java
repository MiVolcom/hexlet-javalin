
package org.example.hexlet;

import io.javalin.Javalin;
import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.validation.ValidationError;
import io.javalin.validation.ValidationException;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.dto.UsersPage;
import org.example.hexlet.model.BuildUserPage;
import org.example.hexlet.model.User;
import io.javalin.rendering.template.JavalinJte;
import repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class HelloWorld {
    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

//        app.get("/", ctx -> {
//            ctx.render("index.jte");
//        });
//
//        app.get("/users", UsersController::index);
//
//        app.get("/users/build", UsersController::build);
//
//        app.post("/users", UsersController::create);
//
//        app.get("/users/{id}/edit", UsersController::edit);
//
//        app.patch("/users/{id}", UsersController::update);
//
//        app.delete("/users/{id}", UsersController::destroy);
        app.get("/", ctx -> {
            var visited = Boolean.valueOf(ctx.cookie("visited"));
            var page = new MainPage(visited);
            ctx.render("mainPage.jte", model("page", page));
            ctx.cookie("visited", String.valueOf(true));
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
