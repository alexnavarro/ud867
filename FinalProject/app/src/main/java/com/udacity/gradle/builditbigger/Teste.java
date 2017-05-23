package com.udacity.gradle.builditbigger;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by alexandrenavarro on 5/23/17.
 */

public interface Teste {

    @POST("sayHi/{name}")
    Call<Data> syHi(@Path("name") String name);
}
