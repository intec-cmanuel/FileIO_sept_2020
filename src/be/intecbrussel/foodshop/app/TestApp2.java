package be.intecbrussel.foodshop.app;

import be.intecbrussel.foodshop.model.Customer;
import be.intecbrussel.foodshop.service.CustomerRepository;

public class TestApp2 {
    public static void main(String[] args) {
        CustomerRepository cr = new CustomerRepository();
        Customer jeanJaque = new Customer("Jean Jacques", 12, "JeanJacqueMetEenC@msn.be", 10);

        cr.writeCustomer(jeanJaque);
    }
}
