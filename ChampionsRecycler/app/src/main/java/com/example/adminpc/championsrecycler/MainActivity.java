package com.example.adminpc.championsrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.adminpc.championsrecycler.Controler.MyAdapter;
import com.example.adminpc.championsrecycler.Model.Champion;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<String> champlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);




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
