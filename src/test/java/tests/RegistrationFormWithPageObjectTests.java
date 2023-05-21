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
    String firstname = "Alex";
    String lastname = "DemiuS";
    String email = "alex@alex.com";
    String phonenumber = "1111111111";


    @BeforeAll
    static void beforeAAll() {
        Configuration.baseUrl ="https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void successFillWithPOTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        new RegistrationPage().setFirstName(firstname);
        new RegistrationPage().setLastName(lastname);
        new RegistrationPage().setEmail(email);
        $("#genterWrapper").$(byText("Male")).click();
        new RegistrationPage().setPhoneNumber(phonenumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1999");
        $("[aria-label$='Tuesday, March 2nd, 1999']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("kotik.jpg");
        $("#currentAddress").setValue("Some address 1");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        new RegistrationPage().checkResults("Student Name","Alex DemiuS");
        new RegistrationPage().checkResults("Student Email","alex@alex.com");
        new RegistrationPage().checkResults("Gender","Male");

    }
}
