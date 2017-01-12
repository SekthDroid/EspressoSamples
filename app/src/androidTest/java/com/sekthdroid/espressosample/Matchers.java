package com.sekthdroid.espressosample;

import android.view.View;
import android.widget.ListView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * Created by SekthDroid on 12/1/17.
 */

public class Matchers {
    public static Matcher<View> withItemCount(final int expectedCount) {
        return new Matcher<View>() {
            @Override
            public boolean matches(Object item) {
                return ((ListView) item).getCount() == expectedCount;
            }

            @Override
            public void describeMismatch(Object item, Description mismatchDescription) {

            }

            @Override
            public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {

            }

            @Override
            public void describeTo(Description description) {
                description.appendText("List should have " + expectedCount + " items");
            }
        };
    }
}
