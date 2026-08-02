package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class SimpleFormTests extends BaseTest {

    @BeforeEach
    void setUp() {
        open("/text-box");
    }

    @Test
    public void registrationTest() {
        $("#userName").setValue(userName + " " + lastName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(state + " " + city);
        $("#submit").click();

        $("#name").shouldHave(text(userName + " " + lastName));
        $("#email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(state + " " + city));
    }

    @Test
    public void checkInvalidValueInEmailFieldTest() {
        $("#userName").setValue(userName + " " + lastName);
        $("#userEmail").setValue(invalidUserEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(state + " " + city);
        $("#submit").click();

        $("#userEmail").shouldHave(cssClass("field-error"));

    }

}
