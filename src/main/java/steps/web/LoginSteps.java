package steps.web;

import constants.pages.PathUrl;
import env.web.WebConfig;
import env.web.WebEnvContainer;
import org.aeonbits.owner.ConfigFactory;
import pageLocators.LoginLocators;

import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;

public class LoginSteps extends WebEnvContainer {
    LoginLocators authPage;
    OpenPageSteps openPageSteps = new OpenPageSteps();
    static final WebConfig data = ConfigFactory.create(WebConfig.class, System.getProperties());


    public void openPageAndLogin(String login, String password){
        openPageSteps.stepOpenPage(PathUrl.login.getPath());
        loginUser(login, password);
    }

    public void loginUser(String login, String password) {
        stepCheckOpenPage();
        stepInputLoginField(login);
        stepInputPasswordField(password);
        stepClickLSignUpBtn();
    }

    // Common Steps
    private void stepCheckOpenPage(){
        step("Checking the display of the page with authorization", () -> { authPage.SignInPage.shouldBe(visible); });
    }

    private void stepInputLoginField(String value){
        step("Filling in the field - Login", () -> { authPage.LoginField.setValue(value); });
    }
    private void stepInputPasswordField(String value){
        step("Filling in the field - Password", () -> { authPage.PasswordField.setValue(value); });
    }
    private void stepClickLSignUpBtn(){
        step("Clicking on a button - Sign In", () -> { authPage.SigInBtn.click(); });;
    }

    public void stepCheckAdminPanel(){
        step("Checking the display of the admin panel", () -> { authPage.AdminPanel.shouldBe(visible);});;
    }


}
