package com.example.picture_match;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class Grid_page extends AppCompatActivity
{
    GridView gridView;
    GridAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_page);

        gridView = findViewById(R.id.gridview);
        adapter = new GridAdapter(Grid_page.this);
        gridView.setAdapter(adapter);
    }
}
