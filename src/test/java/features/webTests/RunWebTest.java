package features.webTests;
import env.web.WebEnvContainer;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helper.AttachmentsHelper.attachScreenshot;

@Suite
@IncludeEngines("web")
@SelectClasspathResource("src/test/java/features/webTests/")
public class RunWebTest extends WebEnvContainer {

    @Before
    public static void setup() throws MalformedURLException {
        getConfiguration(browser.getRunType());



    }

    @After
    public void tearDown(){

        attachScreenshot("Last screenshot");
        closeWebDriver();
    }


}
