package org.example.hexlet;

import io.javalin.Javalin;
import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.validation.ValidationError;
import io.javalin.validation.ValidationException;
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

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get(NamedRoutes.usersPath(), ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        app.get(NamedRoutes.buildUsersPath(), ctx -> {
            var page = new BuildUserPage();
            ctx.render("users/build.jte", model("page", page));
        });

        app.post(NamedRoutes.usersPath(), ctx -> {
            var firstName = ctx.formParam("firstName");
            var lastName = ctx.formParam("lastName");
            var email = ctx.formParam("email").trim().toLowerCase();


            try {
                var passwordConfirmation = ctx.formParam("passwordConfirmation");
                var password = ctx.formParamAsClass("password", String.class)
                        .check(value -> value.equals(passwordConfirmation), "The passwords don't match")
                        .check(value -> value.length() > 6, "The password is not long enough")
                        .get();
                var user = new User(firstName, lastName, email, password);
                UserRepository.save(user);
                ctx.redirect("/users");
            } catch (ValidationException e) {
                var page = new BuildUserPage(firstName, lastName, email, e.getErrors());
                ctx.render("users/build.jte", model("page", page));
            }
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
