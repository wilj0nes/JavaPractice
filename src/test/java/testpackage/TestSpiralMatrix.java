package testpackage;

import com.practice.challenges.singleChallengeClasses.SpiralMatrix;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestSpiralMatrix {
    SpiralMatrix s = new SpiralMatrix();

    @Test
    public void testSpiralMatrix() {
        int[][] matrix = new int[3][];
        int[] ar1, ar2, ar3;

        ar1 = new int[]{1, 2, 3};
        ar2 = new int[]{4, 5, 6};
        ar3 = new int[]{7, 8, 9};

        matrix[0] = ar1;
        matrix[1] = ar2;
        matrix[2] = ar3;

        assertEquals(Arrays.asList(1,2,3,6,9,8,7,4,5), s.spiralOrder(matrix));
    }

    @Test
    public void testSpiralMatrix2() {
        int[][] matrix = new int[3][];
        int[] ar1, ar2, ar3;

        ar1 = new int[]{1, 2, 3, 4};
        ar2 = new int[]{5, 6, 7, 8};
        ar3 = new int[]{9, 10, 11, 12};

        matrix[0] = ar1;
        matrix[1] = ar2;
        matrix[2] = ar3;

        assertEquals(Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7), s.spiralOrder(matrix));
    }
}
