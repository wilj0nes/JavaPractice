package testpackage;

import com.practice.leetcode.Challenges;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGreatestLetter {

    public static final Challenges c = new Challenges();

    @Test
    public void testNextGreatestLetter_binarySearch() {
        assertEquals('g', c.nextGreatestLetter_binarySearch(new char[]{'d','e','g','h','j','k'}, 'f'));
    }
    @Test
    public void testNextGreatestLetter_binarySearch3() {
        assertEquals('x', c.nextGreatestLetter_binarySearch(new char[]{'x', 'x', 'y', 'y'}, 'z'));
    }
    @Test
    public void testNextGreatestLetter_binarySearch4() {
        assertEquals('f', c.nextGreatestLetter_binarySearch(new char[]{'c', 'f', 'j'}, 'c'));
    }
    @Test
    public void testNextGreatestLetter_binarySearch2() { // target = y
        assertEquals('z', c.nextGreatestLetter_binarySearch(new char[]{'a','b','c','d','e','f','g','h','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}, 'y'));
    }
    @Test
    public void testNextGreatestLetter_binarySearch5() {
        assertEquals('g', c.nextGreatestLetter_binarySearch(new char[]{'a','b','c','d','e','g','h','j','k'}, 'f'));
    }
    @Test
    public void testNextGreatestLetter_binarySearch6() {
        assertEquals('c', c.nextGreatestLetter_binarySearch(new char[]{'c', 'f', 'j'}, 'a'));
    }


    @Test
    public void testNextGreatestLetter() {
        assertEquals('g', c.nextGreatestLetter(new char[]{'d','e','g','h','j','k'}, 'f'));
        assertEquals('g', c.nextGreatestLetter(new char[]{'a','b','c','d','e','g','h','j','k'}, 'f'));
        assertEquals('z', c.nextGreatestLetter(new char[]{'a','b','c','d','e','f','g','h','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}, 'y'));
        assertEquals('x', c.nextGreatestLetter(new char[]{'x', 'x', 'y', 'y'}, 'z'));
        assertEquals('c', c.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        assertEquals('f', c.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
    }

}
