package helper;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebHelper {

    public static List<String> getTextElementsAndReverseList(ElementsCollection listElement){
        List<String> data = new ArrayList<>();

        for(SelenideElement element : listElement){
            data.add(element.getText());
        }
        Collections.reverse(data);
        return data;
    }

    public static List<String> getTextElements(ElementsCollection listElement){
        List<String> data = new ArrayList<>();

        for(SelenideElement element : listElement){
            data.add(element.getText());
        }
        return data;
    }

    public static List<String> getCorrectListFirstPage(List listFirstPage, List listLastPage){
        List<String> resultFirstPage = new ArrayList<>();
        int countLastPage = listLastPage.size();
        for(int i =0; i< countLastPage;i++){
            resultFirstPage.add(listFirstPage.get(i).toString());
        }

        return resultFirstPage;
    }

}
