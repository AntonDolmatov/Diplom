package ru.iteco.fmhandroid.ui.screenElement;


import android.view.View;

import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class SplashElement {

    public static Matcher<View> getSplashscreenImage() {
        return ViewMatchers.withId(R.id.splashscreen_image_view);
    }
}
