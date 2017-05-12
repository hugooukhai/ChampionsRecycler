package com.example.adminpc.championsrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.adminpc.championsrecycler.Model.Champion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Champion.createListOfChamps();
            }
        }).start();

    }
}
