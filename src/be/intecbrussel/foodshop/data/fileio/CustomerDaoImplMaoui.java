package be.intecbrussel.foodshop.data.fileio;

import be.intecbrussel.foodshop.config.FilePaths;
import be.intecbrussel.foodshop.data.CustomerDao;
import be.intecbrussel.foodshop.model.Customer;

import java.io.FileWriter;
import java.io.IOException;

public class CustomerDaoImplMaoui implements CustomerDao {
    public void writeCustomer(Customer customer) {
        try {
            FileWriter fileWriter = new FileWriter(FilePaths.CUSTOMER_FILEPATH.getFile(), false);
            fileWriter.write(toDataBase(customer) + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String toDataBase(Customer customer) {
        return customer.getName()+","+ customer.getID() +","+ customer.getEmail() +","+ customer.getMoney();
    }

    public Customer readCustomer() {
        return null;
    }
}
