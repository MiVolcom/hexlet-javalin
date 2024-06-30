package org.example.hexlet;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import org.example.hexlet.model.Data;
import org.example.hexlet.model.User;
import org.example.hexlet.dto.UserPage;
import org.example.hexlet.dto.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

public final class HelloWorld {

    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();

            User user = USERS.stream()
                    .filter(u -> id.equals(u.getId()))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("User not found"));

            String userId = ctx.queryParam("userId");
            var page = new UserPage(user, userId);
            ctx.render("layout/show.jte", model("page", page));
        });

        app.get("/users", ctx -> {
            var page = new UsersPage(USERS);
            ctx.render("layout/index.jte", model("page", page));

        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
