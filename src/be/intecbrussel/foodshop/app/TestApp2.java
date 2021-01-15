package be.intecbrussel.foodshop.app;

import be.intecbrussel.foodshop.model.Customer;
import be.intecbrussel.foodshop.service.CustomerRepository;

public class TestApp2 {
    public static void main(String[] args) {
        CustomerRepository cr = new CustomerRepository();
        Customer jeanJaque = new Customer("JeanChocroutte", 12, "JeanCassoulet@bueno.estomac", 10);

        cr.writeCustomer(jeanJaque);

        Customer c2 = cr.readCustomer();
        System.out.println(c2);
    }
}
