package com.example.moviecaatalog;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private int cover;
    private String title, overview, genre, featuredCrew, oriLanguage, runtime;

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFeaturedCrew() {
        return featuredCrew;
    }

    public void setFeaturedCrew(String featuredCrew) {
        this.featuredCrew = featuredCrew;
    }

    public String getOriLanguage() {
        return oriLanguage;
    }

    public void setOriLanguage(String oriLanguage) {
        this.oriLanguage = oriLanguage;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.cover);
        dest.writeString(this.title);
        dest.writeString(this.overview);
        dest.writeString(this.genre);
        dest.writeString(this.featuredCrew);
        dest.writeString(this.oriLanguage);
        dest.writeString(this.runtime);
    }

    public Film() {
    }

    protected Film(Parcel in) {
        this.cover = in.readInt();
        this.title = in.readString();
        this.overview = in.readString();
        this.genre = in.readString();
        this.featuredCrew = in.readString();
        this.oriLanguage = in.readString();
        this.runtime = in.readString();
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
