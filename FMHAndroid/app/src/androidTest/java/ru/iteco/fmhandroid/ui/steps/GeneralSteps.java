package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.IsNot.not;
import static ru.iteco.fmhandroid.ui.screenElement.GeneralElements.cancelButton;
import static ru.iteco.fmhandroid.ui.screenElement.GeneralElements.emptyToastMatcher;
import static ru.iteco.fmhandroid.ui.screenElement.GeneralElements.errorToastMatcher;
import static ru.iteco.fmhandroid.ui.screenElement.GeneralElements.invalidData;
import static ru.iteco.fmhandroid.ui.screenElement.GeneralElements.newsListImage;
import static ru.iteco.fmhandroid.ui.screenElement.GeneralElements.noText;
import static ru.iteco.fmhandroid.ui.screenElement.GeneralElements.okButton;
import static ru.iteco.fmhandroid.ui.screenElement.GeneralElements.refreshText;
import static ru.iteco.fmhandroid.ui.screenElement.GeneralElements.saveButton;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screenElement.GeneralElements;

public class GeneralSteps {
    public void clickSaveButton() {
        Allure.step("Нажать на кнопку Save");
        saveButton.perform(click());
    }

    public void clickCancelButton() {
        Allure.step("Нажать на кнопку Cancel");
        cancelButton.perform(click());
    }

    public void clickOkButton() {
        Allure.step("Нажать на кнопку ОК");
        okButton.perform(click());
    }

    public void checkEmptyToast(int id, boolean visible) {
        if (visible) {
            emptyToastMatcher(id).check(matches(isDisplayed()));
        } else {
            emptyToastMatcher(id).check(matches(not(isDisplayed())));
        }
    }


    public void checkInvalidAuthDataToast() {
        Allure.step("Проверка предупреждения");
        checkEmptyToast(GeneralElements.getError(), true);
    }

    public void checkEmptyAuthDataToast() {
        Allure.step("Проверка предупреджения");
        checkEmptyToast(GeneralElements.getEmptyInfoMatcher(), true);
    }


    public void checkErrorToast(int id, boolean visible) {
        if (visible) {
            errorToastMatcher(id).check(matches(isDisplayed()));
        } else {
            errorToastMatcher(id).check(matches(not(isDisplayed())));
        }
    }

    public void checkEmptyFieldError() {
        Allure.step("Текст ошибки пустые поля");
        checkErrorToast(GeneralElements.getEmptyFields(), true);
    }

    public void checkInvalidData(String text, boolean visible) {
        if (visible) {
            invalidData(text).check(matches(isDisplayed()));
        } else {
            invalidData(text).check(matches(not(isDisplayed())));
        }
    }

    public void checkNewsListImage() {
        Allure.step("Проверка картинки с бабочкой");
        newsListImage.check(matches(isDisplayed()));
    }

    public void checkNothingToShow() {
        Allure.step("Элемент экрана нечего показать");
        noText.check(matches(isDisplayed()));
        refreshText.check(matches(isDisplayed()));
    }
}
