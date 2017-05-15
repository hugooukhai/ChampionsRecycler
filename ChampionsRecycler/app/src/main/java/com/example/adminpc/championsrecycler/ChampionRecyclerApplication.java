package com.example.adminpc.championsrecycler;

import android.app.Application;
import android.content.Context;

/**
 * Created by adminPC on 15/05/2017.
 */

public class ChampionRecyclerApplication extends Application {
    private static ChampionRecyclerApplication instance;
public static Context getContext(){
    return instance.getApplicationContext();
}

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}

