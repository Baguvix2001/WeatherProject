package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$x;

public class SignPage {
    private final SelenideElement createAccountButton = $x("//a [text() = 'Create an Account.']");

    public void createAccount() {
        createAccountButton.shouldBe(Condition.visible, Condition.interactable).click();
        Assert.assertEquals(WebDriverRunner.currentFrameUrl(), "https://home.openweathermap.org/users/sign_up");
    }
}
