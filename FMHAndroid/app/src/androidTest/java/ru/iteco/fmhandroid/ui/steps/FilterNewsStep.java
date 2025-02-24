package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.screenElement.FilterNews.categoryText;
import static ru.iteco.fmhandroid.ui.screenElement.FilterNews.dateEndText;
import static ru.iteco.fmhandroid.ui.screenElement.FilterNews.dateStartText;
import static ru.iteco.fmhandroid.ui.screenElement.FilterNews.filterActive;
import static ru.iteco.fmhandroid.ui.screenElement.FilterNews.filterButton;
import static ru.iteco.fmhandroid.ui.screenElement.FilterNews.filterInActive;
import static ru.iteco.fmhandroid.ui.screenElement.FilterNews.filterNewsName;

import io.qameta.allure.kotlin.Allure;

public class FilterNewsStep {

    public void checkFilterNewsElements() {
        Allure.step("Элементы экрана Filter news");
        filterNewsName.check(matches(isDisplayed()));
        dateStartText.check(matches(isDisplayed()));
        dateEndText.check(matches(isDisplayed()));
        categoryText.check(matches(isDisplayed()));
        filterButton.check(matches(isDisplayed()));
    }

    public void clickFilterButton() {
        Allure.step("Нажать на кнопку FILTER");
        filterButton.perform(click());
    }

    public void fillStartDate(String startDate) {
        Allure.step("Ввод данных в поле ОТ даты");
        dateStartText.perform(replaceText(startDate));
    }

    public void fillEndDate(String endDate) {
        Allure.step("Ввод данных в поле ДО даты");
        dateEndText.perform(replaceText(endDate));
    }

    public void clickActiveCheckBox() {
        Allure.step("Нажать на чекбокс Active");
        filterActive.perform(click());
    }

    public void clickNotActiveCheckBox() {
        Allure.step("Нажать на чекбокс Not active");
        filterInActive.perform(click());
    }
}
