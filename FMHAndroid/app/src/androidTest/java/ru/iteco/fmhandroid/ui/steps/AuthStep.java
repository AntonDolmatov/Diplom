package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.data.Helper.invalidAuthData;
import static ru.iteco.fmhandroid.ui.data.Helper.invalidPassData;
import static ru.iteco.fmhandroid.ui.screenElement.AuthElement.loginText;
import static ru.iteco.fmhandroid.ui.screenElement.AuthElement.nameAuthText;
import static ru.iteco.fmhandroid.ui.screenElement.AuthElement.passwordText;
import static ru.iteco.fmhandroid.ui.screenElement.AuthElement.signInButton;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.Helper;

public class AuthStep {

    public void checkAuthScreenElements() {
        Allure.step("Элементы экрана авторизации");
        nameAuthText.check(matches(isDisplayed()));
        loginText.check(matches(isDisplayed()));
        passwordText.check(matches(isDisplayed()));
        signInButton.check(matches(isDisplayed()));
    }

    public void authWithValidLoginAndPass(Helper.User info) {
        Allure.step("Авторизация с валидным логином и паролем");
        checkAuthScreenElements();
        loginText.perform(replaceText(info.getLogin()));
        passwordText.perform(replaceText(info.getPass()));
    }

    public void authWithInvalidLoginAndPass(Helper.User info) {
        Allure.step("Авторизация с невалидными логином и паролем");
        checkAuthScreenElements();
        loginText.perform(replaceText(invalidAuthData().getLogin()));
        passwordText.perform(replaceText(invalidAuthData().getPass()));
    }


    public void authWithInvalidPass(Helper.User info) {
        Allure.step("Авторизация с невалидным паролем и валидным логином");
        checkAuthScreenElements();
        loginText.perform(replaceText(invalidPassData().getLogin()));
        passwordText.perform(replaceText(invalidPassData().getPass()));
    }


    public void clickSignInButton() {
        Allure.step("Нажать кнопку SignIn");
        signInButton.perform(click());
    }
}