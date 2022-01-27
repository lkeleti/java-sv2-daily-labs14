package week14.day04;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PairFinder {
    public int findPairs(int[] arr) {
        Map<Integer, Integer> statistic = new TreeMap<>();
        for (int i : arr) {
            statistic.computeIfAbsent(i, s -> 0);
            statistic.put(i, statistic.get(i) + 1);
        }

        return statistic.values().stream()
                .mapToInt(i -> i/2)
                .sum();
    }
}
