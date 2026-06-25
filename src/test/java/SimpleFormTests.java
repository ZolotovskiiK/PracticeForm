import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void setUp() {
        open("https://demoqa.com/text-box");
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void registrationTest() {
        $("#userName").setValue("Petr Petrov");
        $("#userEmail").setValue("test@test.com");
        $("#currentAddress").setValue("Moscow");
        $("#permanentAddress").setValue("Novosibirsk");
        $("#submit").click();

        $("#name").shouldHave(text("Petr Petrov"));
        $("#email").shouldHave(text("test@test.com"));
        $("#output #currentAddress").shouldHave(text("Moscow"));
        $("#output #permanentAddress").shouldHave(text("Novosibirsk"));
    }

    @Test
    public void checkInvalidValueInEmailFieldTest() {
        $("#userName").setValue("Petr Petrov");
        $("#userEmail").setValue("1");
        $("#currentAddress").setValue("Moscow");
        $("#permanentAddress").setValue("Novosibirsk");
        $("#submit").click();

        $("#userEmail").shouldHave(cssClass("field-error"));

    }

}
