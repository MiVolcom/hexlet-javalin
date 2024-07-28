
package org.example.hexlet;

import io.javalin.Javalin;
import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.validation.ValidationError;
import io.javalin.validation.ValidationException;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.dto.UsersPage;
import org.example.hexlet.model.BuildUserPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import io.javalin.rendering.template.JavalinJte;
import repository.CourseRepository;
import repository.UserRepository;
import org.example.hexlet.dto.courses.CoursesPage;

import java.util.ArrayList;
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
//        app.get("/", ctx -> {
//            var visited = Boolean.valueOf(ctx.cookie("visited"));
//            var page = new MainPage(visited);
//            ctx.render("mainPage.jte", model("page", page));
//            ctx.cookie("visited", String.valueOf(true));
//        });
        // Отображение формы логина
        app.get("/sessions/build", SessionsController::build);
// Процесс логина
        app.post("/sessions", SessionsController::create);
// Процесс выхода из аккаунта
        app.delete("/sessions", SessionsController::destroy);

        app.get("/", ctx -> {
            var visited = Boolean.valueOf(ctx.cookie("visited"));
            var page = new MainPage(visited, ctx.sessionAttribute("currentUser"));
            ctx.render("mainPage.jte", model("page", page));
            ctx.cookie("visited", String.valueOf(true));
        });

        app.get(NamedRoutes.buildCoursePath(), ctx -> {
            ctx.render("courses/build.jte");
        });

        app.post(NamedRoutes.coursesPath(), ctx -> {
            var name = ctx.formParam("name");
            var description = ctx.formParam("description");
            var course = new Course(name, description);
            CourseRepository.save(course);
            ctx.sessionAttribute("flash", "Course has been created");
            ctx.redirect(NamedRoutes.coursesPath());
        });
        app.get(NamedRoutes.coursesPath(), ctx -> {
            var term = ctx.queryParam("term");
            // ctx.sessionAttribute("key", "value");
            List<Course> courses;
            if (term != null) {
                // Фильтруем курсы в соответствии со значением term
                courses = CourseRepository.search(term);
            } else {
                courses = CourseRepository.getEntities();
            }
            var page = new CoursesPage(courses, term);
            page.setFlash(ctx.consumeSessionAttribute("flash"));

            ctx.render("courses/index.jte", model("page", page));
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
