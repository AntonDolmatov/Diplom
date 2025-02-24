package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.screenElement.CreateNews.categoryName;
import static ru.iteco.fmhandroid.ui.screenElement.CreateNews.categoryText;
import static ru.iteco.fmhandroid.ui.screenElement.CreateNews.createName;
import static ru.iteco.fmhandroid.ui.screenElement.CreateNews.descriptionName;
import static ru.iteco.fmhandroid.ui.screenElement.CreateNews.descriptionText;
import static ru.iteco.fmhandroid.ui.screenElement.CreateNews.publicationDateName;
import static ru.iteco.fmhandroid.ui.screenElement.CreateNews.publishDateText;
import static ru.iteco.fmhandroid.ui.screenElement.CreateNews.timeText;
import static ru.iteco.fmhandroid.ui.screenElement.CreateNews.titleName;
import static ru.iteco.fmhandroid.ui.screenElement.CreateNews.titleText;

import io.qameta.allure.kotlin.Allure;

public class CreateNewsStep {

    public static void newsScreenElements() {
        Allure.step("Элементы экрана Creating News");
        createName.check(matches(isDisplayed()));
        categoryName.check(matches(isDisplayed()));
        categoryText.check(matches(isDisplayed()));
        titleName.check(matches(isDisplayed()));
        titleText.check(matches(isDisplayed()));
        publishDateText.check(matches(isDisplayed()));
        publicationDateName.check(matches(isDisplayed()));
        timeText.check(matches(isDisplayed()));
        titleName.check(matches(isDisplayed()));
        descriptionName.check(matches(isDisplayed()));
        descriptionText.check(matches(isDisplayed()));

    }

    public void fillCategory(String text) {
        Allure.step("Ввод данных в поле Category");
        categoryText.perform(replaceText(text));

    }

    public void fillTitle(String text) {
        Allure.step("Ввод данных в поле Title");
        titleText.perform(replaceText(text));
    }

    public void fillPublicDate(String text) {
        Allure.step("Ввод данных в поле Publication date");
        publishDateText.perform(replaceText(text));
    }

    public void fillTimeField(String text) {
        Allure.step("Ввод данных в поле Time");
        timeText.perform(replaceText(text));
    }

    public void fillNewsDescription(String text) {
        Allure.step("Ввод данных в поле Description");
        descriptionText.perform(replaceText(text));
    }

    public void createNews(String category, String title, String publicationDate, String publicationTime, String description) {
        Allure.step("Creating News");
        fillCategory(category);
        fillTitle(title);
        fillPublicDate(publicationDate);
        fillTimeField(publicationTime);
        fillNewsDescription(description);
    }


}
