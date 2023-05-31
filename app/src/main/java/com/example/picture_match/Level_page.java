package com.example.picture_match;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Level_page extends AppCompatActivity
{
    ListView listView;
    ListAdapter adapter;
    int[] levelno = {1,2,3,4,5,6,7,8,9,10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_page);

        listView = findViewById(R.id.listview);
        adapter = new ListAdapter(Level_page.this,levelno);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Level_page.this,Grid_page.class);
                startActivity(intent);
            }
        });
    }
}
