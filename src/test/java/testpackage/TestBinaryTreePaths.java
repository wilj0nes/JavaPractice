package testpackage;

import com.practice.challenges.TreeChallenges;
import com.practice.misc.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TestBinaryTreePaths {
    public static final TreeChallenges t = new TreeChallenges();

    @Test
    public void testBinaryTreePaths1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(null);
        node2.setRight(node4);

        List<String> answer = new ArrayList<>(Arrays.asList("1->2->5", "1->3"));
        List<String> result = t.binaryTreePaths(node1);
        assertTrue(answer.size() == result.size() && answer.containsAll(result) && result.containsAll(answer));
    }
    @Test
    public void testBinaryTreePaths2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);

        List<String> answer = new ArrayList<>(Arrays.asList("1->2->5","1->2->4","1->3"));
        List<String> result = t.binaryTreePaths(node1);
        assertTrue(answer.size() == result.size() && answer.containsAll(result) && result.containsAll(answer));
    }

    @Test
    public void testBinaryTreePaths3() {
        TreeNode node1 = new TreeNode(1);
        assertArrayEquals(new ArrayList<>(Arrays.asList("1")).toArray(), t.binaryTreePaths(node1).toArray());
    }

    @Test
    public void testBinaryTreePaths4() {
        assertNull(t.binaryTreePaths(null));
    }
}
