package com.example.adminpc.championsrecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.example.adminpc.championsrecycler.Controler.MyAdapter;
import com.example.adminpc.championsrecycler.Model.Champion;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<String> champlist;
    private EditText mSearchbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mSearchbar = (EditText) findViewById(R.id.searchbar);


        mSearchbar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                for(String nom:champlist){
                    char[] nomChar =  nom.toCharArray();
                    if(s.length()>=1) {
                        if (nomChar[start] == s.charAt(start)) {
                            Log.d("Searched", nom);
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {

                champlist = Champion.createListOfChamps();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new MyAdapter(champlist);
                        mRecyclerView.setAdapter(mAdapter);
                    }
                });
            }
        }).start();

    }
}
