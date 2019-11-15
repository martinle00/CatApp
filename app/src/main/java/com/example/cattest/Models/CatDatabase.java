package com.example.cattest.Models;

import java.util.HashMap;
import java.util.List;

public class CatDatabase {
    public static HashMap<String, Cat> cats = new HashMap<>();
    public static HashMap<String, Cat> favourites = new HashMap<>();

    public static Cat getCatById(String catID) {
        return cats.get(catID);
    }

    public static List<Cat> getAllCats() {
        return (List) cats.values();
    }

    public static List<Cat> getAllFavourites() {
        return (List) cats.values();
    }

    public static void saveCatstoCatsDatabase(List<Cat> catsToSave) {
        for (int i = 0; i < catsToSave.size(); i++) {
            Cat cat = catsToSave.get(i);
            cats.put(cat.getId(), cat);
        }
    }
}