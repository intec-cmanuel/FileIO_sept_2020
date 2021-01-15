package be.intecbrussel.fileiodemo;

import java.io.IOException;
import java.util.List;

public class TestApp3 {
    public static void main(String[] args) {
        Animal animal = new Animal("Lion", "Anthony", 100);
        Animal animal2 = new Animal("Crocodile", "Also Anthony? But Zebra this time", 30);

        try {
            WriteData wd = new WriteData();
            wd.writeObjectToFile(animal);
            wd.writeObjectToFile(animal2);
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }

        ReadData rd = new ReadData();
        List<Animal> animalsFromFile = rd.readAllAnimalsFromFile();
        animalsFromFile.forEach(System.out::println);
    }
}
