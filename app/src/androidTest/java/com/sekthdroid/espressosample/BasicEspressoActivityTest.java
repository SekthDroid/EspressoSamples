package com.sekthdroid.espressosample;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

@RunWith(AndroidJUnit4.class)
public class BasicEspressoActivityTest {

    @Rule
    public ActivityTestRule<BasicEspressoActivity> activityRule = new ActivityTestRule<>(BasicEspressoActivity.class, true, false);

    @Before
    public void setUp() throws Exception {
        activityRule.launchActivity(null);
    }

    @Test
    public void defaultLabelShouldBeHelloWorld() throws Exception {
        onView(withId(R.id.tv_label)).check(matches(withText(R.string.hello_world)));
    }

    @Test
    public void changeLabelButtonShouldChangeLabelValue() throws Exception {
        onView(withId(R.id.btn_change)).perform(click());

        onView(withId(R.id.tv_label)).check(matches(withText(R.string.changed)));
    }

    @Test
    public void resetButtonShouldChangeLabelValueToDefault() throws Exception {
        onView(withId(R.id.btn_change)).perform(click());

        onView(withId(R.id.btn_reset)).perform(click());

        onView(withId(R.id.tv_label)).check(matches(withText(R.string.hello_world)));
    }

    @Test
    public void settingCustomTextShouldChangeLabelValueToInputText() throws Exception {
        onView(withId(R.id.et_input)).perform(ViewActions.typeText("Hello"));

        onView(withId(R.id.btn_set)).perform(click());

        onView(withId(R.id.tv_label)).check(matches(withText("Hello")));
    }

    @Test
    public void settingCustomTextShouldShowErrorIfInputIsEmpty() throws Exception {
        onView(withId(R.id.btn_set)).perform(click());

        BasicEspressoActivity activity = activityRule.getActivity();
        onView(withText(R.string.empty_input))
                .inRoot(withDecorView(not(activity.getWindow().getDecorView())))
                .check(matches(isDisplayed()));

        onView(withId(R.id.tv_label)).check(matches(withText(R.string.hello_world)));
    }
}
