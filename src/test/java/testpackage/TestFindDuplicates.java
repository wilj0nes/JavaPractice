package testpackage;

import com.practice.challenges.ArrayChallenges;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestFindDuplicates {
    ArrayChallenges a = new ArrayChallenges();

    @Test
    public void testFindDuplicates1() {
        List<Integer> result = a.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
        List<Integer> answer = Arrays.asList(2, 3);
        assertEquals(answer.toString(), result.toString());
    }

    @Test
    public void testFindDuplicates2() {
        List<Integer> result = a.findDuplicates(new int[]{1,1,2});
        List<Integer> answer = Arrays.asList(1);
        assertEquals(answer.toString(), result.toString());
    }
    @Test
    public void testFindDuplicates3() {
        List<Integer> result = a.findDuplicates(new int[]{1});
        List<Integer> answer = Arrays.asList();
        assertEquals(answer.toString(), result.toString());
    }
    @Test
    public void testFindDuplicates4() {
        List<Integer> result = a.findDuplicates(new int[]{});
        List<Integer> answer = Arrays.asList();
        assertEquals(answer.toString(), result.toString());
    }
}
