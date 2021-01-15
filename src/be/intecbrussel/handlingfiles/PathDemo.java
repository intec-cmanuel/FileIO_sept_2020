package be.intecbrussel.handlingfiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
    public static void main(String[] args) throws IOException {

        Path pathToMyTextFile = Paths.get("resources/MyTextFile.txt");
        System.out.println(pathToMyTextFile.getFileName());
        System.out.println(pathToMyTextFile.toAbsolutePath());
        System.out.println(pathToMyTextFile.isAbsolute());
        System.out.println(pathToMyTextFile.getFileSystem());
        System.out.println(pathToMyTextFile.getParent().resolve("subfolder").resolve("subfile.txt"));

        if (Files.notExists(Paths.get("resources/subfolder/jeanpierre"))) {
            Files.createDirectory(Paths.get("resources/subfolder/jeanpierre"));
        }


        Files.deleteIfExists(Paths.get("resources/subfolder/jeanpierre.txt"));

        if (Files.notExists(Paths.get("resources/subfolder/jeanpatapouffe.txt"))) {
            Files.createFile(Paths.get("resources/subfolder/jeanpatapouffe.txt"));
        }


        Path pathToWalk = Paths.get("resources");
        Files.walk(pathToWalk)
                .forEach(path -> System.out.println(path.toString()));

        Files.lines(Paths.get("resources/MyTextFile.txt"))
                .forEach(System.out::println);

        Path fileToCopy = Paths.get("resources/MyTextFile.txt");
        Path copyDestination = Paths.get("resources/MyCopiedTextFile.txt");

        //Files.copy(fileToCopy, copyDestination);

        Files.move(Paths.get("resources/hello.txt"), fileToCopy);


    }
}
