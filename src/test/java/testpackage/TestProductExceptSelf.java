package testpackage;

import com.practice.challenges.ArrayChallenges;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestProductExceptSelf {
    ArrayChallenges a = new ArrayChallenges();

    @Test
    public void testProductExceptSelf() {
        assertArrayEquals(new int[]{24,12,8,6}, a.productExceptSelf(new int[]{1,2,3,4}));
    }
    @Test
    public void testProductExceptSelf1() {
        assertArrayEquals(new int[]{0,0,9,0,0}, a.productExceptSelf(new int[]{-1,1,0,-3,3}));
    }
}
