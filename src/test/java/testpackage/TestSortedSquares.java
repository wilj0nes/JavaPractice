package testpackage;

import com.practice.challenges.ArrayChallenges;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestSortedSquares {
    public static final ArrayChallenges a = new ArrayChallenges();

    @Test
    public void testSortedSquares3() {
        assertArrayEquals(new int[]{0,1,9,16,100}, a.sortedSquares_betterRuntime(new int[]{-4,-1,0,3,10}));
    }
    @Test
    public void testSortedSquares4() {
        assertArrayEquals(new int[]{4,9,9,49,121}, a.sortedSquares_betterRuntime(new int[]{-7,-3,2,3,11}));
    }

    @Test
    public void testSortedSquares1() {
        assertArrayEquals(new int[]{0,1,9,16,100}, a.sortedSquares(new int[]{-4,-1,0,3,10}));
    }

    @Test
    public void testSortedSquares2() {
        assertArrayEquals(new int[]{4,9,9,49,121}, a.sortedSquares(new int[]{-7,-3,2,3,11}));
    }
}
