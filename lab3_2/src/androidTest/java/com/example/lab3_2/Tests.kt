package com.example.lab3_2

import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.NoActivityResumedException
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation

import org.hamcrest.Matchers
import org.junit.Assert

import org.junit.Test
import org.junit.Rule

class AppTests {

    @get:Rule
    var intentsRule: IntentsTestRule<Act1> = IntentsTestRule(Act1::class.java)


    @Test
    fun test1() {
        intentsRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        Espresso.onView(withId(R.id.button)).perform(ViewActions.click())
        intended(hasComponent(Act2::class.java.name))
        intentsRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        Espresso.onView(withId(R.id.textView2)).check(matches(withText("Activity 2")))
        Espresso.onView(withId(R.id.button3)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textView3)).check(matches(withText("Activity 3")))
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Espresso.onView(withId(R.id.textView1)).check(matches(withText("Activity 1")))

    }

    @Test
    fun test2() {
        intentsRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        Espresso.onView(withId(R.id.button)).perform(ViewActions.click())
        intended(hasComponent(Act2::class.java.name))
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        Espresso.onView(Matchers.allOf(withText("About"))).perform(ViewActions.click())
        intended(hasComponent(About::class.java.name))
        Espresso.onView(withId(R.id.textView)).check(matches(withText("About Activity 2")))
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Espresso.onView(withId(R.id.textView2)).check(matches(withText("Activity 2")))
        Espresso.onView(withId(R.id.button2)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textView1)).check(matches(withText("Activity 1")))
        try {
            Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
            Assert.fail()
        } catch (e: NoActivityResumedException) {

        }
    }

    @Test
    fun test3() {
        intentsRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        Espresso.onView(withId(R.id.button)).perform(ViewActions.click())
        intended(hasComponent(Act2::class.java.name))
        Espresso.onView(withId(R.id.button3)).perform(ViewActions.click())
        intended(hasComponent(Act3::class.java.name))
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        Espresso.onView(Matchers.allOf(withText("About"))).perform(ViewActions.click())
        intended(hasComponent(About::class.java.name))
        Espresso.onView(withId(R.id.textView)).check(matches(withText("About Activity 3")))
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Espresso.onView(withId(R.id.textView3)).check(matches(withText("Activity 3")))
        Espresso.onView(withId(R.id.button4)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textView1)).check(matches(withText("Activity 1")))
        intentsRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        Espresso.onView(withId(R.id.textView1)).check(matches(withText("Activity 1")))
        try {
            Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
            Assert.fail()
        } catch (e: NoActivityResumedException) {

        }
    }

    @Test
    fun backstackTest() {
        Espresso.onView(withId(R.id.button)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button2)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button3)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textView3)).check(matches(withText("Activity 3")))
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        try {
            Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
            Assert.fail()
        } catch (e: NoActivityResumedException) {

        }
    }

}