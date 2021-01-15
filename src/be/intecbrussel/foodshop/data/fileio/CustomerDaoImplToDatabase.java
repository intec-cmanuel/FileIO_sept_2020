package be.intecbrussel.foodshop.data.fileio;

import be.intecbrussel.foodshop.data.CustomerDao;
import be.intecbrussel.foodshop.model.Customer;

public class CustomerDaoImplToDatabase implements CustomerDao {
    @Override
    public Customer readCustomer() {
        // write code to read customer from a database
        return null;
    }

    @Override
    public void writeCustomer(Customer customer) {
        // write code to send customer to a database
    }
}
