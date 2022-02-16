package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();


    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            currentAddress = faker.address().fullAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            email = faker.internet().emailAddress(),
            images = "1.png",
            state = "NCR",
            city = "Noida",
            subjectsInput1 = "Maths",
            subjectsInput2 = "Arts",
            subjectsInput3 = "Civics",
            hobbie1 = "Sports",
            hobbie2 = "Reading",
            hobbie3 = "Music",
            gender = "Other";


    @Test
    void successFillTests() {
        open("/automation-practice-form");

        registrationPage.setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .setUserEmailInput(email)
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

        registrationPage.checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", email)
                .checkForm("Gender", gender)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", "22 July,1951")
                .checkForm("Subjects", subjectsInput1 + ", " + subjectsInput2 + ", " + subjectsInput3)
                .checkForm("Hobbies", hobbie1 + ", " + hobbie2 + ", " + hobbie3)
                .checkForm("Picture", images)
                .checkForm("Address", currentAddress)
                .checkForm("State and City", state + " " + city);
    }
}
