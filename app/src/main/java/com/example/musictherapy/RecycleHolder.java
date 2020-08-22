package com.example.musictherapy;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecycleHolder extends RecyclerView.ViewHolder {

    //People 탭의 RecyclerView ViewHolder

    //TextView, ImageView 선언
    public TextView title, length;
    public ImageView thumb;

    //ViewHolder
    public RecycleHolder(View itemView) {
        super(itemView);
        //각 아이템들을 RecyclerView 아이템 뷰의 항목과 연결
        thumb = itemView.findViewById(R.id.item_thumb);
        title = itemView.findViewById(R.id.item_title);
        length = itemView.findViewById(R.id.item_length);
    }

}
