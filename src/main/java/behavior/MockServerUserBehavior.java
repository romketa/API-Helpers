package behavior;

import com.consol.citrus.TestActionRunner;
import com.consol.citrus.TestBehavior;
import com.consol.citrus.context.TestContext;

import static com.consol.citrus.http.actions.HttpActionBuilder.http;

public class MockServerUserBehavior implements TestBehavior {

    private TestContext context;

    public MockServerUserBehavior(TestContext context) {
        this.context = context;
    }

    @Override
    public void apply(TestActionRunner testActionRunner) {
        testActionRunner.$(http()
                .server("restServer")
                .receive()
                .get()
        );

        testActionRunner.$(http()
                .server("restServer")
                .send()
                .response()
                .message()
                .type("application/json").body("[\n" +
                        "{\n" +
                        "\"id\":1,\n" +
                        "\"name\":\"Ivanov Ivan\",\n" +
                        "\"course\":\"Java QA\",\n" +
                        "\"email\":\"Ivan_Ivanov@gmail.com\",\n" +
                        "\"age\": 23\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\":2,\n" +
                        "\"name\":\"Petrov Petr\",\n" +
                        "\"course\":\"Python QA\",\n" +
                        "\"email\":\"Petr_Petrov@gmail.com\",\n" +
                        "\"age\": 26\n" +
                        "}\n" +
                        "]")
        );

    }
}
