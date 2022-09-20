package behavior;

import com.consol.citrus.TestActionRunner;
import com.consol.citrus.TestBehavior;
import com.consol.citrus.context.TestContext;

import static com.consol.citrus.http.actions.HttpActionBuilder.http;

public class MockServerScoreBehavior implements TestBehavior {
    private TestContext context;

    public MockServerScoreBehavior(TestContext context) {
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
                .type("application/json").body("{\n" +
                        "\"name\":\"Ivanov Ivan\",\n" +
                        "\"score\": 78\n" +
                        "}")
        );

    }
}
