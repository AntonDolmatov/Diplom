package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.not;
import static ru.iteco.fmhandroid.ui.data.Helper.elementWaiting;
import static ru.iteco.fmhandroid.ui.data.Helper.waitForElement;
import static ru.iteco.fmhandroid.ui.data.Helper.withIndex;
import static ru.iteco.fmhandroid.ui.screenElement.MainElement.aboutText;
import static ru.iteco.fmhandroid.ui.screenElement.MainElement.allNews;
import static ru.iteco.fmhandroid.ui.screenElement.MainElement.allNewsButton;
import static ru.iteco.fmhandroid.ui.screenElement.MainElement.childNews;
import static ru.iteco.fmhandroid.ui.screenElement.MainElement.getNewsDescriptionText;
import static ru.iteco.fmhandroid.ui.screenElement.MainElement.logoutButton;
import static ru.iteco.fmhandroid.ui.screenElement.MainElement.logoutText;
import static ru.iteco.fmhandroid.ui.screenElement.MainElement.mainText;
import static ru.iteco.fmhandroid.ui.screenElement.MainElement.menuButton;
import static ru.iteco.fmhandroid.ui.screenElement.MainElement.missionButton;
import static ru.iteco.fmhandroid.ui.screenElement.MainElement.newsBlockButton;
import static ru.iteco.fmhandroid.ui.screenElement.MainElement.newsText;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.Helper;

public class MainSteps {

    public void loadMainScreen() {
        Allure.step("Загрузка основной страницы");
        elementWaiting(withText("ALL NEWS"), 10000);
    }

    public void checkMainElements() {
        Allure.step("Проверка элементов Основного экрана");
        allNews.check(matches(isDisplayed()));
    }

    public void checkAllNews() {
        Allure.step("Развернуть/свернуть блок новостей");
        newsBlockButton.check(matches(isDisplayed()));
        newsBlockButton.perform(click());
    }

    public void allNewsAreDisplayed() {
        Allure.step("Блок новостей развернут");
        allNewsButton.check(matches(isDisplayed()));
    }

    public void allNewsNotDisplayed() {
        Allure.step("Блок новостей свернут");
        allNewsButton.check(matches(not(isDisplayed())));
    }

    public void checkNews(int position) {
        Allure.step("Развернуть новость");
        childNews.perform(actionOnItemAtPosition(position, click()));
    }

    public void descriptionDisplayed( int position){
        Allure.step("Отображение описания новости");
        String descriptionText = Helper.Text.getText(onView(withIndex(getNewsDescriptionText(),position)));
        onView(allOf(withText(descriptionText), isDisplayed())).check(matches(isDisplayed()));
    }

    public void clickAllNewsButton() {
        Allure.step("Нажать на All News");
        allNewsButton.check(matches(isDisplayed()));
        allNewsButton.perform(click());
    }

    public void clickOurMissionButton() {
        Allure.step("Нажать на Наша миссия");
        missionButton.check(matches(isDisplayed()));
        missionButton.perform(click());
    }

    public void clickLogoutButton() {
        Allure.step("Нажать на Log out");
        logoutButton.check(matches(isDisplayed()));
        logoutButton.perform(click());
        onView(isRoot()).perform(waitForElement(withText("Log out"), 5000));
        logoutText.check(matches(isDisplayed()));
        logoutText.perform(click());
    }

    public void clickMenuButton() {
        Allure.step("Нажать на меню");
        menuButton.check(matches(isDisplayed()));
        menuButton.perform(click());
    }

    public void checkMenuList() {
        Allure.step("Проверка списка меню");
        mainText.check(matches(isDisplayed()));
        newsText.check(matches(isDisplayed()));
        aboutText.check(matches(isDisplayed()));
    }

    public void clickOnNews() {
        Allure.step("Нажать на кнопку News в меню");
        menuButton.perform(click());
        newsText.check(matches(isDisplayed()));
        newsText.perform(click());
    }

    public void clickOnAboutUs() {
        Allure.step("Нажать на кнопку About в меню");
        menuButton.perform(click());
        aboutText.check(matches(isDisplayed()));
        aboutText.perform(click());
    }

    public void clickOnMain() {
        Allure.step("Нажать на кнопку Main в меню");
        menuButton.perform(click());
        mainText.check(matches(isDisplayed()));
        mainText.perform(click());
    }
}
