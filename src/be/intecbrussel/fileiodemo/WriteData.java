package be.intecbrussel.fileiodemo;

import java.io.*;

public class WriteData {
    File myObjectFile = new File("resources/MyObjectFile.txt");
    FileOutputStream fos = new FileOutputStream(myObjectFile, true);
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    public WriteData() throws IOException {
    }

    public void writeStringToFile(String myText) {
        File myTextFile = new File("resources/MyTextFile.txt");
//        File myTextFile = new File("E:\\OneDrive\\OneDrive - INTEC BRUSSEL vzw\\Intec\\Opleidingen\\Java September 2020\\Projects\\FileIO\\resources\\MyTextFile.txt");

        try (FileWriter fileWriter = new FileWriter(myTextFile, true)) {
            fileWriter.write(myText + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeObjectToFile(Animal animal) {

        try {
            oos.writeObject(animal);
//            oos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void closeStreams(){
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
