package com.jamie.demo;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;
    private int language_id;
    private String title;
    private String description;
    private int release_year;
    private String rating;

    @ManyToOne
    @JoinColumn(name = "language_id", insertable = false, updatable = false)
    private Language language;

    private Integer original_language_id;
    @ManyToOne
    @JoinColumn(name = "original_language_id", insertable = false, updatable = false)
    private Language original_language;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "film_actor",
            joinColumns = {
                    @JoinColumn(name = "film_id", referencedColumnName = "film_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id",
                            nullable = false, updatable = false)})
    private Set<Actor> actor = new HashSet<>();



    public Film(String title,String description, int release_year, String rating , int language_id ) {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.rating = rating;
        this.language_id = language_id;
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

    public int getLanguage_id()
    {
        return language_id;
    }

    public void setLanguage_id(int language_id)
    {
        this.language_id = language_id;
    }

    public Integer getOriginal_language_id()
    {
        return original_language_id;
    }

    public void setOriginal_language_id(Integer original_language_id)
    {
        this.original_language_id = original_language_id;
    }

    public Language getOriginal_language()
    {
        return original_language;
    }

    public void setOriginal_language(Language original_language)
    {
        this.original_language = original_language;
    }

    public Language getLanguage()
    {
        return language;
    }

    public void setLanguage(Language language)
    {
        this.language = language;
    }
}



