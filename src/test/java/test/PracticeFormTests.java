package test;

import org.junit.jupiter.api.Test;

public class PracticeFormTests extends BaseTest {

    @Test
    public void registrationTest() {
        practiceFormPage
                .openPracticeFormPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setMobileNumber(data.mobileNumber)
                .setBirthDate(data.birthDate[0], data.birthDate[1], data.birthDate[2])
                .setSubject(data.subject)
                .setHobbies(data.hobbies)
                .setPicture(data.photo)
                .setAddress(data.address)
                .setState(data.state)
                .setCity(data.city)
                .clickSubmitButton()
                .verifyModal()
                .verifyModalResults("Student Name", data.firstName + " " + data.lastName)
                .verifyModalResults("Student Email", data.email)
                .verifyModalResults("Gender", data.gender)
                .verifyModalResults("Mobile", data.mobileNumber)
                .verifyModalResults("Date of Birth", data.birthDate[0] + " " + data.birthDate[1] + "," + data.birthDate[2])
                .verifyModalResults("Subjects", data.subject)
                .verifyModalResults("Hobbies", data.hobbies)
                .verifyModalResults("Picture", data.photo)
                .verifyModalResults("Address", data.address)
                .verifyModalResults("State and City", data.state + " " + data.city);
    }

    @Test
    public void fillOnlyRequiredFieldsTest() {
        practiceFormPage
                .openPracticeFormPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setMobileNumber(data.mobileNumber)
                .clickSubmitButton()
                .verifyModal()
                .verifyModalResults("Student Name", data.firstName + " " + data.lastName)
                .verifyModalResults("Gender", data.gender)
                .verifyModalResults("Mobile", data.mobileNumber);
    }

    @Test
    public void checkFirstNameFieldValidationTest() {
        practiceFormPage
                .openPracticeFormPage()
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setMobileNumber(data.mobileNumber)
                .clickSubmitButton()
                .checkFirstNameFieldAlert();
    }

    @Test
    public void checkLastNameFieldValidationTest() {
        practiceFormPage
                .openPracticeFormPage()
                .setFirstName(data.firstName)
                .setGender(data.gender)
                .setMobileNumber(data.mobileNumber)
                .clickSubmitButton()
                .checkLastNameFieldAlert();
    }

    @Test
    public void checkPhoneNumberFieldValidationTest() {
        practiceFormPage
                .openPracticeFormPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .clickSubmitButton()
                .checkMobileNumberFieldAlert();
    }
}
