package testpackage;

import com.practice.challenges.ArrayChallenges;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestConstruct2DArray {

    ArrayChallenges a = new ArrayChallenges();

    @Test
    public void testConstruct2DArray() {
        int[][] matrix = new int[2][];
        int[] ar1, ar2;

        ar1 = new int[]{1, 2};
        ar2 = new int[]{3, 4};

        matrix[0] = ar1;
        matrix[1] = ar2;

        assertArrayEquals(matrix, a.construct2DArray(new int[]{1,2,3,4}, 2, 2));
    }

    @Test
    public void testConstruct2DArray2() {
        int[][] matrix = new int[1][];
        int[] ar1;

        ar1 = new int[]{1, 2, 3};
        matrix[0] = ar1;

        assertArrayEquals(matrix, a.construct2DArray(new int[]{1,2,3}, 1, 3));
    }
}
