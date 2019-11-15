package com.example.cattest.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.cattest.Models.CatDetail;
import com.example.cattest.Models.Cat;
import com.example.cattest.Models.CatDatabase;
import com.example.cattest.Models.CatWeight;
import com.example.cattest.Models.FavouritesDatabase;
import com.example.cattest.R;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ProfileDetailActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView descTextView;
    private TextView weightTextView;
    private TextView lifeTextView;
    private TextView originTextView;
    private TextView dogTextView;
    private TextView wikiTextView;
    private TextView tempTextView;
    private ImageView imageView;
    private Button favButton;


    Cat loadedCat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);

        Intent intent = getIntent();
        String catID = intent.getStringExtra("id");
        final Cat cat = CatDatabase.getCatById(catID);


        nameTextView = findViewById(R.id.catName);
        descTextView = findViewById(R.id.catDescription);
        weightTextView = findViewById(R.id.catWeight);
        lifeTextView = findViewById(R.id.catLife);
        originTextView = findViewById(R.id.catOrigin);
        dogTextView = findViewById(R.id.catDog);
        wikiTextView = findViewById(R.id.catWiki);
        tempTextView = findViewById(R.id.catTemp);
        imageView = findViewById(R.id.catPhoto);
        favButton = findViewById(R.id.favButton);


        String api = "86e71a6c-8aae-4afc-a6f1-6e9c1b37b9de";
        String url = "https://api.thecatapi.com/v1/images/search?breed_id="+catID;

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                CatDetail[] catDetailArray = gson.fromJson(response, CatDetail[].class);
                ArrayList<CatDetail> catDetailArrayList = new ArrayList<>(Arrays.asList(catDetailArray));
                CatDetail catDetailObject = catDetailArrayList.get(0);
                Cat[] catArrayObject = catDetailObject.getBreeds();
                ArrayList<Cat> catArrayListObject = new ArrayList<>(Arrays.asList(catArrayObject));
                Cat catObject = catArrayListObject.get(0);


                nameTextView.setText(catObject.getName());
                descTextView.setText(catObject.getDescription());
                weightTextView.setText(catObject.getWeight() + " kg");
                lifeTextView.setText(catObject.getLifeSpan() + " years");
                originTextView.setText(catObject.getOrigin());
                dogTextView.setText(catObject.getDogFriendly());
                wikiTextView.setText(catObject.getWiki());
                tempTextView.setText(catObject.getTemperament());
                Glide.with(getApplicationContext()).load(catDetailObject.getUrl()).into(imageView);

            }
        };
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavouritesDatabase.addToFavs(loadedCat);
                Toast.makeText(getApplicationContext(), "Added to Favourites", Toast.LENGTH_SHORT).show();
            }
        });
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                requestQueue.stop();
            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        requestQueue.add(stringRequest);

    }


}
