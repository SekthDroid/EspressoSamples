package com.sekthdroid.espressosample;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by SekthDroid on 12/1/17.
 */
@RunWith(AndroidJUnit4.class)
public class BasicEspressoWithFragmentActivityTest {
    @Rule
    public ActivityTestRule<BasicEspressoWithFragmentActivity> activityRule = new ActivityTestRule<>(BasicEspressoWithFragmentActivity.class, true, false);

    @Before
    public void setUp() throws Exception {
        activityRule.launchActivity(null);
    }

    @Test
    public void shouldNotUpdateFooterIfInputIsEmpty() throws Exception {
        onView(withId(R.id.et_input)).perform(ViewActions.typeText(""));
        onView(withId(R.id.btn_set_footer)).perform(click());

        onView(withId(R.id.tv_footer)).check(ViewAssertions.matches(withText(R.string.im_a_footer)));
    }

    @Test
    public void shouldChangeFooterIfInputIsValid() throws Exception {
        onView(withId(R.id.et_input)).perform(ViewActions.typeText("Hello, footer from fragment"));
        onView(withId(R.id.btn_set_footer)).perform(click());

        onView(withId(R.id.tv_footer)).check(ViewAssertions.matches(withText("Hello, footer from fragment")));
    }
}