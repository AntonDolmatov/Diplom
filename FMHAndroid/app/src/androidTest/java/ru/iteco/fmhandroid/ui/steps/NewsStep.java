package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.data.Helper.elementWaiting;
import static ru.iteco.fmhandroid.ui.data.Helper.withIndex;
import static ru.iteco.fmhandroid.ui.screenElement.NewsElement.allNewsBlock;
import static ru.iteco.fmhandroid.ui.screenElement.NewsElement.childNewsButton;
import static ru.iteco.fmhandroid.ui.screenElement.NewsElement.editNewsButton;
import static ru.iteco.fmhandroid.ui.screenElement.NewsElement.filterNewsButton;
import static ru.iteco.fmhandroid.ui.screenElement.NewsElement.getDescriptionTextNewsView;
import static ru.iteco.fmhandroid.ui.screenElement.NewsElement.getNewsMainList;
import static ru.iteco.fmhandroid.ui.screenElement.NewsElement.getNewsTitleText;
import static ru.iteco.fmhandroid.ui.screenElement.NewsElement.newsName;
import static ru.iteco.fmhandroid.ui.screenElement.NewsElement.sortNewsButton;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.Helper;

public class NewsStep {


    public void loadNewsList() {
        Allure.step("Загрузка списка новостей");
        elementWaiting(getNewsMainList(), 5000);
    }

    public void checkNewsElements() {
        Allure.step("Проверка элеметов экрана Новости");
        newsName.check(matches(isDisplayed()));
        allNewsBlock.check(matches(isDisplayed()));
    }

    public void openFilter() {
        Allure.step("Открыть фильтр");
        filterNewsButton.check(matches(isDisplayed()));
        filterNewsButton.perform(click());
    }

    public void clickSortButton() {
        Allure.step("Нажать Сортировать по");
        sortNewsButton.check(matches(isDisplayed()));
        sortNewsButton.perform(click());
    }

    public void clickEditButton() {
        Allure.step("Нажать на Редактировать");
        editNewsButton.check(matches(isDisplayed()));
        editNewsButton.perform(click());
    }

    public void checkOpenNews(int position) {
        Allure.step("Развернуть выбранную новость");
        childNewsButton.perform(actionOnItemAtPosition(position, click()));
    }

    public String getFirstNewsTitle(int index) {
        Allure.step("Заголовок первой новости");
        return Helper.Text.getText(onView(withIndex(getNewsTitleText(), index)));
    }

    public String getFirsNewsTitleAfterAnotherSorting(int index) {
        Allure.step("Заголовок первой новости после сортировки");
        return Helper.Text.getText(onView(withIndex(getNewsTitleText(), index)));
    }

    public String getCreateNewsDescription(int index) {
        Allure.step("Описание созданной новости");
        return Helper.Text.getText(onView(withIndex(getDescriptionTextNewsView(), index)));
    }
}
