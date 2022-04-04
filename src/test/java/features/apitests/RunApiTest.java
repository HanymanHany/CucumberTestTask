package features.apitests;
import env.api.ApiEnvContainer;
import io.cucumber.java.Before;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static constants.data.TokenType.BASIC;

@Suite
@IncludeEngines("api")
@SelectClasspathResource("src/test/java/features/apitests/")
public class RunApiTest extends ApiEnvContainer {
    @Before
    public void suiteSetUp() {
        System.out.println("here ApiEnvContainer");

        url = apiConfig.getUrl();
        BasicToken = BASIC.type() + EncodingBase64(apiConfig.getBasicAuth());

    }
}
