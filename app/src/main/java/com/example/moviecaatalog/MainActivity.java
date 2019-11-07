package com.example.moviecaatalog;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataJudul;
    private String[] dataGenre, dataOverview, dataFeaturedCrew, dataLanguage, dataRuntime;
    private TypedArray dataCover;
    private FilmAdapter adapter;
    private ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        prepare();
        addItem();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent move = new Intent(MainActivity.this, DetailActivity.class);
                move.putExtra(DetailActivity.EXTRA_FILM, films.get(position));
                startActivity(move);

            }
        });
    }

    private void addItem(){
        films = new ArrayList<>();

        for (int i = 0; i < dataJudul.length ; i++) {
            Film film = new Film();
            film.setCover(dataCover.getResourceId(i,-1));
            film.setTitle(dataJudul[i]);
            film.setGenre(dataGenre[i]);
            film.setOverview(dataOverview[i]);
            film.setFeaturedCrew(dataFeaturedCrew[i]);
            film.setOriLanguage(dataLanguage[i]);
            film.setRuntime(dataRuntime[i]);
            films.add(film);
        }
        adapter.setFilms(films);
    }

    private void prepare(){
        dataJudul = getResources().getStringArray(R.array.data_judul);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataCover = getResources().obtainTypedArray(R.array.data_cover);
        dataFeaturedCrew = getResources().getStringArray(R.array.data_crew);
        dataLanguage = getResources().getStringArray(R.array.data_language);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataOverview = getResources().getStringArray(R.array.data_overview);

    }

}
