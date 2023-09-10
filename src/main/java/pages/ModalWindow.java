package pages;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$x;

public class ModalWindow {
    private final SelenideElement modalHeader = $x("//h4 [@class = 'modal-title']");

    public void checkModalHeaderText () {
        Assert.assertEquals(modalHeader.getText(),"How and where will you use our API?");
    }
}
