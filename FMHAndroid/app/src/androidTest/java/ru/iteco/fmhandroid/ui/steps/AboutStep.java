package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.data.Helper.elementWaiting;
import static ru.iteco.fmhandroid.ui.screenElement.AboutElement.companyInfoLabel;
import static ru.iteco.fmhandroid.ui.screenElement.AboutElement.privacyPolicyLabel;
import static ru.iteco.fmhandroid.ui.screenElement.AboutElement.privacyPolicyValue;
import static ru.iteco.fmhandroid.ui.screenElement.AboutElement.returnButton;
import static ru.iteco.fmhandroid.ui.screenElement.AboutElement.termsOfUseLabel;
import static ru.iteco.fmhandroid.ui.screenElement.AboutElement.termsOfUseValue;
import static ru.iteco.fmhandroid.ui.screenElement.AboutElement.trademark;
import static ru.iteco.fmhandroid.ui.screenElement.AboutElement.versionTitle;
import static ru.iteco.fmhandroid.ui.screenElement.AboutElement.versionValue;

import android.view.View;

import org.hamcrest.Matcher;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screenElement.AboutElement;

public class AboutStep {

    Matcher<View> companyInfoMatcher = AboutElement.getCompanyInfoMatcher();


    public void checkScreenElementsAboutUs() {
        Allure.step("Проверка элементов экрана About");
        elementWaiting(companyInfoMatcher, 10000);
        trademark.check(matches(isDisplayed()));
        versionTitle.check(matches(isDisplayed()));
        versionValue.check(matches(isDisplayed()));
        privacyPolicyLabel.check(matches(isDisplayed()));
        privacyPolicyValue.check(matches(isDisplayed()));
        termsOfUseLabel.check(matches(isDisplayed()));
        termsOfUseValue.check(matches(isDisplayed()));
        companyInfoLabel.check(matches(isDisplayed()));
        returnButton.check(matches(isDisplayed()));
    }

    public void clickTermsOfUseLink() {
        Allure.step("Нажать на Terms of use");
        termsOfUseValue.check(matches(isClickable()));
    }

    public void clickPrivacyPolicyLink() {
        Allure.step("Нажать на Privacy Policy");
        elementWaiting(companyInfoMatcher, 10000);
        privacyPolicyValue.check(matches(isClickable()));
    }

    public void checkReturnButton() {
        Allure.step("Кнопки Back");
        returnButton.perform(click());
    }
}
