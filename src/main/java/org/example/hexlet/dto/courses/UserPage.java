package org.example.hexlet.dto.courses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.model.User;

@AllArgsConstructor
@Getter
public class UserPage {
    private User user;
}
