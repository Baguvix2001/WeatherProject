import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static constants.Constants.Credentials.BASE_URL;


abstract public class BaseTest {
    private final SelenideElement acceptCookiesButton = $x("//button [@class = 'stick-footer-panel__link']");

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1600x900";
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;
    }

    public void openPageAndAcceptCookies() {
        Selenide.open(BASE_URL);
        sleep(2000);
        acceptCookiesButton
          .shouldBe(Condition.visible, Condition.interactable)
          .click();
    }

    @BeforeTest
    public void init() {
        setUp();
        openPageAndAcceptCookies();
    }

    @AfterTest
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}

