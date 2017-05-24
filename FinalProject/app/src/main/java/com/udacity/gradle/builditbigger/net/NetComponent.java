package com.udacity.gradle.builditbigger.net;

import android.content.SharedPreferences;

import com.udacity.gradle.builditbigger.AppModule;
import com.udacity.gradle.builditbigger.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by alexandrenavarro on 5/24/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    void inject(MainActivityViewModel viewModel);
}
