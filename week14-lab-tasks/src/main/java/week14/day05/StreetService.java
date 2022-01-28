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
        Map<String, List<Boolean>> streetsData = new TreeMap<>();
        for (Street street : streets) {
            streetsData.computeIfAbsent(street.getName(), i -> new ArrayList<>());
            streetsData.get(street.getName()).add(street.even);
        }
        return giveNumbersToHouse(streetsData);
    }

    private Map<String, List<Integer>> giveNumbersToHouse(Map<String, List<Boolean>> streetsData) {
        Map<String, List<Integer>> streetWithHouseNumbers = new TreeMap<>();
        for (String key : streetsData.keySet()) {
            streetWithHouseNumbers.computeIfAbsent(key, i -> new ArrayList<>());
            giveNumersInaStreet(streetWithHouseNumbers, streetsData.get(key), key);
        }
        return streetWithHouseNumbers;
    }

    private void giveNumersInaStreet(Map<String, List<Integer>> streetWithHouseNumbers, List<Boolean> values, String key) {
        int evenNumber = 2;
        int oddNumber = 1;
        int number;
        for (Boolean value : values) {
            if (value) {
                number = evenNumber;
                evenNumber += 2;
            } else {
                number = oddNumber;
                oddNumber += 2;
            }
            streetWithHouseNumbers.get(key).add(number);
        }
    }

    public long numberOfEvenhousesByStreetName(Map<String, List<Integer>> streets, String street) {
        return streets.get(street).stream()
                .mapToInt(i -> i)
                .filter(i -> i % 2 == 0)
                .count();
    }
}
