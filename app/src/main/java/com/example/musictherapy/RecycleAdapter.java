package com.example.musictherapy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.koushikdutta.ion.Ion;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleHolder> {

    //Main2 탭의 RecyclerView Adapter

    List<CardModel> items = new ArrayList<>(); //RecyclerView에 들어갈 아이템 저장 ArrayList 선언

    public List<CardModel> getItems() {
        return items;
    } //List의 아이템을 반환하는 함수

    Context context;

    public RecycleAdapter(Context context) {
        this.context = context;
    }

    public void add(CardModel data) { //리스트에 값을 추가하는 함수
        items.add(data); //리스트에 양식으로 전달받은 값 추가
        notifyDataSetChanged(); //RecyclerView 갱신
    }

    @NonNull
    @Override
    public RecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_youtube, parent, false);
        return new RecycleHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecycleHolder holder, final int position) {

        CardModel item = items.get(position);

        Ion.with(holder.thumb).load("https://img.youtube.com/vi/"+item.getUrl()+"/default.jpg");

        holder.title.setText(item.getName());
        holder.length.setText(item.getLength());


    }

    @Override
    public int getItemCount() {
        return items.size(); //리스트 크기 반환
    }


}
