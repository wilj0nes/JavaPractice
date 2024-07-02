package testpackage;

import com.practice.challenges.singleChallengeClasses.Subsets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSubsets {
    Subsets s = new Subsets();

    @Test
    public void testSubSets1() {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>(Arrays.asList()));
        results.add(new ArrayList<>(Arrays.asList(1)));
        results.add(new ArrayList<>(Arrays.asList(2)));
        results.add(new ArrayList<>(Arrays.asList(3)));
        results.add(new ArrayList<>(Arrays.asList(1,2)));
        results.add(new ArrayList<>(Arrays.asList(1,3)));
        results.add(new ArrayList<>(Arrays.asList(2,3)));
        results.add(new ArrayList<>(Arrays.asList(1,2,3)));

        assertTrue(s.subSets(new int[]{1, 2, 3}).containsAll(results));
    }

    @Test
    public void testSubSets2() {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>(Arrays.asList()));
        results.add(new ArrayList<>(Arrays.asList(1)));
        results.add(new ArrayList<>(Arrays.asList(2)));
        results.add(new ArrayList<>(Arrays.asList(3)));
        results.add(new ArrayList<>(Arrays.asList(4)));

        results.add(new ArrayList<>(Arrays.asList(1,2)));
        results.add(new ArrayList<>(Arrays.asList(1,3)));
        results.add(new ArrayList<>(Arrays.asList(1,4)));
        results.add(new ArrayList<>(Arrays.asList(2,3)));
        results.add(new ArrayList<>(Arrays.asList(2,4)));
        results.add(new ArrayList<>(Arrays.asList(3,4)));

        results.add(new ArrayList<>(Arrays.asList(1,2,3)));
        results.add(new ArrayList<>(Arrays.asList(1,3,4)));
        results.add(new ArrayList<>(Arrays.asList(2,3,4)));
        results.add(new ArrayList<>(Arrays.asList(1,2,4)));
        results.add(new ArrayList<>(Arrays.asList(1,2,3,4)));

        assertTrue(s.subSets(new int[]{1, 2, 3, 4}).containsAll(results));
    }

    @Test
    public void testSubSets3() {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>(Arrays.asList()));
        results.add(new ArrayList<>(Arrays.asList(0)));

        assertTrue(s.subSets(new int[]{0}).containsAll(results));
    }

    @Test
    public void testSubSets5() {
        List<List<Integer>> answer = new ArrayList<>();

        answer.add(new ArrayList<>(Arrays.asList()));
        answer.add(new ArrayList<>(Arrays.asList(1)));
        answer.add(new ArrayList<>(Arrays.asList(2)));
        answer.add(new ArrayList<>(Arrays.asList(1,2)));
        answer.add(new ArrayList<>(Arrays.asList(3)));
        answer.add(new ArrayList<>(Arrays.asList(1,3)));
        answer.add(new ArrayList<>(Arrays.asList(2,3)));
        answer.add(new ArrayList<>(Arrays.asList(1,2,3)));
        answer.add(new ArrayList<>(Arrays.asList(4)));
        answer.add(new ArrayList<>(Arrays.asList(1,4)));
        answer.add(new ArrayList<>(Arrays.asList(2,4)));
        answer.add(new ArrayList<>(Arrays.asList(1,2,4)));
        answer.add(new ArrayList<>(Arrays.asList(3,4)));
        answer.add(new ArrayList<>(Arrays.asList(1,3,4)));
        answer.add(new ArrayList<>(Arrays.asList(2,3,4)));
        answer.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
        answer.add(new ArrayList<>(Arrays.asList(5)));
        answer.add(new ArrayList<>(Arrays.asList(1,5)));
        answer.add(new ArrayList<>(Arrays.asList(2,5)));
        answer.add(new ArrayList<>(Arrays.asList(1,2,5)));
        answer.add(new ArrayList<>(Arrays.asList(3,5)));
        answer.add(new ArrayList<>(Arrays.asList(1,3,5)));
        answer.add(new ArrayList<>(Arrays.asList(2,3,5)));
        answer.add(new ArrayList<>(Arrays.asList(1,2,3,5)));
        answer.add(new ArrayList<>(Arrays.asList(4,5)));
        answer.add(new ArrayList<>(Arrays.asList(1,4,5)));
        answer.add(new ArrayList<>(Arrays.asList(2,4,5)));
        answer.add(new ArrayList<>(Arrays.asList(1,2,4,5)));
        answer.add(new ArrayList<>(Arrays.asList(3,4,5)));
        answer.add(new ArrayList<>(Arrays.asList(1,3,4,5)));
        answer.add(new ArrayList<>(Arrays.asList(2,3,4,5)));
        answer.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));

        assertTrue(s.subSets(new int[]{1,2,3,4,5}).containsAll(answer));
    }



}



