package demoqa.com.tests;
import java.time.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

        final String firstName = "Jora",
                lastName = "Kirkorov",
                email = "test@yandex.ru",
                mobile = "9042901111",
                dateOfBirth="02 Apr 2022",
                CurrentAddress = "45 h, Some st, Some city";

    @BeforeAll
    static void setUP(){
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.holdBrowserOpen=true;
    }

    @AfterAll
    static void closeAll() throws InterruptedException {
        Thread.sleep(5000);
        closeWindow();
        closeWebDriver();
    }

    @Test
    void fillFieldsTest(){
        open("automation-practice-form");
//        <input required="" autocomplete="off" placeholder="First Name" type="text" id="firstName" class=" mr-sm-2 form-control">
        $("#firstName").setValue(firstName);
//        <input required="" autocomplete="off" placeholder="Last Name" type="text" id="lastName" class=" mr-sm-2 form-control">
        $("#lastName").setValue(lastName);
//        <input autocomplete="off" pattern="^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$" placeholder="name@example.com" type="text" id="userEmail" class="mr-sm-2 form-control">
        $("#userEmail").setValue(email);
//        <input name="gender" required="" type="radio" id="gender-radio-1" class="custom-control-input" value="Male">
        $("#genterWrapper").$(byText("Male")).click();
//         <input required="" autocomplete="off" pattern="\d*" minlength="10" maxlength="10" placeholder="Mobile Number" type="text" id="userNumber" class=" mr-sm-2 form-control">
        $("#userNumber").setValue(mobile);
//        <input type="text" id="dateOfBirthInput" class="form-control react-datepicker-ignore-onclickoutside" value="09 Apr 2022">
        $("#dateOfBirthInput").click();
        //<select class="react-datepicker__month-select">
        $(".react-datepicker__month-select").selectOption("December");
        //<select class="react-datepicker__year-select">
        $(".react-datepicker__year-select").selectOption("2002");
        //<div class="react-datepicker__day react-datepicker__day--017 react-datepicker__day--selected react-datepicker__day--weekend" tabindex="0" aria-label="Choose Sunday, April 17th, 2022" role="option" aria-disabled="false">17</div>
//        $("react-datepicker__day react-datepicker__day--017 react-datepicker__day--selected react-datepicker__day--weekend").$(By.tagName("class")).click();
        $("[aria-label$='December 17th, 2002']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/Jdun.jpg");
        $("#currentAddress").setValue(CurrentAddress);

        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Gurgaon")).click();
//        $("#react-select-3-input").setValue("NCR").pressEnter();
//        $("#react-select-4-input").setValue("Noida").pressEnter();
        sleep(2000);
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Jora Kirkorov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("test@yandex.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9042901111"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("17 December,2002"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths, Computer Science"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("Jdun.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("45 h, Some st, Some city"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Gurgaon"));

//        $(".table-responsive").shouldHave(text("Jora Kirkorov"), text("test@yandex.ru"), text("9042901111"), text("02 Apr 2022"), text("45 h, Some st, Some city"));





//        /*
//        Test table fields by xPath
//         */
//        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]")).shouldHave(Condition.text("Alex Kirkorov"));
//        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")).shouldHave(Condition.text("test@yandex.ru"));
//        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]")).shouldHave(Condition.text("Male"));
//        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]")).shouldHave(Condition.text("9042901111"));
//        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[5]/td[2]")).shouldHave(Condition.text("03 April,2022"));
//        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[6]/td[2]")).shouldHave(Condition.text("Maths"));
//        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[7]/td[2]")).shouldHave(Condition.text("Sports"));
//        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[8]/td[2]")).shouldHave(Condition.text("Jdun.jpg"));
//        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[9]/td[2]")).shouldHave(Condition.text("45 h, Some st, Some city"));
//        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[10]/td[2]")).shouldHave(Condition.text("NCR Noida"));
//




    }
}
