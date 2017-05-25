package com.udacity.gradle.builditbigger.net;

import com.udacity.gradle.builditbigger.JokeApplication;
import com.udacity.gradle.builditbigger.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by alexandrenavarro on 24/05/17.
 */

@Singleton
@Component(modules={DataModule.class})
public interface DataComponent {

    void inject(JokeApplication jokeApplication);
    void inject(JokeRepository jokeRepository);
    void inject(MainActivityViewModel mainActivityViewModel);
}
