package pageLocators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class LoginLocators {
    /** Locator for page /admin/login /**/
    public final static SelenideElement
            SignInPage = $(".signin-body"),
            LoginField = $(By.id("UserLogin_username")),
            PasswordField = $(By.id("UserLogin_password")),
            SigInBtn = $(byAttribute("type", "submit")),
            ConfirmBtn = $(byAttribute("data-test", "confirmation"));

    /** Locator for main page /**/
    public final static SelenideElement
            AdminPanel = $(By.id("header"));
}
