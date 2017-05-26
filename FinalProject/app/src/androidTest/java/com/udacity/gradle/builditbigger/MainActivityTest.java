package com.udacity.gradle.builditbigger;


import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.squareup.okhttp.mockwebserver.Dispatcher;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    public static final int DEFAULT_MOCK_WEB_SERVER_PORT = 46458;

    private static final String joke = "{\n" +
            "  \"data\" : \"Q: What goes up and down but does not move?\\nA: Stairs\\n\\n\"\n" +
            "}";

    private static MockWebServer server;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class, true, false);

    @BeforeClass
    public static void setup() throws Exception {
        server = new MockWebServer();
        server.start(DEFAULT_MOCK_WEB_SERVER_PORT);
        server.url("/").toString();

        final Dispatcher dispatcher = new Dispatcher() {

            @Override
            public MockResponse dispatch(RecordedRequest request) throws InterruptedException {

                if (request.getPath().contains("/leads")) {
                    return new MockResponse().setResponseCode(200);
                } else {
                    try {
                        return new MockResponse().setResponseCode(200).setBody(joke);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                return new MockResponse().setResponseCode(404);
            }
        };

        server.setDispatcher(dispatcher);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void whenButtonIsTapedAJokeIsShown() {
        mActivityTestRule.launchActivity(new Intent());
        onView(withText("Tell Joke")).perform(click());
        onView(withText(joke));
    }
}