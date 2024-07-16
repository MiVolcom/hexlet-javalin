package org.example.hexlet.model;

import io.javalin.validation.ValidationError;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuildUserPage {
    private String firstName;
    private String lastName;
    private String email;
    private Map<String, List<ValidationError<Object>>> errors;
}
