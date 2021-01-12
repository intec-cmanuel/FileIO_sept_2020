package be.intecbrussel.foodshop.model;

import be.intecbrussel.foodshop.exception.FoodNotInStockException;
import be.intecbrussel.foodshop.exception.NotEnoughFoodInStockException;
import be.intecbrussel.foodshop.exception.NotEnoughMoneyException;
import be.intecbrussel.foodshop.service.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FoodShop {
    private List<Register> registers;
    private Stock stock;
    private CustomerRepository customerRepository;

    public FoodShop() {
        this.registers = new ArrayList<>();
        registers.add(new Register());
    }

    public List<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(List<Register> registers) {
        this.registers = registers;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Map<Food, Integer> sellFood(Order order, Customer payingCustomer){
        // check if all food is available


        // calculate the total order price and check if customer has enough money
        double totalPrice = order.getTotalPrice();
        double moneyInHand = payingCustomer.getMoney() - totalPrice;
        if (moneyInHand < 0){
            throw new NotEnoughMoneyException();
        }

        // remove order from stock
        for (Map.Entry<Food, Integer> entry : order.getFoodItems().entrySet()) {
            Food food = entry.getKey();
            Integer amount = entry.getValue();
            try {
                stock.removeFromStock(food, amount);
            } catch (NotEnoughFoodInStockException notEnoughFoodInStockException) {
                // Should never trigger because we checked already
                notEnoughFoodInStockException.printStackTrace();
            } catch (FoodNotInStockException foodNotInStockException) {
                // Should never trigger because we checked already
                foodNotInStockException.printStackTrace();
            }
        }

        // update the money of customer
        payingCustomer.setMoney(moneyInHand);

        // add money to register (In which register will I add money ???)
        // TODO Register -> multithreading
        registers.get(0).addMoney(totalPrice);

        return order.getFoodItems();
    }
}
