package com.example.cattest.Models;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Cat {

    String id;
    String name;
    String description;
    String origin;
    String temperament;
    @SerializedName("wikipedia_url")
    String wiki;
    @SerializedName("dog_friendly")
    String dogFriendly;
    @SerializedName("weight_imperial")
    CatWeight weight;
    @SerializedName("life_span")
    String lifeSpan;
    @SerializedName("url")
    String image;

    public boolean favourite;

    public Cat(String id, String name, String description, String origin, String temperament,
               String wiki, String dogFriendly, CatWeight weight, String lifeSpan) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.temperament = temperament;
        this.origin = origin;
        this.lifeSpan = lifeSpan;
        this.dogFriendly = dogFriendly;
        this.weight = weight;
        this.lifeSpan = lifeSpan;
        this.wiki = wiki;

    }
    public boolean isFavourite() {
        return favourite;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getTemperament(){
        return temperament;
    }
    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }
    public String getWiki(){
        return wiki;
    }
    public void setWiki(String wiki) {
        this.wiki = wiki;
    }
    public String getDogFriendly(){
        return dogFriendly;
    }
    public void setDogFriendly(String dogFriendly) {
        this.dogFriendly = dogFriendly;
    }
    public CatWeight getWeight(){
        return weight;
    }
    public void setMetric(CatWeight weight) {
        this.weight = weight;
    }
    public String getOrigin(){
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getLifeSpan(){
        return lifeSpan;
    }
    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }
    public String getImage(){
        return image;
    }

}