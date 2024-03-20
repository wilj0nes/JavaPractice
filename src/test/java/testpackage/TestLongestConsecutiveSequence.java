package testpackage;

import com.practice.challenges.ArrayChallenges;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLongestConsecutiveSequence {
    ArrayChallenges a = new ArrayChallenges();

    @Test
    public void testLongestConsecutiveSequence1() {
        assertEquals(4, a.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
    @Test
    public void testLongestConsecutiveSequence2() {
        assertEquals(9, a.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
    @Test
    public void testLongestConsecutiveSequence3() {
        assertEquals(1, a.longestConsecutive(new int[]{1}));
    }
    @Test
    public void testLongestConsecutiveSequence4() {
        assertEquals(1, a.longestConsecutive(new int[]{0}));
    }
    @Test
    public void testLongestConsecutiveSequence5() {
        assertEquals(0, a.longestConsecutive(new int[]{}));
    }
    @Test
    public void testLongestConsecutiveSequence6() {
        assertEquals(2, a.longestConsecutive(new int[]{0, -1}));
    }
}
