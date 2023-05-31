package com.example.picture_match;

import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends BaseAdapter
{
    Grid_page grid_page;
    List<String> arrayList=new ArrayList<>();
    TextView countdown;
    private long delaytime;
    private Runnable runnable;


    public GridAdapter(Grid_page grid_page, List<String> arrayList, TextView countdown) {
        this.grid_page = grid_page;
        this.arrayList=arrayList;
        this.countdown=countdown;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
        int click=1,pos1=0,pos2=0;
        convertView = LayoutInflater.from(grid_page).inflate(R.layout.grid_item,parent,false);
        ImageView imageView=convertView.findViewById(R.id.gridimg);
        InputStream inputStream=null;
        try {
            inputStream=grid_page.getAssets().open("images/"+ arrayList.get(position));
            Drawable drawable =Drawable.createFromStream(inputStream,null);
            imageView.setImageDrawable(drawable);
            inputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RelativeLayout relativeLayout=convertView.findViewById(R.id.relative);
        View mask=convertView.findViewById(R.id.mask);
        playGame(relativeLayout,mask);
        return convertView;

    }

    private void playGame(RelativeLayout relativeLayout, View mask) {
        new CountDownTimer(delaytime * 1000, 1000) {
            @Override
            public void onTick(long l) {
                int interval = (int) (l / 1000);
                countdown.setText("Time: " + interval + "/0");
            }

            @Override
            public void onFinish() {

                startGame(mask,relativeLayout);
            }
        };
    }

    private void startGame(View mask, RelativeLayout relativeLayout)
    {
        int interval=5000;
        Handler handler = new Handler();
        runnable = new Runnable() {
            public void run() {
                mask.setVisibility(View.VISIBLE);
            }
        };
        //handler.postAtTime(runnable, System.currentTimeMillis() + interval);
        handler.postDelayed(runnable, interval);
        relativeLayout.setOnClickListener(v -> {
            if (click == 1) {
                mask.setVisibility(View.INVISIBLE);
                pos1 = holder.getAdapterPosition();
                firstview = holder.view1;
                click = 3;

                runnable = new Runnable() {
                    public void run() {
                        click = 2;
                    }
                };
                handler.postAtTime(runnable, System.currentTimeMillis() + interval);
                handler.postDelayed(runnable, 100);
                System.out.println("first click");
            }
            if (click == 2) {
                holder.view1.setVisibility(View.INVISIBLE);
                pos2 = holder.getAdapterPosition();
                click = 3;
                System.out.println("second click");
                if (imgArr.get(pos1).equals(imgArr.get(pos2))) {
                    System.out.println("match");
                    runnable = new Runnable() {
                        public void run() {
                            click = 1;
                        }
                    };
                    handler.postAtTime(runnable, System.currentTimeMillis() + interval);
                    handler.postDelayed(runnable, 500);
                } else {
                    System.out.println("not match");
                    runnable = new Runnable() {
                        public void run() {
                            holder.view1.setVisibility(View.VISIBLE);
                            firstview.setVisibility(View.VISIBLE);
                            click = 1;
                        }
                    };
                    handler.postAtTime(runnable, System.currentTimeMillis() + interval);
                    handler.postDelayed(runnable, 500);
                }
            }
        });
    }
    }

}
