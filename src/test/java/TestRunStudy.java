import api.WeatherApiTest;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.MainPage;
import pages.ModalWindow;
import pages.SignPage;

import static constants.Constants.Values.CITY_WITH_MANY_RESULTS_LIST;
import static constants.Constants.Values.CITY_WITH_ONE_RESULT_LIST;
import static constants.Constants.ValuesForCreatingAccount.*;

public class TestRunStudy extends BaseTest {
    MainPage mainPage = new MainPage();
    WeatherApiTest weatherApiTest = new WeatherApiTest();

    SignPage signPage = new SignPage();

    CreateAccountPage createAccountPage = new CreateAccountPage();

    ModalWindow modalWindow = new ModalWindow();

    @Test
    public void searchCity() {
        mainPage.searchInput(CITY_WITH_ONE_RESULT_LIST);
        mainPage.clickOnSearchButton();
        mainPage.searchResultsCheck(CITY_WITH_ONE_RESULT_LIST);
        mainPage.countResults();
        mainPage.cityNameOnUi();

    }
//    @Test
//    public void searchCityWithManyResults() {
//        mainPage.searchInput(CITY_WITH_MANY_RESULTS_LIST);
//        mainPage.clickOnSearchButton();
//        mainPage.searchResultsCheck(CITY_WITH_MANY_RESULTS_LIST);
//        mainPage.countResults();
//    }
//
//    @Test
//    public void compareUiAndApiCity() {
//        mainPage.searchInput(CITY_WITH_MANY_RESULTS_LIST);
//        mainPage.clickOnSearchButton();
//        Assert.assertArrayEquals(weatherApiTest.cityNamesApi(CITY_WITH_MANY_RESULTS_LIST).toArray(), mainPage.cityNameOnUi().toArray());
//    }
//
//    @Test
//    public void checkApiWeather() {
//        System.out.println("Резултат в градусах цельсия " + weatherApiTest.weatherResultsApi(CITY_WITH_MANY_RESULTS_LIST));
//    }
//
//    @Test
//    public void checkUiWeather() {
//        mainPage.searchInput(CITY_WITH_MANY_RESULTS_LIST);
//        mainPage.clickOnSearchButton();
//        System.out.println(mainPage.weatherOnUi());
//    }
//
//    @Test
//    public void compareUiAndApiWeather() {
//        mainPage.searchInput(CITY_WITH_MANY_RESULTS_LIST);
//        mainPage.clickOnSearchButton();
//        Assert.assertArrayEquals(weatherApiTest.weatherResultsApi(CITY_WITH_MANY_RESULTS_LIST).toArray(), mainPage.weatherOnUi().toArray());
//    }

//    @Test
//    public void createAccount() {
//        mainPage.clickOnSingIn();
//        signPage.createAccount();
//        createAccountPage.fillUsernameField(NAME_OF_USER);
//        createAccountPage.fillEmailField(EMAIL_OF_USER);
//        createAccountPage.fillPasswordFields(PASSWORD);
//        createAccountPage.markConfirmAgeCheckBox();
//        createAccountPage.markPrivacyPolicyCheckBox();
//        createAccountPage.markCaptchaCheckBox();
//        createAccountPage.submitForm();
//        modalWindow.checkModalHeaderText();
//    }
}


