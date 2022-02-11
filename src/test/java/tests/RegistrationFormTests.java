package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Oleg";
    String lastName = "Gazmanov";
    String userEmail = "gazmanov@oleg.ru";
    String userNumber = "8005553535";
    String subjectsInput1 = "English";
    String subjectsInput2 = "Maths";
    String subjectsInput3 = "History";
    String hobbie1 = "Sports";
    String hobbie2 = "Reading";
    String hobbie3 = "Music";
    String images = "1.png";
    String currentAddress = "Test adress";
    String state = "Haryana";
    String city = "Karnal";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTests() {
        open("/automation-practice-form");

        registrationPage.setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .setUserEmailInput(userEmail)
                .setGenderInput()
                .setMobileUserNumberInput(userNumber)
                .setDateOfBirthInput("22", "July", "1951")
                .setSubjectsInput(subjectsInput1, subjectsInput2, subjectsInput3)
                .hobbies(hobbie1, hobbie2, hobbie3)
                .setUploadPicturesInput(images)
                .setCurrentAddressInput(currentAddress)
                .setStateInput(state)
                .setCityInput(city)
                .setSubmitButtonClick();

        /* Проверка формы */

        registrationPage.checkForm("Student Name", "Oleg Gazmanov")
                .checkForm("Student Email", "gazmanov@oleg.ru")
                .checkForm("Gender", "Male")
                .checkForm("Mobile", "8005553535")
                .checkForm("Date of Birth", "22 July,1951")
                .checkForm("Subjects", "English" + ", " + "Maths" + ", " + "History")
                .checkForm("Hobbies", "Sports" + ", " + "Reading" + ", " + "Music")
                .checkForm("Picture", "1.png")
                .checkForm("Address", "Test adress")
                .checkForm("State and City", "Haryana" + " " + "Karnal");
    }
}
