package testpackage;

import com.practice.challenges.singleChallengeClasses.GenerateParenthesis;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestGenerateParenthesis {
    GenerateParenthesis g = new GenerateParenthesis();

    @Test
    public void testGenerateParenthesis1() {
        List<String> answer = new ArrayList<>();
        answer.add("((()))");
        answer.add("(()())");
        answer.add("(())()");
        answer.add("()(())");
        answer.add("()()()");

        List<String> expected = g.generateParenthesis(3);
        assertTrue(answer.size() == expected.size() && answer.containsAll(expected));
    }
    @Test
    public void testGenerateParenthesis2() {
        List<String> answer = new ArrayList<>();
        answer.add("()");

        List<String> expected = g.generateParenthesis(1);
        assertTrue(answer.size() == expected.size() && answer.containsAll(expected));
    }
}
