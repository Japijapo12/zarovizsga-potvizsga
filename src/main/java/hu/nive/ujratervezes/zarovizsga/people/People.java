package hu.nive.ujratervezes.zarovizsga.people;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class People {

    public int getNumberOfMales(String path) {
        Path file = Path.of(path);
        int sum = 0;
        try {
            List<String> line = Files.readAllLines(file);
            line.remove(0);
            for (String person : line) {
                String[] temp = person.split(",");

                if (temp.length == 6 && temp[4].equals("Male")) {
                    sum++;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file");
        }
        return sum;
    }


}
