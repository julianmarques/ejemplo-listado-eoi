package com.dinamicarea.ejemplolistado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivty extends AppCompatActivity {

    Button btnBooks;
    Button btnMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_activty);

        btnBooks = findViewById(R.id.btnBooks);
        btnMovies = findViewById(R.id.btnMoviews);

        btnBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(BooksActivity.class);
            }
        });

        btnMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(MoviesActivity.class);
            }
        });

    }

    private void navigateTo(Class<?> destination) {
        Intent intent = new Intent(MenuActivty.this, destination);
        startActivity(intent);
    }
}
