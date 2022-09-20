package behavior;

import com.consol.citrus.TestActionRunner;
import com.consol.citrus.TestBehavior;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.message.builder.ObjectMappingPayloadBuilder;
import org.springframework.http.HttpStatus;
import pojo.User;

import static com.consol.citrus.http.actions.HttpActionBuilder.http;

public class UserSendBehavior implements TestBehavior {

    private TestContext context;
    public String path;

    public UserSendBehavior(TestContext context, String path) {
        this.context = context;
        this.path = path;
    }

    @Override
    public void apply(TestActionRunner testActionRunner) {
        testActionRunner.$(http()
                .client("restClient")
                .send()
                .get("users/get/")
                .path(path)
                .fork(true)
        );
    }
}
