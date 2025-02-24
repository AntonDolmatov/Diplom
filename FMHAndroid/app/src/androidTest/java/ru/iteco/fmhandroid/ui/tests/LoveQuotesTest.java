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
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.LoveStep;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.SplashStep;

@RunWith(AllureAndroidJUnit4.class)
public class LoveQuotesTest {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);
    AuthStep authStep = new AuthStep();
    LoveStep loveStep = new LoveStep();
    MainSteps mainSteps = new MainSteps();
    SplashStep splashStep = new SplashStep();

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
            mainSteps.clickOurMissionButton();
        }
    }


    @Test
    @DisplayName("Экран с цитатами")
    public void ourMissionScreenElements() {

        loveStep.checkOurMissionElements();

    }
}


