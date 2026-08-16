package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleFormPage {

    private final SelenideElement
            title = $(".text-center"),
            userNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputResults = $("#output");

    public SimpleFormPage openSimpleFormPage() {
        open("/text-box");
        title.shouldHave(text("Text Box"));
        return this;
    }

    public SimpleFormPage setUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public SimpleFormPage setUserEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public SimpleFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public SimpleFormPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public SimpleFormPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public SimpleFormPage checkField(String key, String value) {
        outputResults.$(byId(key)).shouldHave(text(value));
        return this;
    }

    public void checkEmailFieldAlert() {
        emailInput.shouldHave(cssClass("field-error"));
    }
}
