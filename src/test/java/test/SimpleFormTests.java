package test;

import org.junit.jupiter.api.Test;

public class SimpleFormTests extends BaseTest {

    @Test
    public void registrationTest() {
        simpleFormPage
                .openSimpleFormPage()
                .setUserName(data.firstName + " " + data.lastName)
                .setUserEmail(data.email)
                .setCurrentAddress(data.address)
                .setPermanentAddress(data.state + " " + data.city)
                .clickSubmitButton()
                .checkField("name", data.firstName + " " + data.lastName)
                .checkField("email", data.email)
                .checkField("currentAddress", data.address)
                .checkField("permanentAddress", data.state + " " + data.city);
    }

    @Test
    public void checkInvalidValueInEmailFieldTest() {
        simpleFormPage
                .openSimpleFormPage()
                .setUserName(data.firstName + " " + data.lastName)
                .setUserEmail(data.invalidUserEmail)
                .setCurrentAddress(data.address)
                .setPermanentAddress(data.state + " " + data.city)
                .clickSubmitButton()
                .checkEmailFieldAlert();
    }
}
