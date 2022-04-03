package demoqa.com.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {
    @BeforeAll
    static void setUP(){
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.holdBrowserOpen=true;
    }

    @Test
    void fillFieldsTest(){

        String firstName = "Alex", lastName = "Kirkorov", email = "test@yandex.ru",
                mobile = "9042901111", dateOfBirth="02 Apr 2022", CurrentAddress = "45 h, Some st, Some city";


        open("automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click();
        $("#userNumber").setValue(mobile);
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click();
        $("#uploadPicture").getCssValue("form-control-file");
        $("#uploadPicture").uploadFromClasspath("Jdun.jpg");
        $("#currentAddress").setValue(CurrentAddress);
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").pressEnter();

        /*
        Test table fields.
         */
        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]")).shouldHave(Condition.text("Alex Kirkorov"));
        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")).shouldHave(Condition.text("test@yandex.ru"));
        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]")).shouldHave(Condition.text("Male"));
        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]")).shouldHave(Condition.text("9042901111"));
        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[5]/td[2]")).shouldHave(Condition.text("03 April,2022"));
        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[6]/td[2]")).shouldHave(Condition.text("Maths"));
        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[7]/td[2]")).shouldHave(Condition.text("Sports"));
        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[8]/td[2]")).shouldHave(Condition.text("Jdun.jpg"));
        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[9]/td[2]")).shouldHave(Condition.text("45 h, Some st, Some city"));
        $(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[10]/td[2]")).shouldHave(Condition.text("NCR Noida"));
        closeWindow();
        closeWebDriver();
    }
}
