package ru.iteco.fmhandroid.ui.steps;


import static ru.iteco.fmhandroid.ui.data.Helper.elementWaiting;
import static ru.iteco.fmhandroid.ui.screenElement.SplashElement.getSplashscreenImage;

import io.qameta.allure.kotlin.Allure;

public class SplashStep {

    public void appDownload() {
        Allure.step("Загрузка приложения");
        elementWaiting(getSplashscreenImage(), 5000);
    }
}
