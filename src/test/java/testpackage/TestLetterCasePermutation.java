package testpackage;

import com.practice.challenges.StringChallenges;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestLetterCasePermutation {
    StringChallenges s = new StringChallenges();

    @Test
    public void testLetterCasePermutation1() {
        assertTrue(
                Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2").containsAll(s.letterCasePermutation("a1b2"))
                && s.letterCasePermutation("a1b2").containsAll(Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2"))
        );
    }
    @Test
    public void testLetterCasePermutation2() {
        assertTrue(
                Arrays.asList("3z4","3Z4").containsAll(s.letterCasePermutation("3z4"))
                        && s.letterCasePermutation("3z4").containsAll(Arrays.asList("3z4","3Z4"))
        );
    }

    @Test
    public void testLetterCasePermutation4() {
        assertTrue(
                Arrays.asList("a", "A").containsAll(s.letterCasePermutation("a"))
                        && s.letterCasePermutation("a").containsAll(Arrays.asList("a", "A"))
        );

    }

    @Test
    public void testLetterCasePermutation5() {
        assertTrue(
                Arrays.asList("jw","jW","Jw","JW").containsAll(s.letterCasePermutation("Jw"))
                        && s.letterCasePermutation("Jw").containsAll(Arrays.asList("jw","jW","Jw","JW"))
        );
    }
    @Test
    public void testLetterCasePermutation6() {
        assertTrue(
                Arrays.asList("mqe","mqE","mQe","mQE","Mqe","MqE","MQe","MQE").containsAll(s.letterCasePermutation("mQe"))
                        && s.letterCasePermutation("mQe").containsAll(Arrays.asList("mqe","mqE","mQe","mQE","Mqe","MqE","MQe","MQE"))
        );
    }
    @Test
    public void testLetterCasePermutation7() {
        assertTrue(
                Arrays.asList("dntj","dntJ","dnTj","dnTJ","dNtj","dNtJ","dNTj","dNTJ","Dntj","DntJ","DnTj","DnTJ","DNtj","DNtJ","DNTj","DNTJ").containsAll(s.letterCasePermutation("dnTJ"))
                        && s.letterCasePermutation("dnTJ").containsAll(Arrays.asList("dntj","dntJ","dnTj","dnTJ","dNtj","dNtJ","dNTj","dNTJ","Dntj","DntJ","DnTj","DnTJ","DNtj","DNtJ","DNTj","DNTJ"))
        );
    }




}
