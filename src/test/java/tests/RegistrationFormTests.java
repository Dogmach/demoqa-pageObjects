package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests extends TestBase{
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


    @Test
    @Owner("Dogmach")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Подключаем Jenkins с Allure report")
    @DisplayName("Результат заполнения формы соответствует введенным значениям в форме")

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
