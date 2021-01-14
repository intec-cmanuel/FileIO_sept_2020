package be.intecbrussel.foodshop.app;

import be.intecbrussel.foodshop.exception.FoodAlreadyInStockException;
import be.intecbrussel.foodshop.exception.FoodNotInStockException;
import be.intecbrussel.foodshop.exception.NotEnoughFoodInStockException;
import be.intecbrussel.foodshop.exception.NotEnoughMoneyException;
import be.intecbrussel.foodshop.model.*;

import java.util.Map;

public class TestApp {
    public static void main(String[] args) {
        Stock stock = new Stock();
        FoodShop foodShop = new FoodShop(stock);
        Customer veryRichAndHungryPerson = new Customer("Manon", 1, "manonIsHungry@givefood.me", 90001);

        Food apple = new Food("Apple", 2, 5000, "Adam");
        Food pollo = new Food("Pollo", 4.7, 10, "zoogdieren en co.");
        Food pizza = new Food("Dominos", 10.5, 450, "Margarita");
        Food hamburger = new Food("KFC", 7.5, 500, "nuggets");
        Food patat = new Food("Patat", 3000, 0.1, "Manu & Anthony");

        addFood(stock, pizza);
        addFood(stock, patat);
        addFood(stock, apple);

        addToStock(stock, pizza, 10);
        addToStock(stock, patat, 5);
        addToStock(stock, apple, 1);

        Order myLittleOrder = new Order();
        myLittleOrder.addFoodToOrder(pizza, 2);
//        myLittleOrder.addFoodToOrder(hamburger, 28);
        myLittleOrder.addFoodToOrder(patat, 5);
        myLittleOrder.addFoodToOrder(apple, 0);

        System.out.println("════ Order ════");
        myLittleOrder.getFoodItems().forEach((food, amount) -> System.out.println(amount + " " + food));
        System.out.println();
        System.out.println("════ Stock ════");
        stock.getFoodStock().forEach((food, amount) -> System.out.println(amount + " " + food));
        System.out.println();

        myLittleOrder.applyDiscount(-50);

        try {
            foodShop.sellFood(myLittleOrder, veryRichAndHungryPerson);
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
            System.out.println("Maybe wait for your salary?");
        } catch (NotEnoughFoodInStockException notEnoughFoodInStockException) {
            System.out.println(notEnoughFoodInStockException.getMessage());
            System.out.println("Please wait until wednesday for the full restock.");
        } catch (FoodNotInStockException foodNotInStockException) {
            System.out.println(foodNotInStockException.getMessage());
            System.out.println("We don't have this item in our magnificent food shop!");
        }

        stock.getFoodStock().forEach((food, amount) -> System.out.println(amount + " " + food));
        System.out.println();

        System.out.println(veryRichAndHungryPerson.getMoney());
        System.out.println(foodShop.getRegisters().get(0).getMoney());
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
