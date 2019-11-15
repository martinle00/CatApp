package com.example.cattest.Models;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cattest.R;

public class CatHolder extends RecyclerView.ViewHolder {
    public TextView catName;
    public LinearLayout catLinear;

    public CatHolder(View view) {
        super(view);
        catName = view.findViewById(R.id.catName);
        catLinear = view.findViewById(R.id.catLinear);

    }
}
