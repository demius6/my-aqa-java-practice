package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithPageObjectTests {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstname = "Alex";
    String lastname = "DemiuS";
    String email = "alex@alex.com";
    String phonenumber = "1111111111";
    String day = "30"; String month = "March"; String year = "1999";
    String subject = "Math";
    String adress  = "Some adress 1";
    String gender  = "Male";


    @BeforeAll
    static void beforeAAll() {
        Configuration.baseUrl ="https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void successFillWithPOTest() {

        registrationPage
                .openPage()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setEmail(email)
                .setGender()
                .setPhoneNumber(phonenumber)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies()
                .uploadPicture()
                .setAdress(adress)
                .chooseState()
                .chooseCity()
                .checkResults("Student Name",firstname + " " + lastname)
                .checkResults("Student Email", email)
                .checkResults("Gender",gender);

    }
}


