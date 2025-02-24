package ru.iteco.fmhandroid.ui.tests;


import static ru.iteco.fmhandroid.ui.data.Helper.authInfo;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutStep;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.LoveStep;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsStep;
import ru.iteco.fmhandroid.ui.steps.SplashStep;

@RunWith(AllureAndroidJUnit4.class)
public class MainPaigeTest {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);
    AuthStep authStep = new AuthStep();
    MainSteps mainSteps = new MainSteps();
    NewsStep newsStep = new NewsStep();
    LoveStep loveStep = new LoveStep();
    SplashStep splashStep = new SplashStep();
    AboutStep aboutStep = new AboutStep();

    @Before
    public void logoutCheck() {
        splashStep.appDownload();
        try {
            mainSteps.loadMainScreen();
        } catch (Exception e) {
            authStep.authWithValidLoginAndPass(authInfo());
            authStep.clickSignInButton();
        } finally {
            mainSteps.loadMainScreen();
        }
    }

    @Test
    @DisplayName("Отображение разделов меню")
    public void menuElementsVisibility() {
        mainSteps.clickMenuButton();
        mainSteps.checkMenuList();
    }

    @Test
    @DisplayName("Переход по меню")
    public void menuNewsToAbout() {
        mainSteps.clickOnNews();
        newsStep.checkNewsElements();
        mainSteps.clickOnAboutUs();
        aboutStep.checkScreenElementsAboutUs();
    }

    @Test
    @DisplayName("Переход на вкладку Наша миссия")
    public void goToOurMission() {
        mainSteps.clickOurMissionButton();
        loveStep.checkOurMissionElements();
    }

    @Test
    @DisplayName("Переход в новости через кнопку All news")
    public void goToAllNews() {
        mainSteps.clickAllNewsButton();
        newsStep.checkNewsElements();
        mainSteps.clickOnMain();
        mainSteps.checkMainElements();
    }

    @Test
    @DisplayName("Развернуть/свернуть блок новостей")
    public void checkNewsBlock() {
        mainSteps.checkAllNews();
        mainSteps.allNewsNotDisplayed();
        mainSteps.checkAllNews();
        mainSteps.allNewsAreDisplayed();
    }

    @Test
    @DisplayName("Посмотреть отдельную новoсть")
    public void checkNews() {
        mainSteps.checkNews(0);
        mainSteps.descriptionDisplayed(0);
    }
}



