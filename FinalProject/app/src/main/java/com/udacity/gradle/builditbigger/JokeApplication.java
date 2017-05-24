package com.udacity.gradle.builditbigger;

import android.app.Application;

import com.udacity.gradle.builditbigger.net.NetComponent;

/**
 * Created by alexandrenavarro on 5/24/17.
 */

public class JokeApplication extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();



       // mNetComponent = DaggerNetComponent
    }
}
