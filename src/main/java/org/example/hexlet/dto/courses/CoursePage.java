package org.example.hexlet.dto.courses;

import org.example.hexlet.model.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class CoursePage {
    private List<Course> courses;
    private String header;
}
