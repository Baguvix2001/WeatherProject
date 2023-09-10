package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class CreateAccountPage {
    private final SelenideElement usernameInput = $x("//input [@class = 'form-control string required']");
    private final SelenideElement emailInput = $x("//input [@class = 'form-control string email optional']");
    private final SelenideElement passwordInput = $x("(//input [@class = 'form-control margin-bottom-xs'])[1]");
    private final SelenideElement repeatPasswordInput = $x("(//input [@class = 'form-control margin-bottom-xs'])[2]");
    private final SelenideElement confirmAgeCheckBox = $x("//input [@class = 'checkbox-right-indent chk-age-confirm']");
    private final SelenideElement privacyPolicyCheckBox = $x("//input [@class = 'checkbox-right-indent chk-accept']");
    private final SelenideElement captchaCheckbox = $x("//div [@class = 'recaptcha-checkbox-border' ]");
    private final SelenideElement captchaCheckboxStatus = $x("//div [@class = 'rc-anchor-aria-status' ]");
    private final SelenideElement captchaFrame = $x("//iframe [@title = 'reCAPTCHA']");
    private final SelenideElement createAccountSubmit = $x("//input [@class = 'btn btn-color btn-submit']");

    public void fillUsernameField(String name) {
        usernameInput
          .shouldBe(Condition.interactable, Condition.editable)
          .setValue(name);
        Assert.assertEquals(name, usernameInput.getAttribute("value"));
    }

    public void fillEmailField(String email) {
        emailInput.shouldBe(Condition.interactable, Condition.editable)
          .setValue(email);
        Assert.assertEquals(email, emailInput.getAttribute("value"));
    }

    public void fillPasswordFields(String password) {
        passwordInput
          .shouldBe(Condition.interactable, Condition.editable)
          .setValue(password).shouldBe(Condition.editable);
        Assert.assertEquals(password, passwordInput.getAttribute("value"));
        repeatPasswordInput
          .shouldBe(Condition.interactable, Condition.editable)
          .setValue(password).shouldBe(Condition.editable);
        Assert.assertEquals(repeatPasswordInput.getAttribute("value"), passwordInput.getAttribute("value"));
    }

    public void markConfirmAgeCheckBox() {
        confirmAgeCheckBox.shouldBe(Condition.visible).click();
        confirmAgeCheckBox.shouldBe(Condition.checked);
    }

    public void markPrivacyPolicyCheckBox() {
        privacyPolicyCheckBox.shouldBe(Condition.visible).click();
        privacyPolicyCheckBox.shouldBe(Condition.checked);
    }

    public void markCaptchaCheckBox() {
        webdriver().driver().switchTo().frame(captchaFrame);
        captchaCheckbox.shouldBe(Condition.visible).click();
        sleep(2500);
        Assert.assertEquals(captchaCheckboxStatus.getAttribute("innerHTML"), "Вы прошли проверку");
        webdriver().driver().switchTo().defaultContent();
    }

    public void submitForm() {
        createAccountSubmit.shouldBe(Condition.visible, Condition.interactable).click();
    }
}

