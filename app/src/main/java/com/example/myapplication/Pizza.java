package com.example.myapplication;

public class Pizza {
    private String name;
    private int imgId;

    public static final Pizza[] pizzas = {
            new Pizza("Mazzarella", R.drawable.pizza_mazzarella),
            new Pizza("4 Cheese", R.drawable.pizza_4cheese),
            new Pizza("Diavolo", R.drawable.diavolo)
    };

    private Pizza(String name, int imgId){
        this.name = name;
        this.imgId = imgId;
    }

    public String getName(){
        return this.name;
    }

    public int getImgId(){
        return this.imgId;
    }
}
