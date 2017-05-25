package com.udacity.gradle.builditbigger;

import android.app.Application;

import com.udacity.gradle.builditbigger.net.DaggerDataComponent;
import com.udacity.gradle.builditbigger.net.DataComponent;
import com.udacity.gradle.builditbigger.net.DataModule;

/**
 * Created by alexandrenavarro on 5/24/17.
 */

public class JokeApplication extends Application {

    private static JokeApplication app;
    DataComponent dataComponent;

    public static JokeApplication getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        initDataComponent();
        dataComponent.inject(this);
    }

    private void initDataComponent(){
        dataComponent = DaggerDataComponent.builder()
                .dataModule(new DataModule(this))
                .build();
    }

    public DataComponent getDataComponent() {
        return dataComponent;
    }
}