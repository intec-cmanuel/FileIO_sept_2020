package be.intecbrussel.foodshop.data.fileio;

import be.intecbrussel.foodshop.config.FilePaths;
import be.intecbrussel.foodshop.data.CustomerDao;
import be.intecbrussel.foodshop.model.Customer;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CustomerDaoImplDieter implements CustomerDao {
    public Customer readCustomer() {
        try {
            FileReader reader = new FileReader(FilePaths.CUSTOMER_FILEPATH.getFile());
            int character;
            StringBuilder customerString = new StringBuilder();
            while((character = reader.read()) != -1){
                customerString.append((char) character);
            }
            String[] constructorInput = customerString.toString().split(",");
            return new Customer(constructorInput[0], Integer.parseInt(constructorInput[1]), constructorInput[2], Double.parseDouble(constructorInput[3]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeCustomer(Customer customer) {
        StringBuilder sb = new StringBuilder();
        sb.append(customer.getName()).append(",")
                .append(customer.getID()).append(",")
                .append(customer.getEmail()).append(",")
                .append(customer.getMoney());

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FilePaths.CUSTOMER_FILEPATH.getFile(), false))){
            bufferedWriter.write(sb.toString());

        } catch (IOException ex){
            System.out.println("Oops, something went wrong!");
            System.out.println(ex.getMessage());
        }
    }
}
