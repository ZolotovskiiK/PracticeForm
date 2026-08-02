package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class PracticeFormTests extends BaseTest {

    @BeforeEach
    void setUp() {
        open("/automation-practice-form");
    }

    @Test
    public void registrationTest() {
        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(genter)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        $("#subjectsContainer input").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("input[type='file']").uploadFromClasspath(photo);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(userName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(genter));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(day + " " + month + "," + year));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subject));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbies));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(photo));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state + " " + city));
    }

    @Test
    public void fillOnlyRequiredFieldsTest() {
        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(genter)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(userName + " " + lastName));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(genter));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
    }

    @Test
    public void checkFirstNameFieldValidationTest() {
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(genter)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $(".modal-dialog").shouldNot(appear);
    }

    @Test
    public void checkLastNameFieldValidationTest() {
        $("#firstName").setValue(userName);
        $("#genterWrapper").$(byText(genter)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $(".modal-dialog").shouldNot(appear);
    }

    @Test
    public void checkPhoneNumberFieldValidationTest() {
        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(genter)).click();
        $("#submit").click();

        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $(".modal-dialog").shouldNot(appear);
    }
}
