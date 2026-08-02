package test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
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
