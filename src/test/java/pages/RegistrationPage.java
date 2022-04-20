package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    //components
    private CalendarComponent calendarComponent = new CalendarComponent();
    private UploadComponent uploadComponent = new UploadComponent();
    private LineFillComponent lineFillComponent = new LineFillComponent();
    private ClickComponent clickComponent = new ClickComponent();
    private SubjectsComponent subjectsComponent = new SubjectsComponent();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();
    private CheckFormComponent checkFormComponent = new CheckFormComponent();


    //locators

    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");

    String firstNameLocator = "#firstName";
    String lastNameLocator = "#lastName";
    String userEmailLocator = "#userEmail";
    String genderLocator = ".custom-control-label";
    String mobileLocator = "#userNumber";
    String subjectLocator = "#subjectsInput";
    String addressLocator = "#currentAddress";
    String stateLocator = "#state";
    String cityLocator = "#city";
    String submitLocator = "#submit";
    String resultTableLocator = ".table-responsive";

    @Step("Открываем тестируемую страницу")
    public RegistrationPage setFirstNameInput(String firstName) {
        //firstNameInput.setValue(firstName);
        lineFillComponent.lineFill(firstNameLocator, firstName);
        return this;
    }

    @Step("Вводим имя студента")
    public RegistrationPage setLastNameInput(String lastName) {
        lineFillComponent.lineFill(lastNameLocator, lastName);
        return this;
    }

    @Step("Вводим электронную почту студента")
    public RegistrationPage setUserEmailInput(String userEmail) {
        lineFillComponent.lineFill(userEmailLocator, userEmail);
        return this;
    }

    @Step("Вводим мобильный телефон студента")
    public RegistrationPage setMobileUserNumberInput(String userNumber) {
        lineFillComponent.lineFill(mobileLocator, userNumber);
        return this;
    }

    @Step("Выбираем пол студента")
    public RegistrationPage setGenderInput() {
        clickComponent.clickMethod(genderLocator);
        return this;
    }

    @Step("Выбираем дату рождения студента")
    public RegistrationPage setDateOfBirthInput(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Выбираем изучаемый предмет")
    public RegistrationPage setSubjectsInput(String value1, String value2, String value3) {
        subjectsComponent.subjectComponent(subjectLocator, value1);
        subjectsComponent.subjectComponent(subjectLocator, value2);
        subjectsComponent.subjectComponent(subjectLocator, value3);
        return this;
    }

    @Step("Выбираем хобби студента")
    public RegistrationPage hobbies(String value1, String value2, String value3) {
        $(byText(value1)).click();
        $(byText(value2)).click();
        $(byText(value3)).click();
        return this;
    }

    @Step("Загружаем фотографию студента")
    public RegistrationPage setUploadPicturesInput(String picture) {
        uploadComponent.uploadComponent(picture);
        return this;
    }

    @Step("Указываем текущий адрес проживания студента")
    public RegistrationPage setCurrentAddressInput(String currentAddress) {
        lineFillComponent.lineFill(addressLocator, currentAddress);
        return this;
    }

    @Step("Указывает штат студента")
    public RegistrationPage setStateInput(String state) {
        stateAndCityComponent.stateAndCityComponent(stateLocator, state);
        return this;
    }

    @Step("Указываем город студента")
    public RegistrationPage setCityInput(String city) {
        stateAndCityComponent.stateAndCityComponent(cityLocator, city);
        return this;
    }

    @Step("Нажимаем кнопку \"Submit\"")
    public RegistrationPage setSubmitButtonClick() {
        clickComponent.clickMethod(submitLocator);
        return this;
    }

    @Step("Проверяем правильность заполненных данных")
    public RegistrationPage checkForm(String fieldName, String value) {
        checkFormComponent.checkFormMethod(resultTableLocator, fieldName, value);
        return this;
    }

}
