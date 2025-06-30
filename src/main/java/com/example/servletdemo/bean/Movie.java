package com.example.servletdemo.bean;

public class Movie {
    private int id;
    private String title;
    private String director;
    private String genre;
    private int release_year;
    private String description;

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getRelease_year() { return release_year; }
    public void setRelease_year(int release_year) { this.release_year = release_year; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
