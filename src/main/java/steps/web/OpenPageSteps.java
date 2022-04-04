package steps.web;

import env.web.WebConfig;
import env.web.WebEnvContainer;
import io.qameta.allure.Step;

import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class OpenPageSteps extends WebEnvContainer {
    static final WebConfig data = ConfigFactory.create(WebConfig.class, System.getProperties());

    @Step("stepOpenPage")
    public void stepOpenPage(String path){
        step("Page opening " + data.getUrl()+path, () -> open(data.getUrl()+path));
    }

}
