package be.intecbrussel.fileiodemo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadData {
    public String readStringFromFile() {
        File file = new File("resources/MyTextFile.txt");

        try {
            FileReader fileReader = new FileReader(file);

            int character;
            while((character = fileReader.read()) != -1){
                System.out.print((char) character);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void readStringFromFile2() {
        File file = new File("resources/MyTextFile.txt");

        try {
            InputStream inputStream = new FileInputStream(file);

            int character;
            while((character = inputStream.read()) != -1){
                System.out.print((char) character);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //TODO Fix this potato mess
    public List<Animal> readAllAnimalsFromFile() {
        List<Animal> animalList = new ArrayList<>();
        ObjectInputStream ois = null;

        try {

            File myObjectFile = new File("resources/MyObjectFile.txt");
            FileInputStream fis = new FileInputStream(myObjectFile);
            ois = new ObjectInputStream(fis);

            while ( true ) {
                animalList.add((Animal) ois.readObject());
            }


        } catch (EOFException e ) {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }

        return animalList;
    }
}
