package com.example.musictherapy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MusicActivity extends AppCompatActivity {

    RecyclerView rcv;
    RecycleAdapter rcvAdap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        Toolbar toolbar = findViewById(R.id.music_toolbar);
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setTitle("노래 감상하기");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        rcv = findViewById(R.id.recycler);
        LinearLayoutManager lm = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        lm.setReverseLayout(false);
        lm.setStackFromEnd(false);

        rcv.setLayoutManager(lm); //RecyclerView에 LayoutManager 지정

        rcvAdap = new RecycleAdapter(this);

        rcv.setAdapter(rcvAdap);


        rcvAdap.add(new CardModel(getString(R.string.video_url1), getString(R.string.video_title1),
                getString(R.string.video_length1)));
        rcvAdap.add(new CardModel(getString(R.string.video_url2), getString(R.string.video_title2),
                getString(R.string.video_length2)));
        rcvAdap.add(new CardModel(getString(R.string.video_url3), getString(R.string.video_title3),
                getString(R.string.video_length3)));
        rcvAdap.add(new CardModel(getString(R.string.video_url4), getString(R.string.video_title4),
                getString(R.string.video_length4)));
        rcvAdap.add(new CardModel(getString(R.string.video_url5), getString(R.string.video_title5),
                getString(R.string.video_length5)));
        rcvAdap.add(new CardModel(getString(R.string.video_url6), getString(R.string.video_title6),
                getString(R.string.video_length6)));
        rcvAdap.add(new CardModel(getString(R.string.video_url7), getString(R.string.video_title7),
                getString(R.string.video_length7)));
        rcvAdap.add(new CardModel(getString(R.string.video_url8), getString(R.string.video_title8),
                getString(R.string.video_length8)));
        rcvAdap.add(new CardModel(getString(R.string.video_url9), getString(R.string.video_title9),
                getString(R.string.video_length9)));
        rcvAdap.add(new CardModel(getString(R.string.video_url10), getString(R.string.video_title10),
                getString(R.string.video_length10)));
        rcvAdap.add(new CardModel(getString(R.string.video_url11), getString(R.string.video_title11),
                getString(R.string.video_length11)));


        RecycleClick.addRecycler(rcv).setOnItemClickListener(new RecycleClick.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = new Intent(
                        Intent.ACTION_VIEW ,
                        Uri.parse("https://www.youtube.com/watch?v="+rcvAdap.getItems().get(position).getUrl()));
                intent.setComponent(new ComponentName("com.google.android.youtube","com.google.android.youtube.PlayerActivity"));

                PackageManager manager = getApplicationContext().getPackageManager();
                List<ResolveInfo> infos = manager.queryIntentActivities(intent, 0);
                if (infos.size() > 0) {
                    getApplicationContext().startActivity(intent);
                }else{
                    Intent webIntent = new Intent(
                            Intent.ACTION_VIEW ,
                            Uri.parse("https://www.youtube.com/watch?v="+rcvAdap.getItems().get(position).getUrl()));
                    startActivity(webIntent);
                }
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
