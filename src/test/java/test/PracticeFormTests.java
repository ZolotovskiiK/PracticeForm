package test;

import org.junit.jupiter.api.Test;

import static testdata.TestData.*;

public class PracticeFormTests extends BaseTest {

    @Test
    public void registrationTest() {
        practiceFormPage
                .openPracticeFormPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(genter)
                .setMobileNumber(mobileNumber)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setPicture(photo)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmitButton()
                .verifyModal()
                .verifyModalResults("Student Name", firstName + " " + lastName)
                .verifyModalResults("Student Email", email)
                .verifyModalResults("Gender", genter)
                .verifyModalResults("Mobile", mobileNumber)
                .verifyModalResults("Date of Birth", day + " " + month + "," + year)
                .verifyModalResults("Subjects", subject)
                .verifyModalResults("Hobbies", hobbies)
                .verifyModalResults("Picture", photo)
                .verifyModalResults("Address", address)
                .verifyModalResults("State and City", state + " " + city);
    }

    @Test
    public void fillOnlyRequiredFieldsTest() {
        practiceFormPage
                .openPracticeFormPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(genter)
                .setMobileNumber(mobileNumber)
                .clickSubmitButton()
                .verifyModal()
                .verifyModalResults("Student Name", firstName + " " + lastName)
                .verifyModalResults("Gender", genter)
                .verifyModalResults("Mobile", mobileNumber);
    }

    @Test
    public void checkFirstNameFieldValidationTest() {
        practiceFormPage
                .openPracticeFormPage()
                .setLastName(lastName)
                .setGender(genter)
                .setMobileNumber(mobileNumber)
                .clickSubmitButton()
                .checkFirstNameFieldAlert();
    }

    @Test
    public void checkLastNameFieldValidationTest() {
        practiceFormPage
                .openPracticeFormPage()
                .setFirstName(firstName)
                .setGender(genter)
                .setMobileNumber(mobileNumber)
                .clickSubmitButton()
                .checkLastNameFieldAlert();
    }

    @Test
    public void checkPhoneNumberFieldValidationTest() {
        practiceFormPage
                .openPracticeFormPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(genter)
                .clickSubmitButton()
                .checkMobileNumberFieldAlert();
    }
}
