package com.example.picture_match;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class GridAdapter extends BaseAdapter
{
    Grid_page grid_page;
    public GridAdapter(Grid_page grid_page) {
        this.grid_page = grid_page;
    }

    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(grid_page).inflate(R.layout.grid_item,parent,false);

        return convertView;
    }
}
