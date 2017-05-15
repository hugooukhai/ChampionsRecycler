package com.example.adminpc.championsrecycler.Controler;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adminpc.championsrecycler.ChampionRecyclerApplication;
import com.example.adminpc.championsrecycler.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by H on 13/05/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<String> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView mImageView;
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mImageView = (ImageView) v.findViewById(R.id.champView);
            mTextView = (TextView) v.findViewById(R.id.cptTV);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<String> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.mImageView.setImageBitmap(mDataset.get(position));
        //Ion.with(holder.mImageView).load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/"+mDataset.get(position)+"_0.jpg");
        Picasso.with(ChampionRecyclerApplication.getContext()).load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/"+mDataset.get(position)+"_0.jpg").into(holder.mImageView);

        holder.mTextView.setText(""+position + mDataset.get(position));
        Log.d("Champ", ""+position+ "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/"+mDataset.get(position)+"_0.jpg");
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

