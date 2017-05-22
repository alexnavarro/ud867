package br.com.alexandrenavarro.jokerandroidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "EXTRA_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null && getIntent().getExtras().containsKey(EXTRA_JOKE)){
            ((TextView)findViewById(R.id.txt_joke)).setText(getIntent().getExtras().getString(EXTRA_JOKE));
        }
    }
}