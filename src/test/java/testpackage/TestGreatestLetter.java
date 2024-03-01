package testpackage;

import com.practice.challenges.ArrayChallenges;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGreatestLetter {

    public static final ArrayChallenges a = new ArrayChallenges();

    @Test
    public void testNextGreatestLetter_binarySearch() {
        assertEquals('g', a.nextGreatestLetter_binarySearch(new char[]{'d','e','g','h','j','k'}, 'f'));
    }
    @Test
    public void testNextGreatestLetter_binarySearch3() {
        assertEquals('x', a.nextGreatestLetter_binarySearch(new char[]{'x', 'x', 'y', 'y'}, 'z'));
    }
    @Test
    public void testNextGreatestLetter_binarySearch4() {
        assertEquals('f', a.nextGreatestLetter_binarySearch(new char[]{'c', 'f', 'j'}, 'c'));
    }
    @Test
    public void testNextGreatestLetter_binarySearch2() { // target = y
        assertEquals('z', a.nextGreatestLetter_binarySearch(new char[]{'a','b','c','d','e','f','g','h','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}, 'y'));
    }
    @Test
    public void testNextGreatestLetter_binarySearch5() {
        assertEquals('g', a.nextGreatestLetter_binarySearch(new char[]{'a','b','c','d','e','g','h','j','k'}, 'f'));
    }
    @Test
    public void testNextGreatestLetter_binarySearch6() {
        assertEquals('c', a.nextGreatestLetter_binarySearch(new char[]{'c', 'f', 'j'}, 'a'));
    }


    @Test
    public void testNextGreatestLetter() {
        assertEquals('g', a.nextGreatestLetter(new char[]{'d','e','g','h','j','k'}, 'f'));
        assertEquals('g', a.nextGreatestLetter(new char[]{'a','b','c','d','e','g','h','j','k'}, 'f'));
        assertEquals('z', a.nextGreatestLetter(new char[]{'a','b','c','d','e','f','g','h','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}, 'y'));
        assertEquals('x', a.nextGreatestLetter(new char[]{'x', 'x', 'y', 'y'}, 'z'));
        assertEquals('c', a.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        assertEquals('f', a.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
    }

}
