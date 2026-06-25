import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void setUp() {
        open("https://demoqa.com/automation-practice-form");
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void registrationTest() {
        $("#firstName").setValue("Петр");
        $("#lastName").setValue("Петров");
        $("#userEmail").setValue("user@user.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--0" + 25 + ":not(.react-datepicker__day--outside-month)").click();
        $("#subjectsContainer input").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("input[type='file']").uploadFromClasspath("files/photo.jpg");
        $("#currentAddress").setValue("Novosibirsk");
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Петр Петров"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("user@user.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("25 October,1990"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("photo.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Novosibirsk"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Rajasthan Jaipur"));
    }

    @Test
    public void fillOnlyRequiredFieldsTest() {
        $("#firstName").setValue("Петр");
        $("#lastName").setValue("Петров");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Петр Петров"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
    }

    @Test
    public void checkFirstNameFieldValidationTest() {
        $("#lastName").setValue("Петров");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#submit").click();

        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $(".modal-dialog").shouldNot(appear);
    }

    @Test
    public void checkLastNameFieldValidationTest() {
        $("#firstName").setValue("Петр");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#submit").click();

        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $(".modal-dialog").shouldNot(appear);
    }

    @Test
    public void checkPhoneNumberFieldValidationTest() {
        $("#firstName").setValue("Петр");
        $("#lastName").setValue("Петров");
        $("#genterWrapper").$(byText("Male")).click();
        $("#submit").click();

        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $(".modal-dialog").shouldNot(appear);
    }
}
