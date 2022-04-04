package pageLocators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PlayersLocators {
    /** Locator for page /admin/login /**/
    public final static SelenideElement
            Table = $(By.xpath("//*[@id='payment-system-transaction-grid'][contains(@class,'grid-view')]")),
            TableLoading = $(By.xpath("//*[@id='payment-system-transaction-grid'][contains(@class,'grid-view-loading')]")),
            NameBtn = $(By.xpath("//*[@id='payment-system-transaction-grid_c3']/a")),
            NameAscBtn = $(By.xpath("//*[@id='payment-system-transaction-grid_c3']/a[contains(@class,'asc')]")),
            NameDescBtn = $(By.xpath("//*[@id='payment-system-transaction-grid_c3']/a[contains(@class,'desc')]"));

    /** Locator for players page? paginations /**/
    public final static SelenideElement
            PaginationLastBtn = $(By.xpath("//*[contains(@class, 'pagination')]//li[last()]/a")),
            PaginationFirstBtn = $(By.xpath("(//*[contains(@class, 'pagination')]//li/a)[1]"));

    /** Locator for players page? paginations /**/
    public final static ElementsCollection
            NameColumnElements = $$(By.xpath("//tbody//td[4]"));
}
