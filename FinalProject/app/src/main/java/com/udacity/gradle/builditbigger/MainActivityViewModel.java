package com.udacity.gradle.builditbigger;

import android.app.Application;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by alexandrenavarro on 5/24/17.
 */

public class MainActivityViewModel {

    @Inject
    Retrofit retrofit;

    public MainActivityViewModel(Retrofit retrofit){
   
    }
}
