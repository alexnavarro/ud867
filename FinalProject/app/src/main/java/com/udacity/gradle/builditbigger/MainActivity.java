package com.udacity.gradle.builditbigger;

import android.arch.lifecycle.LifecycleActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import br.com.alexandrenavarro.lib.Joke;

public class MainActivity extends LifecycleActivity {

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
        new JokerAsyncTask().execute();
    }

    private  class JokerAsyncTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            return new Joke().tell();
        }

        @Override
        protected void onPostExecute(String result) {
            Intent intent = new Intent(MainActivity.this, br.com.alexandrenavarro.jokerandroidlib.MainActivity.class);
            intent.putExtra(br.com.alexandrenavarro.jokerandroidlib.MainActivity.EXTRA_JOKE, result);
            startActivity(intent);
        }
    }
}