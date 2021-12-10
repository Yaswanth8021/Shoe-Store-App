package com.example.shoestoreproject.activities;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import com.example.shoestoreproject.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class Login_userTest {

    @Rule
    public ActivityTestRule<Login_user> mLogin_UserTestRule = new ActivityTestRule<Login_user>(Login_user.class);

    private Login_user mLogin_User = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainActivity.class.getName(),null,false);
    @Before
    public void setUp() throws Exception {
        mLogin_User = mLogin_UserTestRule.getActivity();

    }

    @Test
    public void testLaunchOfSecondActivityOnButtonClick() {

        assertNotNull(mLogin_User.findViewById(R.id.btnLogin));

        onView(withId(R.id.btnLogin)).perform(click());

       Activity mainActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,100000);

       assertNotNull(mainActivity);

       mainActivity.finish();

    }

    @After
    public void tearDown() throws Exception {

        mLogin_User = null;
    }
}