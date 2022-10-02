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

    public static List<User> userData() {
        return List.of(
                User.builder().id(1).name("Ivanov Ivan").course("Java QA").email("Ivan_Ivanov@gmail.com").age(23).build(),
                User.builder().id(2).name("Petrov Petr").course("Python QA").email("Petr_Petrov@gmail.com").age(26).build()
        );
    }

    public static Score scoreData() {
        return Score.builder()
                .name("Ivanov Ivan")
                .score(78)
                .build();
    }

    public static List<Course> courseData() {
        return List.of(
                Course.builder().name("Java QA").price(10000).build(),
                Course.builder().name("Java").price(12000).build()
        );
    }
}
