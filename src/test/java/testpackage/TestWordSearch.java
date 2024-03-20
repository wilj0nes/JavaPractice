package testpackage;

import com.practice.challenges.ArrayChallenges;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestWordSearch {
    ArrayChallenges a = new ArrayChallenges();

    @Test
    public void testWordSearch1() {
        char[][] matrix = new char[3][];
        char[] ar1, ar2, ar3;

        ar1 = new char[]{'A', 'B', 'C', 'E'};
        ar2 = new char[]{'S', 'F', 'C', 'S'};
        ar3 = new char[]{'A', 'D', 'E', 'E'};

        matrix[0] = ar1;
        matrix[1] = ar2;
        matrix[2] = ar3;
        assertTrue(a.exist(matrix, "ABCCED"));
    }

    @Test
    public void testWordSearch2() {
        char[][] matrix = new char[3][];
        char[] ar1, ar2, ar3;

        ar1 = new char[]{'A', 'B', 'C', 'E'};
        ar2 = new char[]{'S', 'F', 'C', 'S'};
        ar3 = new char[]{'A', 'D', 'E', 'E'};

        matrix[0] = ar1;
        matrix[1] = ar2;
        matrix[2] = ar3;

        assertTrue(a.exist(matrix, "SEE"));
    }

    @Test
    public void testWordSearch3() {
        char[][] matrix = new char[3][];
        char[] ar1, ar2, ar3;

        ar1 = new char[]{'A', 'B', 'C', 'E'};
        ar2 = new char[]{'S', 'F', 'C', 'S'};
        ar3 = new char[]{'A', 'D', 'E', 'E'};

        matrix[0] = ar1;
        matrix[1] = ar2;
        matrix[2] = ar3;

        assertFalse(a.exist(matrix, "ABCB"));
    }

    @Test
    public void testWordSearch4() {
        char[][] matrix = new char[2][];
        char[] ar1, ar2;

        ar1 = new char[]{'a'};
        ar2 = new char[]{'a'};

        matrix[0] = ar1;
        matrix[1] = ar2;

        assertFalse(a.exist(matrix, "aaa"));
    }
    @Test
    public void testWordSearch5() {
        char[][] matrix = new char[1][];
        char[] ar1;

        ar1 = new char[]{'a'};
        matrix[0] = ar1;

        assertTrue(a.exist(matrix, "a"));
    }
    @Test
    public void testWordSearch6() {
        char[][] matrix = new char[2][];
        char[] ar1, ar2;

        ar1 = new char[]{'a', 'b'};
        ar2 = new char[]{'c', 'd'};

        matrix[0] = ar1;
        matrix[1] = ar2;

        assertTrue(a.exist(matrix, "cdba"));
    }

    @Test
    public void testWordSearch7() {
        char[][] matrix = new char[3][];
        char[] ar1, ar2, ar3;

        ar1 = new char[]{'C', 'A', 'A'};
        ar2 = new char[]{'A', 'A', 'A'};
        ar3 = new char[]{'B', 'C', 'D'};

        matrix[0] = ar1;
        matrix[1] = ar2;
        matrix[2] = ar3;
        assertTrue(a.exist(matrix, "AAB"));
    }

}
