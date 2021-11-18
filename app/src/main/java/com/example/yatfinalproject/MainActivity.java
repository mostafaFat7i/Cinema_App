package com.example.yatfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout,new FilmsFragment()).commit();
        BottomNavigationView navigationView=findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(selectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment=null;

            switch (item.getItemId()){
                case R.id.films:
                    selectedFragment=new FilmsFragment();
                    break;
                case R.id.favorite:
                    selectedFragment=new FavoriteFragment();
                    break;
                case R.id.profile:
                    selectedFragment=new ProfileFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout,selectedFragment).commit();
            return true;
        }
    };
}