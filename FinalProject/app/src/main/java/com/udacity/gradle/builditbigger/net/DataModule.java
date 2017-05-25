package com.udacity.gradle.builditbigger.net;

import android.app.Application;

import com.udacity.gradle.builditbigger.JokerService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by alexandrenavarro on 5/24/17.
 */

@Module
public class DataModule {

    public final static String BASE_URL = "http://10.0.2.2:8080/_ah/api/jokerApi/v1/";

    Application application;

    public DataModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public OkHttpClient provideHttpClient() {
        return new OkHttpClient().newBuilder().build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    public JokerService provideItemService(Retrofit retrofit) {
        return retrofit.create(JokerService.class);
    }

    @Provides
    public JokeRepository provideRepository(JokerService service) {
        return new JokeRepository(service);
    }
}