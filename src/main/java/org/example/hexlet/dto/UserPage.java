package org.example.hexlet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.hexlet.model.User;

@AllArgsConstructor
@Getter
@NoArgsConstructor

public class UserPage {
    private User user;
}
