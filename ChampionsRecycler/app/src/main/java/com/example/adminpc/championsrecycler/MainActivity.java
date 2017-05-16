package com.example.adminpc.championsrecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.adminpc.championsrecycler.Controler.MyAdapter;
import com.example.adminpc.championsrecycler.Model.Champion;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
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
                mAdapter.setPattern(s.toString());
                mAdapter.notifyDataSetChanged();
//                int position = 0;
//                for(String nom:champlist){
//                    if(s.length()>0){
//                        if(s.length()> start) {
//                            if(nom.length() > start) {
//                                if (nom.contains(s)) {
//                                    Log.d("Searched", nom);
//                                    Log.d("charstart", "" + start + " : " + s.charAt(start));
//                                    Log.d("charbefore", "" + before + " : " + s.charAt(before));
//                                     Log.d("charcount", "" + count);
//                                    if(mRecyclerView.getChildAt(position) != null){
//                                        mRecyclerView.getChildAt(position).setVisibility(View.VISIBLE);
//                                    }
//
//                                }else{
//                                    if(mRecyclerView.getChildAt(position) != null) {
//                                        mRecyclerView.getChildAt(position).setVisibility(View.GONE);
//                                    }
//                                }
//                            }else{
//                                if(mRecyclerView.getChildAt(position) != null) {
//                                    mRecyclerView.getChildAt(position).setVisibility(View.GONE);
//                                }
//                            }
//                        }else{
//                            if(mRecyclerView.getChildAt(position) != null) {
//                                mRecyclerView.getChildAt(position).setVisibility(View.GONE);
//                            }
//                        }
//
//                    }else{
//                        if(mRecyclerView.getChildAt(position) != null) {
//                            mRecyclerView.getChildAt(position).setVisibility(View.VISIBLE);
//                        }
//                    }
//                    position++;
//                }



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
