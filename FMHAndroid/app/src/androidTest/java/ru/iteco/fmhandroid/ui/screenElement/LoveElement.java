package ru.iteco.fmhandroid.ui.screenElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class LoveElement {
    public static ViewInteraction missionName = onView(withId(R.id.our_mission_title_text_view));
    public static ViewInteraction missionList = onView(withId(R.id.our_mission_item_list_recycler_view));
}

