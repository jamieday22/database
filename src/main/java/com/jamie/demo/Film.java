package com.jamie.demo;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film implements Serializable {

    @Id
    @GeneratedValue
    private int film_id;

    private String title;
    private String description;
    private int release_year;
    private String rating;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "film_actor",
            joinColumns = {
                    @JoinColumn(name = "film_id", referencedColumnName = "film_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id",
                            nullable = false, updatable = false)})
    private Set<Actor> actor = new HashSet<>();



    public Film(String title, int release_year, String rating, String description) {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.rating = rating;
    }

    public Set<Actor> getActor()
    {
        return actor;
    }

    public void setActor(Set<Actor> actor)
    {
        this.actor = actor;
    }



    ////////////////////////////////////////////
    public Film() {

    }
    ////////////////////////////////////////////



    public int getFilm_id() {
        return film_id;
    }



    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}


