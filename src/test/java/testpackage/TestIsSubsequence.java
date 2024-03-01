package testpackage;

import com.practice.challenges.StringChallenges;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestIsSubsequence {
    StringChallenges s = new StringChallenges();

    @Test
    public void testIsSubSequence1() {
        assertTrue(s.isSubsequence("abc", "ahbgdc"));
    }
    @Test
    public void testIsSubSequence2() {
        assertFalse(s.isSubsequence("axc", "ahbgdc"));
    }
    @Test
    public void testIsSubSequence3() {
        assertTrue(s.isSubsequence("", ""));
    }
    @Test
    public void testIsSubSequence4() {
        assertTrue(s.isSubsequence(" ", " "));
    }

    @Test
    public void testIsSubSequence5() {
        assertTrue(s.isSubsequence_withPointers("abc", "ahbgdc"));
    }
    @Test
    public void testIsSubSequence6() {
        assertFalse(s.isSubsequence_withPointers("axc", "ahbgdc"));
    }
    @Test
    public void testIsSubSequence7() {
        assertTrue(s.isSubsequence_withPointers("", ""));
    }
    @Test
    public void testIsSubSequence8() {
        assertTrue(s.isSubsequence_withPointers(" ", " "));
    }

    @Test
    public void testIsSubSequence9() {
        assertTrue(s.isSubsequence_withPointers("", "ahbgdc"));
    }
    @Test
    public void testIsSubSequence10() {
        assertFalse(s.isSubsequence_withPointers("asfdafsd", ""));
    }
    @Test
    public void testIsSubSequence11() {
        assertTrue(s.isSubsequence_withPointers("b", "abc"));
    }

}





