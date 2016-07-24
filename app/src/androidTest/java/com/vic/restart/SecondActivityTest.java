package com.vic;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.vic.restart.SecondActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SecondActivityTest {

    private static final String STRING_TO_BE_TYPED = "测试修改";

    @Rule
    public ActivityTestRule<SecondActivity> mActivityRule = new ActivityTestRule<>(
            SecondActivity.class);

    @Test
    public void sayHello() throws InterruptedException {
        Thread.sleep(3000);
        onView(withId(R.id.button)).check(matches(isClickable())); //line 3
    }

}