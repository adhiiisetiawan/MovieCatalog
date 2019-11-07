package com.example.moviecaatalog;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_FILM = "film";

    TextView judulDetail,genre,txtoverview, txtCrew, txtLanguage, txtRuntime;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        judulDetail = findViewById(R.id.judul_detail);
        genre = findViewById(R.id.detail_genre);
        image = findViewById(R.id.detail_cover);
        txtoverview = findViewById(R.id.overview);
        txtCrew = findViewById(R.id.detail_crew);
        txtLanguage = findViewById(R.id.detail_language);
        txtRuntime = findViewById(R.id.detail_runtime);


        Film film = getIntent().getParcelableExtra(EXTRA_FILM);
        String textJudul = film.getTitle();
        String textGenre = film.getGenre();
        int photo = film.getCover();
        String dataOverview = film.getOverview();
        String textCrew = film.getFeaturedCrew();
        String textLanguage = film.getOriLanguage();
        String textRuntime = film.getRuntime();

        image.setImageResource(photo);
        judulDetail.setText(textJudul);
        genre.setText(textGenre);
        txtoverview.setText(dataOverview);
        txtCrew.setText(textCrew);
        txtLanguage.setText(textLanguage);
        txtRuntime.setText(textRuntime);
    }
}
