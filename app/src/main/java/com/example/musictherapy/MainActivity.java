package com.example.musictherapy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.CompoundButtonCompat;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.gelitenight.waveview.library.WaveView;

public class MainActivity extends AppCompatActivity {

    private WaveHelper mWaveHelper;

    private int mBorderColor = Color.parseColor("#44f16d7a");
    private int mBorderWidth = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WaveView waveView = findViewById(R.id.wave);
        waveView.setBorder(mBorderWidth, mBorderColor);

        mWaveHelper = new WaveHelper(waveView);

        waveView.setShapeType(WaveView.ShapeType.SQUARE);
        waveView.setWaveColor(
                Color.parseColor("#28f16d7a"),
                Color.parseColor("#3cf16d7a"));
        mBorderColor = Color.parseColor("#44f16d7a");
        waveView.setBorder(mBorderWidth, mBorderColor);

        TextView title_box = findViewById(R.id.title_text);
        Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade_in);
        animation.setStartOffset(1000);
        title_box.startAnimation(animation);

        LinearLayout start_box = findViewById(R.id.start_box);
        Animation animation2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade_in);
        animation2.setStartOffset(1500);
        start_box.startAnimation(animation2);

        TextView doc_box = findViewById(R.id.doc_btn);
        Animation animation3 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade_in);
        animation3.setStartOffset(2000);
        doc_box.startAnimation(animation);

        Button music = findViewById(R.id.music_btn);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MusicActivity.class));
            }
        });

        Button drum = findViewById(R.id.drum_btn);
        drum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DrumActivity.class));
            }
        });

        Button cello = findViewById(R.id.cello_btn);
        cello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CelloActivity.class));
            }
        });

        TextView doc = findViewById(R.id.doc_btn);
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DocActivity.class));
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        mWaveHelper.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWaveHelper.start();

        TextView title_box = findViewById(R.id.title_text);
        Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade_in);
        animation.setStartOffset(1000);
        title_box.startAnimation(animation);

        LinearLayout start_box = findViewById(R.id.start_box);
        Animation animation2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade_in);
        animation2.setStartOffset(1500);
        start_box.startAnimation(animation2);

        TextView doc_box = findViewById(R.id.doc_btn);
        Animation animation3 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade_in);
        animation3.setStartOffset(2000);
        doc_box.startAnimation(animation);
    }
}
