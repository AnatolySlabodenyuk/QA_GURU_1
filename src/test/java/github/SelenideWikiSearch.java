package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideWikiSearch {

  @Test
  void shouldFindSelenideRepositoryAtTheTop() {
    // открыть страницу Selenide в Github
    open("https://github.com/selenide/selenide");

    // перейти в раздел Wiki проекта
    $("#wiki-tab").click();

    // убедиться, что в списке страниц (Pages) есть страница SoftAssertions]
    $(byText("Show 2 more pages…")).click();
    $("div.js-wiki-sidebar-toggle-display").shouldHave(text("SoftAssertions"));

    // открыть страницу SoftAssertions
    $("div.js-wiki-sidebar-toggle-display").find(byText("SoftAssertions")).click();

    // проверить, что внутри есть пример кода для JUnit5
    $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
  }
}
