package test;

import org.junit.jupiter.api.Test;

import static testdata.TestData.*;

public class SimpleFormTests extends BaseTest {

    @Test
    public void registrationTest() {
        simpleFormPage
                .openSimpleFormPage()
                .setUserName(firstName + " " + lastName)
                .setUserEmail(email)
                .setCurrentAddress(address)
                .setPermanentAddress(state + " " + city)
                .clickSubmitButton()
                .checkField("name", firstName + " " + lastName)
                .checkField("email", email)
                .checkField("currentAddress", address)
                .checkField("permanentAddress", state + " " + city);
    }

    @Test
    public void checkInvalidValueInEmailFieldTest() {
        simpleFormPage
                .openSimpleFormPage()
                .setUserName(firstName + " " + lastName)
                .setUserEmail(invalidUserEmail)
                .setCurrentAddress(address)
                .setPermanentAddress(state + " " + city)
                .clickSubmitButton()
                .checkEmailFieldAlert();
    }
}
