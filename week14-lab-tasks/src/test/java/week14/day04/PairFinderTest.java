package week14.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void testPairFinder() {
        assertEquals(4, new PairFinder().findPairs( new int[]{7, 1, 5, 7, 3, 3, 5, 7, 6, 7}));
    }

}