package com.udacity.gradle.builditbigger;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.udacity.gradle.builditbigger.net.JokeRepository;

import javax.inject.Inject;


/**
 * Created by alexandrenavarro on 5/24/17.
 */

public class MainActivityViewModel extends ViewModel {

    private LiveData<Data> data;

    @Inject
    protected JokeRepository jokeRepo;

    public MainActivityViewModel(){
        JokeApplication.getApp().getDataComponent().inject(this);
    }

    public void loadAJoke() {
        data = jokeRepo.loadAJoke();
    }

    public LiveData<Data> getData() {
        return data;
    }
}