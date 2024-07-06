@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

<html>
    <head>
        <title>Хекслет</title>
    </head>
    <body>
        @if(page.getCourses().isEmpty())
            <p>No courses have been added yet</p>
        @else
            @for(var course : page.getCourses())
               <div>
                   <h2><a href="/courses/${course.getId()}">${course.getName()}</a></h2>
                   <p>${course.getDescription()}</p>
               </div>
            @endfor
        @endif
        <form action="/courses" method="get">
            <input type="search" name="term" value="${page.getTerm()}" />
            <input type="submit" value="Search" />
        </form>
    </body>
</html>