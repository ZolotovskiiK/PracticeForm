package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    private final SelenideElement
            modalWindow = $(".modal-dialog"),
            title = $("#example-modal-sizes-title-lg"),
            table = $(".table-responsive");

    public void verifyModalAppears() {
        modalWindow.should(appear);
        title.shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String key, String value) {
        table.$(byText(key)).parent()
                .shouldHave(text(value));
    }
}
