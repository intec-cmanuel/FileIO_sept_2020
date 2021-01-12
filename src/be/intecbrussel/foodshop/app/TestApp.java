package be.intecbrussel.foodshop.app;

import be.intecbrussel.foodshop.exception.FoodAlreadyInStockException;
import be.intecbrussel.foodshop.exception.FoodNotInStockException;
import be.intecbrussel.foodshop.exception.NotEnoughFoodInStockException;
import be.intecbrussel.foodshop.model.Food;
import be.intecbrussel.foodshop.model.Stock;

import java.util.Map;

public class TestApp {
    public static void main(String[] args) {
        Stock stock = new Stock();

        Food apple = new Food("Apple");
        Food pollo = new Food("Pollo");
        Food pizza = new Food("Dominos"/*, "Margarita", 10.5, 450*/);
        Food hamburger = new Food("KFC"/*, "nuggets", 7.5, 500*/);
        Food patat = new Food("Patat");


    }

    private static void addFood(Stock stock, Food food) {
        try {
            stock.addFood(food);
        } catch (FoodAlreadyInStockException faise) {
            System.out.println(faise.getMessage());
        }
    }

    private static void addToStock(Stock stock, Food food, int amount){
        try {
            stock.addToStock(food, amount);
        } catch (FoodNotInStockException fnise) {
            System.out.println(fnise.getMessage());
        }
    }

    private static void removeFromStock(Stock stock, Food food, int amount) {
        try {
            stock.removeFromStock(food, amount);
        } catch (NotEnoughFoodInStockException nefise) {
            System.out.println(nefise.getMessage());
            System.out.println("You need to order more !");
        } catch (FoodNotInStockException fnise) {
            System.out.println(fnise.getMessage());
            System.out.println("You need to create a stock !");
        }
    }

    private static void print(Stock stock) {
        Map<Food, Integer> foodStock = stock.getFoodStock();
        System.out.println("------FOOD STOCK-----");
        for (Food food : foodStock.keySet()) {
            System.out.println(food.getName() + " - " + foodStock.get(food));
        }
        System.out.println("---------------------");
    }
}
