package tests;

import behavior.MockServerCourseBehavior;
import behavior.MockServerScoreBehavior;
import behavior.MockServerUserBehavior;
import behavior.UserSendBehavior;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.message.builder.ObjectMappingPayloadBuilder;
import com.consol.citrus.testng.spring.TestNGCitrusSpringSupport;
import pojo.UserData;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;


import static com.consol.citrus.http.actions.HttpActionBuilder.http;

public class HttpTest extends TestNGCitrusSpringSupport {

    TestContext context;

    @Test(description = "Проверка метода /user/get/all получения всех юзеров")
    @CitrusTest
    public void getAllUsersTest() {

        this.context = citrus.getCitrusContext().createTestContext();
        $(applyBehavior(new UserSendBehavior(context, "all")));
        $(applyBehavior(new MockServerUserBehavior(context)));
        $(http()
                .client("restClient")
                .receive()
                .response(HttpStatus.OK)
                .message()
                .type("application/json")
                .body(new ObjectMappingPayloadBuilder(UserData.getUserJsonData(), "objectMapper"))
        );
    }

    @Test(description = "Проверка метода /user/get/{id} получения оценки")
    @CitrusTest
    public void getScoreUserTest() {

        this.context = citrus.getCitrusContext().createTestContext();
        $(applyBehavior(new UserSendBehavior(context, "1")));
        $(applyBehavior(new MockServerScoreBehavior(context)));
        $(http()
                .client("restClient")
                .receive()
                .response(HttpStatus.OK)
                .message()
                .type("application/json")
                .body(new ObjectMappingPayloadBuilder(UserData.getScoreJsonData(), "objectMapper"))
        );
    }

    @Test(description = "Проверка метода /user/get/{id} получения оценки")
    @CitrusTest
    public void getCourseUserTest() {

        this.context = citrus.getCitrusContext().createTestContext();
        $(applyBehavior(new UserSendBehavior(context, "1")));
        $(applyBehavior(new MockServerCourseBehavior(context)));
        $(http()
                .client("restClient")
                .receive()
                .response(HttpStatus.OK)
                .message()
                .type("application/json")
                .body(new ObjectMappingPayloadBuilder(UserData.getCourseJsonData(), "objectMapper"))
        );
    }
}
