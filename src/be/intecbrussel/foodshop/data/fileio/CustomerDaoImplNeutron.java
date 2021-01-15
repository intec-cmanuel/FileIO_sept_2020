package be.intecbrussel.foodshop.data.fileio;

import be.intecbrussel.foodshop.config.FilePaths;
import be.intecbrussel.foodshop.data.CustomerDao;
import be.intecbrussel.foodshop.model.Customer;

import java.io.*;

public class CustomerDaoImplNeutron implements CustomerDao {
    private File customerFile = FilePaths.CUSTOMER_FILEPATH.getFile();

    @Override
    public Customer readCustomer() {

        try {
            InputStream inputStream = new FileInputStream(customerFile);
            StringBuilder customerOneLiner = new StringBuilder();
            int character;
            while((character = inputStream.read()) != -1) {
                customerOneLiner.append((char)character);
            }

            String[] customerData = String.valueOf(customerOneLiner).split(",");
            return new Customer(customerData[0], Integer.parseInt(customerData[1]), customerData[2], Double.parseDouble(customerData[3]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void writeCustomer(Customer customer) {
        try {
            FileWriter fileWriter = new FileWriter(FilePaths.CUSTOMER_FILEPATH.getFile(), false);
            fileWriter.write(customer.getName() + "," + customer.getID() + "," + customer.getEmail() + "," + customer.getMoney() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
