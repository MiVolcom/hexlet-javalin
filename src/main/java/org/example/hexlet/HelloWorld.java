package org.example.hexlet;

import io.javalin.Javalin;
import static io.javalin.rendering.template.TemplateUtil.model;
import org.example.hexlet.dto.UsersPage;
import org.example.hexlet.model.User;
import io.javalin.rendering.template.JavalinJte;
import repository.UserRepository;

import java.util.List;

public final class HelloWorld {
    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        app.post("/users", ctx -> {
            var firstName = ctx.formParam("firstName");
            var lastName = ctx.formParam("lastName");
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");
            var encryptedPassword = password;

            var user = new User(firstName, lastName, email, encryptedPassword);
            UserRepository.save(user);
            ctx.redirect("/users");
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
