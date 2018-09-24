package com.example.dmitry.footballscore;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer spartak = 0;

    private Integer loko = 0;

    private static final String TAG = "MainActivity";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();
        TextView spartakView = findViewById(R.id.spartak_score);
        spartakView.setText(spartak.toString());

        TextView lokoView = findViewById(R.id.loko_score);
        lokoView.setText(loko.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void onClickAddSpartak(View view) {
        spartak++;
        TextView counterView = findViewById(R.id.spartak_score);
        counterView.setText(spartak.toString());
    }

    @SuppressLint("SetTextI18n")
    public void onClickAddLokomotiv(View view) {
        loko++;
        TextView counterView2 = findViewById(R.id.loko_score);
        counterView2.setText(loko.toString());
    }

    @SuppressLint("SetTextI18n")
    public void onClickButtonClear(View view) {
        spartak = 0;
        loko = 0;
        TextView counterView = findViewById(R.id.spartak_score);
        counterView.setText(spartak.toString());

        TextView counterView2 = findViewById(R.id.loko_score);
        counterView2.setText(loko.toString());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("spartak", spartak);
        outState.putInt("loko", loko);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("spartak")) {
            spartak = savedInstanceState.getInt("spartak");
        }
        if ((savedInstanceState != null && savedInstanceState.containsKey("loko"))) {
            loko = savedInstanceState.getInt("loko");
        }
        Log.d(TAG, "onRestoreInstanceState");
    }

}
