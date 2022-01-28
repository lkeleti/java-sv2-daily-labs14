package week14.day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreetServiceTest {

    @Test
    void processData() {
        StreetService ss = new StreetService();
        Map<String, List<Integer>> streetsData = ss.processData(Path.of("src/test/resources/streets.txt"));
        System.out.println(streetsData);
        System.out.println(ss.numberOfEvenhousesByStreetName(streetsData,"Kossuth"));
        System.out.println(ss.numberOfEvenhousesByStreetName(streetsData,"Petofi"));
    }
}