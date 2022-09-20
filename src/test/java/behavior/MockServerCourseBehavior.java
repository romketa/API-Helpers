package behavior;

import com.consol.citrus.TestActionRunner;
import com.consol.citrus.TestBehavior;
import com.consol.citrus.context.TestContext;

import static com.consol.citrus.http.actions.HttpActionBuilder.http;

public class MockServerCourseBehavior implements TestBehavior {
    private TestContext context;

    public MockServerCourseBehavior(TestContext context) {
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
                        "\"name\":\"Java QA\",\n" +
                        "\"price\": 10000\n" +
                        "},\n" +
                        "{\n" +
                        "\"name\":\"Java\",\n" +
                        "\"price\": 12000\n" +
                        "}\n" +
                        "]")
        );

    }
}
