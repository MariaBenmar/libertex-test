package org.libertex;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchGoogleTest {
    @Test
    void selenideSearchTest() {
        open("https://www.google.com/");
        $(byName("q")).setValue("selenide").pressEnter();
        $("#search").shouldHave(text("selenide.org"));
    }


}
