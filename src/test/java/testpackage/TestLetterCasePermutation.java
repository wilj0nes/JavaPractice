package testpackage;

import com.practice.challenges.BacktrackingChallenges;
import com.practice.challenges.StringChallenges;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestLetterCasePermutation {
    BacktrackingChallenges b = new BacktrackingChallenges();

    @Test
    public void testLetterCasePermutation1() {
        assertTrue(
                Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2").containsAll(b.letterCasePermutation("a1b2"))
                && b.letterCasePermutation("a1b2").containsAll(Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2"))
        );
    }
    @Test
    public void testLetterCasePermutation2() {
        assertTrue(
                Arrays.asList("3z4","3Z4").containsAll(b.letterCasePermutation("3z4"))
                        && b.letterCasePermutation("3z4").containsAll(Arrays.asList("3z4","3Z4"))
        );
    }

    @Test
    public void testLetterCasePermutation4() {
        assertTrue(
                Arrays.asList("a", "A").containsAll(b.letterCasePermutation("a"))
                        && b.letterCasePermutation("a").containsAll(Arrays.asList("a", "A"))
        );

    }

    @Test
    public void testLetterCasePermutation5() {
        assertTrue(
                Arrays.asList("jw","jW","Jw","JW").containsAll(b.letterCasePermutation("Jw"))
                        && b.letterCasePermutation("Jw").containsAll(Arrays.asList("jw","jW","Jw","JW"))
        );
    }
    @Test
    public void testLetterCasePermutation6() {
        assertTrue(
                Arrays.asList("mqe","mqE","mQe","mQE","Mqe","MqE","MQe","MQE").containsAll(b.letterCasePermutation("mQe"))
                        && b.letterCasePermutation("mQe").containsAll(Arrays.asList("mqe","mqE","mQe","mQE","Mqe","MqE","MQe","MQE"))
        );
    }
    @Test
    public void testLetterCasePermutation7() {
        assertTrue(
                Arrays.asList("dntj","dntJ","dnTj","dnTJ","dNtj","dNtJ","dNTj","dNTJ","Dntj","DntJ","DnTj","DnTJ","DNtj","DNtJ","DNTj","DNTJ").containsAll(b.letterCasePermutation("dnTJ"))
                        && b.letterCasePermutation("dnTJ").containsAll(Arrays.asList("dntj","dntJ","dnTj","dnTJ","dNtj","dNtJ","dNTj","dNTJ","Dntj","DntJ","DnTj","DnTJ","DNtj","DNtJ","DNTj","DNTJ"))
        );
    }




}
