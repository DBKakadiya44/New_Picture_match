package com.example.picture_match;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter
{
    Level_page level_page;
    int[] levelno;

    public ListAdapter(Level_page level_page, int[] levelno) {
        this.level_page = level_page;
        this.levelno = levelno;
    }

    @Override
    public int getCount() {
        return levelno.length;
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

        convertView = LayoutInflater.from(level_page).inflate(R.layout.level_item,parent,false);

        TextView textView = convertView.findViewById(R.id.txtview);
        textView.setText("LEVEL "+levelno[position]);

        return convertView;
    }
}
