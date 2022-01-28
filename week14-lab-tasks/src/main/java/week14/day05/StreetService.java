package week14.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StreetService {
    class Street {
        private String name;
        private boolean even;

        public Street(String name, boolean even) {
            this.name = name;
            this.even = even;
        }

        public String getName() {
            return name;
        }

        public boolean isEven() {
            return even;
        }
    }

    private List<Street> streets = new ArrayList<>();

    private void readFromFile(Path path) {
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datas = line.split(" ");
                streets.add(new Street(datas[0], datas[1].equals("0")));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read from file");
        }
    }

    public Map<String, List<Integer>> processData(Path path) {
        readFromFile(path);
        Map<String, List<Integer>> streetsData = new TreeMap<>();
        int evenNumber = 2;
        int oddNumber = 1;
        int number;
        for (Street street: streets) {
            if (street.isEven()) {
                number = evenNumber;
                evenNumber += 2;
            }
            else {
                number = oddNumber;
                oddNumber += 2;
            }
            streetsData.computeIfAbsent(street.getName(), i -> new ArrayList<>());
            streetsData.get(street.getName()).add(number);
        }
        return streetsData;
    }
}
