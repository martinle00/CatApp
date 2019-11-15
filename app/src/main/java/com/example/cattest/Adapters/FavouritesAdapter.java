package com.example.cattest.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cattest.Activities.ProfileDetailActivity;
import com.example.cattest.Models.Cat;
import com.example.cattest.Models.CatHolder;
import com.example.cattest.R;

import java.util.ArrayList;
import java.util.List;

public class FavouritesAdapter extends RecyclerView.Adapter<CatHolder> {
    ArrayList<Cat> favCat;
    Context context;

    public FavouritesAdapter(ArrayList<Cat> favCats) {
        this.favCat = favCats;
    }
    @Override
    public CatHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.catlist, parent, false);
        this.context = parent.getContext();
        CatHolder catHolder = new CatHolder(view);
        return catHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull CatHolder holder, int position) {
        final Cat favsAtPosition = favCat.get(position);
        holder.catName.setText(favsAtPosition.getName());
        holder.catLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProfileDetailActivity.class);
                intent.putExtra("catID",favsAtPosition.getId());
                v.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return favCat.size();
    }
    public void setData(ArrayList<Cat> newFavCat) {
        this.favCat = newFavCat;
    }
}

