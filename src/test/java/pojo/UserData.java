package pojo;

import com.consol.citrus.context.TestContext;
import com.consol.citrus.message.builder.ObjectMappingPayloadBuilder;
import com.consol.citrus.testng.spring.TestNGCitrusSpringSupport;
import org.springframework.http.HttpStatus;
import pojo.Course;
import pojo.Score;
import pojo.User;

import java.util.List;

public class UserData {

    public static User getUserJsonData() {
        return User.builder()
                .name("Ivanov Ivan")
                .course("Java QA")
                .email("Ivan_Ivanov@gmail.com")
                .age(23)
                .build();
    }

    public static Score getScoreJsonData() {
        return Score.builder()
                .name("Ivanov Ivan")
                .score(78)
                .build();
    }

    public static List<Course> getCourseJsonData() {
        return List.of(
                Course.builder().name("Java QA").price(10000).build(),
                Course.builder().name("Java").price(12000).build()
        );
    }
}
