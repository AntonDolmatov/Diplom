package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.screenElement.EditNews.editName;
import static ru.iteco.fmhandroid.ui.screenElement.EditNews.newsCategoryText;
import static ru.iteco.fmhandroid.ui.screenElement.EditNews.newsDescriptionText;
import static ru.iteco.fmhandroid.ui.screenElement.EditNews.newsPublishDateText;
import static ru.iteco.fmhandroid.ui.screenElement.EditNews.newsPublishTimeText;
import static ru.iteco.fmhandroid.ui.screenElement.EditNews.newsTitleEditText;
import static ru.iteco.fmhandroid.ui.screenElement.EditNews.switcher;

import io.qameta.allure.kotlin.Allure;

public class EditNewsStep {

    public void checkEditNewsElements() {
        Allure.step("Элементы экрана News");
        editName.check(matches(isDisplayed()));
        newsCategoryText.check(matches(isDisplayed()));
        newsTitleEditText.check(matches(isDisplayed()));
        newsPublishDateText.check(matches(isDisplayed()));
        newsPublishTimeText.check(matches(isDisplayed()));
        newsDescriptionText.check(matches(isDisplayed()));
        switcher.check(matches(isDisplayed()));
    }

    public void editTitle(String text) {
        Allure.step("Редактировать заголовок");
        newsTitleEditText.perform(replaceText(text));
    }

    public void editDescription(String text) {
        Allure.step("Редактировать описание");
        newsDescriptionText.perform(replaceText(text));
    }

    public void changeStatus() {
        Allure.step("Поменять статус");
        switcher.perform(click());
    }
}
