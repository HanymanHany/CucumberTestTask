package steps.web;

import env.web.WebEnvContainer;
import pageLocators.PlayersLocators;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static helper.WebHelper.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayersSteps extends WebEnvContainer {
    List<String> elementsLastPage = new ArrayList<>();
    List<String> elementsFirstPage = new ArrayList<>();
    PlayersLocators playersPage;

    public void checkLoadingTablePlayers(){
        stepCheckNotExistTableLoading();
    }

    public void getFirstElementsPlayers()  {

        stepClickSortColumnName();
        stepCheckClassAsc();
        stepClickPaginationLastPage();
        stepCheckNotExistTableLoading();
        stepGetElementsLastPage();
        stepClickPaginationFirstPage();
        stepCheckNotExistTableLoading();
        stepClickSortAscColumnName();
        stepCheckClassDesc();
        stepGetElementsFirstPage();

    }

    public void checkSorting(){
        stepCheckCorrectSorting();
    }

    // Common Steps
    private void stepCheckNotExistTableLoading(){
        step("Checking the successful loading of the Players table", () -> { playersPage.TableLoading.shouldNot(exist); });
    }

    // Sorting Steps
    private void stepClickSortColumnName(){
        step("Click on the Name header of the Players table sorting", () -> { playersPage.NameBtn.click();   });
    }
    private void stepCheckClassAsc(){
        step("Check sort class - Asc", () -> {  playersPage.NameAscBtn.shouldBe(exist); });
    }
    private void stepClickSortAscColumnName(){
        step("Click on the Name header of the Players table for Desc sorting", () -> { playersPage.NameAscBtn.click(); });
    }
    private void stepCheckClassDesc(){
        step("Check sort class - Desc", () -> {  playersPage.NameDescBtn.shouldBe(exist); });
    }

    // Work in data table Steps
    private void stepGetElementsLastPage(){
        step("Get all elements of the Name column of the last page", () -> {
            elementsLastPage = getTextElementsAndReverseList(playersPage.NameColumnElements);
        });
    }
    private void stepGetElementsFirstPage(){
        step("Get all elements of the Name column of the first page", () -> {
            elementsFirstPage = getTextElements(playersPage.NameColumnElements);
        });
    }

    private void stepCheckCorrectSorting(){
        step("We check whether the received arrays match, the correctness of sorting", () -> {
            getCorrectListFirstPage(elementsFirstPage,elementsLastPage);
            assertEquals(elementsLastPage, getCorrectListFirstPage(elementsFirstPage,elementsLastPage), "The first and last page elements of the Name column must match.");
        });
    }

    // Pagination Steps
    private void stepClickPaginationLastPage(){
         step("Click on the pagination button last page", () -> { playersPage.PaginationLastBtn.click(); });
    }
    private void stepClickPaginationFirstPage(){
         step("Click on the pagination button first page", () -> { playersPage.PaginationFirstBtn.click(); });
    }

}
