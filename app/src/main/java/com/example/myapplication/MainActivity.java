package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button musicButton;
    private Button videoButton;
    private Button mapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicButton = findViewById(R.id.musicButton);
        videoButton = findViewById(R.id.videoButton);
        mapButton = findViewById(R.id.mapButton);

        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMusicFragment();
            }
        });

        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVideoFragment();
            }

        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMapFragment();
            }
        });
    }

    private void openMusicFragment() {
        MusicFragment musicFragment = new MusicFragment();
        openFragment(musicFragment);
    }

    private void openVideoFragment() {
        VideoFragment videoFragment = new VideoFragment();
        openFragment(videoFragment);
    }

    private void openMapFragment() {
        MapFragment mapFragment = new MapFragment();
        openFragment(mapFragment);
    }

    private void openFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
