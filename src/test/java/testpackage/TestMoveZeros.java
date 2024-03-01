package testpackage;

import com.practice.challenges.ArrayChallenges;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestMoveZeros {
    ArrayChallenges a = new ArrayChallenges();

    @Test
    public void testConstruct2DArray() {
        assertArrayEquals(new int[]{1,3,12,0,0}, a.moveZeros(new int[]{0,1,0,3,12}));
    }

    @Test
    public void testConstruct2DArray2() {
        assertArrayEquals(new int[]{0}, a.moveZeros(new int[]{0}));
    }
    @Test
    public void testConstruct2DArray3() {
        assertArrayEquals(null, a.moveZeros(null));
    }
    @Test
    public void testConstruct2DArray4() {
        assertArrayEquals(new int[]{4,2,4,3,5,1,0,0,0,0}, a.moveZeros(new int[]{4,2,4,0,0,3,0,5,1,0}));
    }

    @Test
    public void testConstruct2DArray5() {
        assertArrayEquals(new int[]{1,3,12,0,0}, a.moveZeros_betterTimeComplexity(new int[]{0,1,0,3,12}));
    }

    @Test
    public void testConstruct2DArray6() {
        assertArrayEquals(new int[]{0}, a.moveZeros_betterTimeComplexity(new int[]{0}));
    }
    @Test
    public void testConstruct2DArray7() {
        assertArrayEquals(null, a.moveZeros_betterTimeComplexity(null));
    }
    @Test
    public void testConstruct2DArray8() {
        assertArrayEquals(new int[]{4,2,4,3,5,1,0,0,0,0}, a.moveZeros_betterTimeComplexity(new int[]{4,2,4,0,0,3,0,5,1,0}));
    }


}
