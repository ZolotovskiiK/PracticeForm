package test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.PracticeFormPage;
import pages.SimpleFormPage;
import testdata.TestData;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;

public class BaseTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    SimpleFormPage simpleFormPage = new SimpleFormPage();
    TestData data = new TestData();

    @BeforeAll
    static void beforeAll() {
        browserSize = "1920x1080";
        baseUrl = "https://demoqa.com";
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }
}
