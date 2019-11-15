package com.example.cattest.Models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FavouritesDatabase {

    public static HashMap<String, Cat> favCatsMap;

    static {
        favCatsMap = new HashMap<>();
    }

    public static ArrayList<Cat> getFavCats(){
        ArrayList<Cat> favCatsArray = new ArrayList<>();
        for (Map.Entry<String, Cat> favCat : favCatsMap.entrySet()) {
            favCatsArray.add(favCat.getValue());
        }
        return favCatsArray;
    }

    public static void addToFavs(Cat newCat) {
        String catID = newCat.getId();
        if (!favCatsMap.containsKey(catID)) {
            favCatsMap.put(catID, newCat);
            System.out.println("Cat has been added!");
        } else {
            System.out.println("Cat has already been added");
        }
    }
}
