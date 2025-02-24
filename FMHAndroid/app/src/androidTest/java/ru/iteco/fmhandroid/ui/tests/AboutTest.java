package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.Helper;
import ru.iteco.fmhandroid.ui.steps.AboutStep;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.SplashStep;


@RunWith(AllureAndroidJUnit4.class)
public class AboutTest {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);
    AuthStep authStep = new AuthStep();
    AboutStep aboutStep = new AboutStep();
    MainSteps mainSteps = new MainSteps();
    SplashStep splashStep = new SplashStep();

    @Before
    public void logoutCheck() {
        splashStep.appDownload();
        try {
            mainSteps.loadMainScreen();
        } catch (Exception e) {
            authStep.authWithValidLoginAndPass(Helper.authInfo());
            authStep.clickSignInButton();
        } finally {
            mainSteps.loadMainScreen();
            mainSteps.clickOnAboutUs();
        }
    }

    @Test
    @DisplayName("Проверка элементов экрана About")
    public void checkScreenElementsOnAboutUs() {
        aboutStep.checkScreenElementsAboutUs();
    }

    @Test
    @DisplayName("Возврат на главный экран приложения")
    public void returnToMainScreen() {
        aboutStep.checkScreenElementsAboutUs();
        aboutStep.checkReturnButton();
        mainSteps.checkMainElements();
    }

    @Test
    @DisplayName("Проверка ссылок")
    public void checkClickLinks() {
        aboutStep.clickTermsOfUseLink();
        aboutStep.clickPrivacyPolicyLink();
    }


}
