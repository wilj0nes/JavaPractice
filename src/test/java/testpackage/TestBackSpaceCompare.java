package testpackage;

import com.practice.challenges.ArrayChallenges;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestBackSpaceCompare {
    public static final ArrayChallenges a = new ArrayChallenges();

    @Test
    public void testBackSpaceCompare1() {
        assertTrue(a.backSpaceCompare("ab#c", "ad#c"));
    }
    @Test
    public void testBackSpaceCompare2() {
        assertTrue(a.backSpaceCompare("ab##", "c#d#"));
    }
    @Test
    public void testBackSpaceCompare3() {
        assertFalse(a.backSpaceCompare("a#c", "b"));
    }
    @Test
    public void testBackSpaceCompare4() {
        assertTrue(a.backSpaceCompare("a##c", "#a#c"));
    }
    @Test
    public void testBackSpaceCompare5() {
        assertTrue(a.backSpaceCompare("", ""));
    }
}
