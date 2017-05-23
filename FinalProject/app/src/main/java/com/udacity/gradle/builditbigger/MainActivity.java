package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.alexandrenavarro.joke.backend.myApi.MyApi;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import br.com.alexandrenavarro.lib.Joke;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
//        Intent intent = new Intent(this, br.com.alexandrenavarro.jokerandroidlib.MainActivity.class);
//        intent.putExtra(br.com.alexandrenavarro.jokerandroidlib.MainActivity.EXTRA_JOKE, new Joke().tell());
//        startActivity(intent);
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Bulachudo"));

    }


}

class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
//    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        context = params[0].first;
        String name = params[0].second;

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:8080/_ah/api/myApi/v1/")
                .build();

        Teste service = retrofit.create(Teste.class);
        Call<Data> abacate = service.syHi(name);
        try {
            Response<Data> execute = abacate.execute();
           return execute.body().getData();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, br.com.alexandrenavarro.jokerandroidlib.MainActivity.class);
        intent.putExtra(br.com.alexandrenavarro.jokerandroidlib.MainActivity.EXTRA_JOKE, result);
        context.startActivity(intent);
    }
}