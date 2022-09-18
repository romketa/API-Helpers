import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.message.builder.ObjectMappingPayloadBuilder;
import com.consol.citrus.testng.TestNGCitrusSupport;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;
import pojo.User;

import static com.consol.citrus.http.actions.HttpActionBuilder.http;

public class FirstRestTest extends TestNGCitrusSupport {

    private TestContext context;

    @Test(description = "Test mock")
    @CitrusTest
    public void firstMockTest() {

        this.context = citrus.getCitrusContext().createTestContext();

        $(http()
                .client("restClient")
                .send()
                .get("users/get/all")
                .fork(true)
        );

        $(http()
                .server("restServer")
                .receive()
                .get()
        );

        $(http()
                .server("restServer")
                .send()
                .response()
                .message()
                .type("application/json").body("{\n" +
                        "\"name\":\"Ivanov Ivan\",\n" +
                        "\"course\":\"Java QA\",\n" +
                        "\"email\":\"Ivan_Ivanov@gmail.com\",\n" +
                        "\"age\": 23\n" +
                        "}")
        );

        $(http()
                .client("restClient")
                .receive()
                .response(HttpStatus.OK)
                .message()
                .type("application/json")
                .body(new ObjectMappingPayloadBuilder(getJsonData(), "objectMapper"))
        );
    }

    public User getJsonData() {
        return User.builder()
                .name("Ivanov Ivan")
                .course("Java QA")
                .email("Ivan_Ivanov@gmail.com")
                .age(23)
                .build();
    }

}
