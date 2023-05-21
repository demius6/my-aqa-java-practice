package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    //components

    private CalendarComponent calendarComponent = new CalendarComponent();

    // locators
    private SelenideElement headerTitle = $(".main-header");
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement genderInput = $("#genterWrapper");
    private SelenideElement resultsTable = $(".table-responsive");
    private SelenideElement phoneInput = $("#userNumber");
    private SelenideElement adressInput = $("#currentAddress");
    private SelenideElement SubjectInput = $("#subjectsInput");
    private SelenideElement hobbyInput = $("#hobbiesWrapper");
    private SelenideElement pictureInput = $("#uploadPicture");
    private SelenideElement stateLocator = $("#state");
    private SelenideElement stateChoose = $("#stateCity-wrapper");
    private SelenideElement cityLocator = $("#city");


    // actions

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));
        return this;
    }


    public RegistrationPage setFirstName(String firstName) {firstNameInput.setValue(firstName);
        return this;
    }
    public RegistrationPage setLastName(String lastName) {lastNameInput.setValue(lastName);
        return this;
    }
    public RegistrationPage setEmail(String email) {emailInput.setValue(email);
        return this;}
    public RegistrationPage setGender() {genderInput.$(byText("Male")).click();
        return this;}

    public RegistrationPage setPhoneNumber(String phoneNumber) {phoneInput.setValue(phoneNumber);
        return this;}
    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubjects(String subjects) {SubjectInput.setValue(subjects).pressEnter();
        return this;}
    public RegistrationPage setHobbies() {hobbyInput.$(byText("Sports")).click();
        return this;}
    public RegistrationPage uploadPicture() {pictureInput.uploadFromClasspath("kotik.jpg");
        return this;}
    public RegistrationPage setAdress(String adress) {adressInput.setValue(adress);
        return this;}
    public RegistrationPage chooseState() {
        stateLocator.scrollTo().click();
        stateChoose.$(byText("NCR")).click();
        return this;}
    public RegistrationPage chooseCity() {
        cityLocator.click();
        stateChoose.$(byText("Delhi")).click();
        $("#submit").click();
        return this;}

    public RegistrationPage checkResults(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }


}
