package com.binar.sciroper.ui.setting

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.binar.sciroper.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SettingActivityTest{

    @Test
    fun testActivity_inView(){
        val activityScenario = ActivityScenario.launch(SettingActivity::class.java)

        onView(withId(R.id.settingActivityView)).check(matches(isDisplayed()))
    }

}