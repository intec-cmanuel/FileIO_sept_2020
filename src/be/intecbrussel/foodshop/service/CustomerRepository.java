package be.intecbrussel.foodshop.service;

import be.intecbrussel.foodshop.data.CustomerDao;
import be.intecbrussel.foodshop.data.fileio.CustomerDaoImplDieter;
import be.intecbrussel.foodshop.data.fileio.CustomerDaoImplMaoui;
import be.intecbrussel.foodshop.data.fileio.CustomerDaoImplNeutron;
import be.intecbrussel.foodshop.data.fileio.CustomerDaoImplToDatabase;
import be.intecbrussel.foodshop.model.Customer;

public class CustomerRepository {
    CustomerDao customerDao = new CustomerDaoImplToDatabase();

    public void writeCustomer(Customer customer){
        customerDao.writeCustomer(customer);
    }

    public Customer readCustomer() {
        return customerDao.readCustomer();
    }
}
