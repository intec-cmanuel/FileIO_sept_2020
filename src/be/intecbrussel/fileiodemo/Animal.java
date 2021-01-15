package be.intecbrussel.fileiodemo;

import java.io.Serializable;

public class Animal implements Serializable {
    private String name;
    private String favoriteFood;
    private double weight;

    public Animal(String name, String favoriteFood, double weight) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                ", weight=" + weight +
                '}';
    }
}
