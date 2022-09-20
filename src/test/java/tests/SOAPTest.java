package tests;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.testng.TestNGCitrusSupport;
import com.dataaccess.webservicesserver.NumberToDollars;
import com.dataaccess.webservicesserver.NumberToDollarsResponse;
import features.CustomMarshaller;
import org.testng.annotations.Test;

import static com.consol.citrus.ws.actions.SoapActionBuilder.soap;
import static pojo.NumbersData.getNumberToDollarsRequest;
import static pojo.NumbersData.getNumberToDollarsResponse;

public class SOAPTest extends TestNGCitrusSupport {

    public TestContext context;

    @Test(description = "Получение информации о пользователе", enabled=true)
    @CitrusTest(name = "soap")
    public void checkGettingInformationAboutUser() {
        this.context = citrus.getCitrusContext().createTestContext();

        CustomMarshaller<Class<NumberToDollars>> ptxRq = new CustomMarshaller<>();
        CustomMarshaller<Class<NumberToDollarsResponse>> ptxRs = new CustomMarshaller<>();

        $(soap()
                .client("soapClient")
                .send()
                .message()
                .body(ptxRq.convert(NumberToDollars.class, getNumberToDollarsRequest(),
                        "http://www.dataaccess.com/webservicesserver/", "NumberToDollars")));

        $(soap()
                .client("soapClient")
                .receive()
                .message()
                .body(ptxRs.convert(NumberToDollarsResponse.class, getNumberToDollarsResponse(),
                        "http://www.dataaccess.com/webservicesserver/", "NumberToDollarsResponse")));
    }


}
