package tests;


import behavior.MockServerCourseBehavior;
import behavior.MockServerScoreBehavior;
import behavior.MockServerUserBehavior;
import behavior.UserSendBehavior;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.message.builder.ObjectMappingPayloadBuilder;
import com.consol.citrus.testng.spring.TestNGCitrusSpringSupport;
import org.testng.annotations.BeforeTest;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;
import pojo.UserData;


import static com.consol.citrus.http.actions.HttpActionBuilder.http;
import static com.consol.citrus.validation.json.JsonMessageValidationContext.Builder.json;

public class HttpTest extends TestNGCitrusSpringSupport {

    private TestContext context;

    @BeforeTest
    public void setUp(){
        this.context = citrus.getCitrusContext().createTestContext();
    }


    @Test(description = "Проверка метода /user/get/all получения всех юзеров")
    @CitrusTest
    public void getAllUsersTest() {

        $(applyBehavior(new UserSendBehavior(context, "/user/get/all")));
        $(applyBehavior(new MockServerUserBehavior(context)));
        $(http()
                .client("restClient")
                .receive()
                .response(HttpStatus.OK)
                .message()
                .type("application/json")
                .body(new ObjectMappingPayloadBuilder(UserData.userData(), "objectMapper"))
                .validate(json()
                        .schemaValidation(true)
                        .schema("userSchema"))
        );
    }

    @Test(description = "Проверка метода /user/get/{id} получения оценки")
    @CitrusTest
    public void getScoreUserTest() {

        int UserId = UserData.userData().get(0).getId();
        $(applyBehavior(new UserSendBehavior(context, "/user/get/" + UserId)));
        $(applyBehavior(new MockServerScoreBehavior(context)));
        $(http()
                .client("restClient")
                .receive()
                .response(HttpStatus.OK)
                .message()
                .type("application/json")
                .body(new ObjectMappingPayloadBuilder(UserData.scoreData(), "objectMapper"))
                .validate(json()
                        .schemaValidation(true)
                        .schema("scoreSchema"))
        );
    }

    @Test(description = "Проверка метода /course/get/all получения оценки")
    @CitrusTest
    public void getCourseUserTest() {

        $(applyBehavior(new UserSendBehavior(context, "/course/get/all")));
        $(applyBehavior(new MockServerCourseBehavior(context)));
        $(http()
                .client("restClient")
                .receive()
                .response(HttpStatus.OK)
                .message()
                .type("application/json")
                .body(new ObjectMappingPayloadBuilder(UserData.courseData(), "objectMapper"))
                .validate(json()
                    .schemaValidation(true)
                    .schema("courseSchema"))
        );
    }
}
