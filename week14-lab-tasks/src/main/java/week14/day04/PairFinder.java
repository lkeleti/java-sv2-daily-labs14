package week14.day04;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PairFinder {
    public int findPairs(List<Integer> arr) {
//        Map<Integer, Integer> statistic = new TreeMap<>();
//        for (int i : arr) {
//            statistic.computeIfAbsent(i, s -> 0);
//            statistic.put(i, statistic.get(i) + 1);
//        }

        return arr.stream()
                .collect(Collectors.groupingBy(Integer::intValue,Collectors.counting()))
                .values()
                .stream()
                .mapToInt(i -> i.intValue()/2)
                .sum();
    }
}
