package com.example.cattest.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cattest.Activities.ProfileDetailActivity;
import com.example.cattest.Models.Cat;
import com.example.cattest.Models.CatHolder;
import com.example.cattest.R;

import java.io.FilterReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<CatHolder>implements Filterable {
    ArrayList<Cat> catList;
    ArrayList<Cat> filteredCatList;
    ArrayList<Cat> catListAll;

    public SearchAdapter(ArrayList<Cat> catList){
        this.catList = catList;
        this.filteredCatList = new ArrayList<>();
        this.catListAll = new ArrayList<>(catList);
    }

    @Override
    public CatHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.catlist, parent, false);
        CatHolder catHolder = new CatHolder(view);
        return catHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull CatHolder holder, final int position) {
        if (filteredCatList.isEmpty()) {
            filteredCatList = catList;
        }
        final Cat catAtPosition = filteredCatList.get(position);

        holder.catName.setText(catAtPosition.getName());
        holder.catLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), ProfileDetailActivity.class);
                intent.putExtra("id",catAtPosition.getId());
                v.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        if (filteredCatList.isEmpty()) {
            return catList.size();
        } else {
            return filteredCatList.size();
        }
    }
    public void setData(ArrayList<Cat> catList) {
        this.catList = catList;
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    private Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering (CharSequence charSequence) {
                List<Cat> filteredCat = new ArrayList<>();
                if (charSequence.toString().isEmpty()) {
                    filteredCat.addAll(catListAll);
                } else {
                    for (Cat cat : catListAll) {
                        if (cat.getName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                            filteredCat.add(cat);
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredCatList;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                catList.clear();
                catList.addAll((Collection<? extends Cat>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }


