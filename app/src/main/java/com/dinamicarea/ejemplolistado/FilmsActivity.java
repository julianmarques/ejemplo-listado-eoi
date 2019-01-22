package com.dinamicarea.ejemplolistado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class FilmsActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);


        gridView = findViewById(R.id.gvFilm);

        ArrayList<Film> films = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Film film = new Film();
            film.setTitle("titulo asdasda asd asdasdad");
            film.setPosterUrl("https://image.tmdb.org/t/p/w185_and_h278_bestv2/xRMZikjAHNFebD1FLRqgDZeGV4a.jpg");
            films.add(film);
        }


        FilmAdapter adapter = new FilmAdapter(this, R.layout.film_list_item, films);

        gridView.setAdapter(adapter);

    }

}
