package com.example.worldnews;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;

import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Intent intent = new Intent(getApplicationContext(), Search.class);
        //startActivity(intent);
        /*
        ImageButton myFavoriteButton = findViewById(R.id.my_favorite_button);
        myFavoriteButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), Favourite.class);
            startActivity(intent);


        });
        */

        GetNews getNews = new GetNews();

        final Response response;
        final TextView textView = new TextView(this);

        try {
            response = getNews.doGet(getString(R.string.url));
            textView.setText(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //ConstraintLayout mainLayout = (ConstraintLayout)findViewById(R.id.main_layout);
        //mainLayout.add(textView);
        //setContentView(textView);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()) {
                    case R.id.home_tab:
                        startActivity(new Intent(getApplication(), MainActivity.class));
                        break;
                    case R.id.favourite_tab:
                        startActivity(new Intent(getApplication(), Favourite.class));
                        break;
                    case R.id.search_tab:
                        startActivity(new Intent(getApplication(), Search.class));
                        break;
                }
                return false;
            }
        });

    }
}