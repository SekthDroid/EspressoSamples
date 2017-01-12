package com.sekthdroid.espressosample;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

/**
 * Created by SekthDroid on 12/1/17.
 */
@RunWith(AndroidJUnit4.class)
public class MenuActivityTest {
    @Rule
    public ActivityTestRule<MenuActivity> activityRule = new ActivityTestRule<>(MenuActivity.class, true, false);

    @Before
    public void setUp() throws Exception {
        activityRule.launchActivity(null);
    }

    @Test
    public void shouldLoadListOfItems() throws Exception {
        onView(withId(R.id.lv_items)).check(ViewAssertions.matches(Matchers.withItemCount(2)));
    }

    @Test
    public void shouldOpenBasicActivityWhenClickedInFirstItem() throws Exception {
        onData(anything()).inAdapterView(withId(R.id.lv_items)).atPosition(0).perform(click());

        Assert.assertEquals(BasicEspressoActivity.class.getName(), TestUtils.getActivityInstance().getClass().getName());
    }
}