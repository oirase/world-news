package com.example.worldnews;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton myFavoriteButton = findViewById(R.id.my_favorite_button);
        myFavoriteButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MyFavorites.class);
            startActivity(intent);
        });


    }
}