package com.udacity.gradle.builditbigger.net;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.udacity.gradle.builditbigger.Data;
import com.udacity.gradle.builditbigger.JokerService;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by alexandrenavarro on 5/24/17.
 */

@Singleton
public class JokeRepository {

    private JokerService service;

    @Inject
    public JokeRepository(JokerService service) {
        this.service = service;
    }

    public LiveData<Data> loadAJoke(){
        final MutableLiveData<Data> data = new MutableLiveData<>();
        service.getJoke().enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d(JokeRepository.class.getSimpleName(), t.getMessage());
            }
        });

        return data;
    }
}