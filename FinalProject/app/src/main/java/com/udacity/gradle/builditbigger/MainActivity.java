package com.udacity.gradle.builditbigger;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends LifecycleActivity {

    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
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
        viewModel.loadAJoke();
        viewModel.getData().observe(this, new Observer<Data>() {
            @Override
            public void onChanged(@Nullable Data data) {
                Intent intent = new Intent(MainActivity.this, br.com.alexandrenavarro.jokerandroidlib.MainActivity.class);
                intent.putExtra(br.com.alexandrenavarro.jokerandroidlib.MainActivity.EXTRA_JOKE, data.getData());
                startActivity(intent);
            }
        });
//        Intent intent = new Intent(this, br.com.alexandrenavarro.jokerandroidlib.MainActivity.class);
//        intent.putExtra(br.com.alexandrenavarro.jokerandroidlib.MainActivity.EXTRA_JOKE, new Joke().tell());
//        startActivity(intent);
//        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Bulachudo"));

    }

}