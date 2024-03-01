package testpackage;

import com.practice.challenges.StringChallenges;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestBackSpaceCompare {
    public static final StringChallenges s = new StringChallenges();

    @Test
    public void testBackSpaceCompare1() {
        assertTrue(s.backSpaceCompare("ab#c", "ad#c"));
    }
    @Test
    public void testBackSpaceCompare2() {
        assertTrue(s.backSpaceCompare("ab##", "c#d#"));
    }
    @Test
    public void testBackSpaceCompare3() {
        assertFalse(s.backSpaceCompare("a#c", "b"));
    }
    @Test
    public void testBackSpaceCompare4() {
        assertTrue(s.backSpaceCompare("a##c", "#a#c"));
    }
    @Test
    public void testBackSpaceCompare5() {
        assertTrue(s.backSpaceCompare("", ""));
    }
}
