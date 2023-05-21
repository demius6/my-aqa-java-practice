package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    // locators
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement resultsTable = $(".table-responsive");
    private SelenideElement phoneInput = $("#userNumber");



    // actions
    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }
    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }
    public void setEmail(String email) {emailInput.setValue(email);}
    public void setPhoneNumber(String phoneNumber) {phoneInput.setValue(phoneNumber);}
    public void checkResults(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
    }


}
