package com.example.cattest.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cattest.Adapters.FavouritesAdapter;
import com.example.cattest.Models.FavouritesDatabase;
import com.example.cattest.R;

public class FavouritesRecyclerFragment extends Fragment {
    RecyclerView recyclerView;

    public FavouritesRecyclerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite_recycler, container,
                false);
        recyclerView = view.findViewById(R.id.rv_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        FavouritesAdapter favouritesAdapter = new FavouritesAdapter(FavouritesDatabase.getFavCats());
        recyclerView.setAdapter(favouritesAdapter);

        return view;
    }
}
