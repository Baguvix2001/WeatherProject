package pages;

import com.codeborne.selenide.*;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static constants.Constants.Xpath.BASE_SEARCH_DROPDOWN_XPATH;


public class MainPage {
    private final SelenideElement searchInput = $x("//div [@class = 'search-container']/input");
    private final SelenideElement searchButton = $x("//button [text() = 'Search']");
    private final ElementsCollection searchResults = $$x(BASE_SEARCH_DROPDOWN_XPATH);
    private final ElementsCollection resultDropdownByCityName = $$x(BASE_SEARCH_DROPDOWN_XPATH + "/span[1]");
    private final ElementsCollection resultDropdownWeatherValue = $$x(BASE_SEARCH_DROPDOWN_XPATH + "/span[2]");
    private final SelenideElement singInButton = $x("//a [text() = 'Sign in']");


    public void searchInput(String city) {
        searchInput
                .shouldBe(Condition.visible, Condition.interactable)
                .sendKeys(city);

    }

    public void clickOnSearchButton() {
        searchButton
                .shouldBe(Condition.visible, Condition.interactable)
                .click();
    }

    public void countResults() {
        int resultsList = searchResults.size();
        Assert.assertTrue(resultsList > 0);
        System.out.println("Count of results: " + searchResults.size());
    }

    public void searchResultsCheck(String cityName) {
        resultDropdownByCityName
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
        List<String> resultsNameList = new ArrayList<>();
        resultDropdownByCityName.asFixedIterable().forEach(x -> resultsNameList.add(x.getText()));
//        resultDropdownByCityName.forEach(x -> resultsNameList.add(x.getText()));
        for (String i : resultsNameList) {
            Assert.assertTrue(i.startsWith(cityName));
        }
        List<String> weatherValueList = new ArrayList<>();
        resultDropdownWeatherValue.asFixedIterable().forEach(x -> weatherValueList.add(x.getText()));
//        resultDropdownWeatherValue.forEach(x -> weatherValueList.add(x.getText()));
        for (String i : weatherValueList) {
            Assert.assertFalse(i.isEmpty());
        }
    }

    public List<String> cityNameOnUi() {
        List<String> cityOnUiList = new ArrayList<>();
        sleep(2000);
        resultDropdownByCityName.asFixedIterable().forEach(x -> cityOnUiList.add(x.getText()));
//        resultDropdownByCityName.forEach(x -> cityOnUiList.add(x.getText()));
        List<String> modifiedCities = new ArrayList<>();
        for (String x : cityOnUiList) {
            String[] parts = x.split(",");
            if (parts.length > 0) {
                modifiedCities.add(parts[0].trim());
            }
        }
        return modifiedCities;
    }

    public List<Integer> weatherOnUi() {
        List<String> weatherValueList = new ArrayList<>();
        sleep(2000);
        resultDropdownWeatherValue.asFixedIterable().forEach(x -> weatherValueList.add(x.getText()));
//        resultDropdownWeatherValue.forEach(x -> weatherValueList.add(x.getText()));
        List<Integer> modifiedValues = new ArrayList<>();
        for (String x : weatherValueList) {
            String numericText = x.replaceAll("[^0-9]", "");
            Integer integerValue = Integer.parseInt(numericText);
            modifiedValues.add(integerValue);
        }
        return modifiedValues;
    }

    public void clickOnSingIn () {
        singInButton.shouldBe(Condition.visible, Condition.interactable).click();
        Assert.assertTrue(WebDriverRunner.currentFrameUrl().contains("https://home.openweathermap.org/users/sign_in"));
    }
}

