package testpackage;

import com.practice.challenges.singleChallengeClasses.LongestPalindrome;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLongestPalindrome {
    LongestPalindrome lp = new LongestPalindrome();

    @Test
    public void testLongestPalindrome() {
        assertEquals("bab", lp.longestPalindrome("babad"));
    }
}
