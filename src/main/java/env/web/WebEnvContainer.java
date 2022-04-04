package env.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helper.AttachmentsHelper.attachScreenshot;

/** Main class for initialization browser, set configurations, kill browser **/

public class WebEnvContainer {

    public static final WebDriverConfig browser = ConfigFactory.create(WebDriverConfig.class, System.getProperties());


    // function for get configurations local(browser) or remote(selenoid)
    public static void getConfiguration(String runType) throws MalformedURLException {

        switch (runType){
            case("local"):
                Configuration.browser = browser.getWebBrowser();
                Configuration.browserSize = browser.getBrowserSize();
                Configuration.timeout = browser.getBrowserTimeout();
                Configuration.headless = browser.getHeadlessMode();
                break;
        }

    }
}
