package com.example.adminpc.championsrecycler.Model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by adminPC on 12/05/2017.
 */

public class Champion {


    public String key;


    public Champion(String key){

       this.key = key;
    }

    public static ArrayList<String> createListOfChamps(){

                Log.d("CreateList", "Created");
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url("https://euw1.api.riotgames.com/lol/static-data/v3/champions?dataById=true&api_key=RGAPI-c403c4b2-58d9-42b3-a9a9-e22189cf3584").build();
                Gson gson = new Gson();
                try {
                    Response response = client.newCall(request).execute();
                    ChampionResponse championResponse = gson.fromJson(response.body().string(), ChampionResponse.class);
                   // Map<String, Champion> champions = new HashMap<>();
                    ArrayList<String> champions = new ArrayList<>();
//                    for(Map<String, Champion> m: map.get("data")){
//                        for(String key: m.keySet()){
//                           // champions.put(key, m.get(key));
//                            champions.add(m.get(key).key);
//                        }
//                    }
                    //JSONObject champsJson = new JSONObject(response.body().string()).getJSONObject("data");


                    for(String key : championResponse.data.keySet()){
                        champions.add(championResponse.data.get(key).key);
                    }
                    return champions;

                } catch (IOException e) {
                    e.printStackTrace();
                }
       return null;
    }

    public String getKey(){
        return this.key;
    }
}
