package com.example.cattest.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cattest.Adapters.SearchAdapter;
import com.example.cattest.Models.Cat;
import com.example.cattest.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


public class SearchRecyclerFragment extends Fragment {
    RecyclerView recyclerView;
    SearchView catSearch;
    SearchAdapter searchAdapter;

    public SearchRecyclerFragment() {
    // Empty constructor required
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       final View view = inflater.inflate(R.layout.fragment_search_recycler, container, false);


        String API = "86e71a6c-8aae-4afc-a6f1-6e9c1b37b9de";
        String url = "https://api.thecatapi.com/v1/breeds?api_key=" + API;
    // Using volley to obtain data returned from api
        final RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Cat[] catArray = gson.fromJson(response,Cat[].class);
                ArrayList<Cat> catList = new ArrayList<>(Arrays.asList(catArray));

                recyclerView = view.findViewById(R.id.rv_main);
                LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                recyclerView.setLayoutManager(layoutManager);
                searchAdapter = new SearchAdapter(catList);
                recyclerView.setAdapter(searchAdapter);

                catSearch = view.findViewById(R.id.nav_search);
                //search(catSearch);

            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("The request failed: " + error.getMessage());
            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener,
                errorListener);
        requestQueue.add(stringRequest);

        return view;
    }
    //
    // Code for search functionality, but doesn't work for some reason
    //
    /*private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchAdapter.getFilter().filter(query);
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchAdapter.getFilter().filter(newText);
                return false;
            }
        });
    */
}

