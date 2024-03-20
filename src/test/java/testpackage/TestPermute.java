package testpackage;

import com.practice.challenges.BacktrackingChallenges;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestPermute {

    BacktrackingChallenges b = new BacktrackingChallenges();

    @Test
    public void testPermute1() {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(Arrays.asList(1,2,3)));
        answer.add(new ArrayList<>(Arrays.asList(1,3,2)));
        answer.add(new ArrayList<>(Arrays.asList(1,3,2)));
        answer.add(new ArrayList<>(Arrays.asList(2,1,3)));
        answer.add(new ArrayList<>(Arrays.asList(3,1,2)));
        answer.add(new ArrayList<>(Arrays.asList(3,2,1)));

        assertTrue(b.permute(new int[]{1,2,3}).containsAll(answer));
    }
    @Test
    public void testPermute2() {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(Arrays.asList(0,1)));
        answer.add(new ArrayList<>(Arrays.asList(1,0)));

        assertTrue(b.permute(new int[]{0,1}).containsAll(answer));
    }
    @Test
    public void testPermute3() {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(Arrays.asList(1)));

        assertTrue(b.permute(new int[]{1}).containsAll(answer));
    }

}
