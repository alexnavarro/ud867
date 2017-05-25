package com.udacity.gradle.builditbigger;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by alexandrenavarro on 5/23/17.
 */

public interface JokerService {

    @GET("pickupAJoke")
    Call<Data> getJoke();
}
