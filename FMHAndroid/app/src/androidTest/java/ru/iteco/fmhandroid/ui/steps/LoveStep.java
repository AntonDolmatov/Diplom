package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.screenElement.LoveElement.missionList;
import static ru.iteco.fmhandroid.ui.screenElement.LoveElement.missionName;

import io.qameta.allure.kotlin.Allure;

public class LoveStep {
    public void checkOurMissionElements() {
        Allure.step("Проверка элементов экрана Love is all");
        missionName.check(matches(isDisplayed()));
        missionList.check(matches(isDisplayed()));
    }

}
