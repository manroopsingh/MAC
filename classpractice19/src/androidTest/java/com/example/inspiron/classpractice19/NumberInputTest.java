package com.example.inspiron.classpractice19;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by INSPIRON on 13-Jan-17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class NumberInputTest {

    private String num1, num2, result;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        num1 = "4";
        num2 = "4";
        result = "8";


    }

    @Test
    public void checkNum1() {
        // Type text and then press the button.
        onView(withId(R.id.et_num1))
                .perform(typeText(num1), closeSoftKeyboard());
        onView(withId(R.id.et_num2))
                .perform(typeText(num2), closeSoftKeyboard());

        onView(withId(R.id.btnAdd)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.result))
                .check(matches(withText(result)));
    }
}