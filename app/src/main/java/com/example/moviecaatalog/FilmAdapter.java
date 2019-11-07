package com.example.moviecaatalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Film> films;

    public FilmAdapter(Context context) {
        this.context = context;
        films = new ArrayList<>();
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int position) {
        return films.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_film, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(convertView);
        Film film = (Film) getItem(position);
        viewHolder.bind(film);
        return convertView;
    }

    private class ViewHolder{
        private TextView txtJudul, txtGenre;
        private ImageView imageCover;

        ViewHolder(View view){
            txtJudul = view.findViewById(R.id.text_judul);
            txtGenre = view.findViewById(R.id.text_genre);
            imageCover = view.findViewById(R.id.image_cover);
        }

        void bind(Film film){
            txtJudul.setText(film.getTitle());
            txtGenre.setText(film.getGenre());
            imageCover.setImageResource(film.getCover());
        }
    }
}
