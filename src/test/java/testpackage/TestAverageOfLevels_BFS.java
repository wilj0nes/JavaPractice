package testpackage;

import com.practice.leetcode.TreeChallenges;
import com.practice.misc.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class TestAverageOfLevels_BFS {

    public static final TreeChallenges t = new TreeChallenges();

    @Test
    public void testAverageOfLevels_BFS() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node3.setLeft(node4);
        node3.setRight(node5);

        node1.setLeft(node2);
        node1.setRight(node3);

        List<Double> answerList = new ArrayList<>(Arrays.asList(3.00000,14.50000,11.00000));
        assertArrayEquals(answerList.toArray(), t.averageOfLevels_BFS(node1).toArray());
    }
    @Test
    public void testAverageOfLevels_BFS5() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node3.setLeft(node4);
        node3.setRight(node5);

        node1.setLeft(node2);
        node1.setRight(node3);

        List<Double> answerList = new ArrayList<>(Arrays.asList(3.00000,14.50000,11.00000));
        assertArrayEquals(answerList.toArray(), t.averageOfLevels_BFS(node1).toArray());
    }
    @Test
    public void testAverageOfLevels_BFS2() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node2.setLeft(node4);
        node2.setRight(node5);

        node1.setLeft(node2);
        node1.setRight(node3);

        List<Double> answerList = new ArrayList<>(Arrays.asList(3.00000,14.50000,11.00000));
        assertArrayEquals(answerList.toArray(), t.averageOfLevels_BFS(node1).toArray());
    }
    @Test
    public void testAverageOfLevels_BFS4() {
        TreeNode node1 = new TreeNode(2147483647);
        TreeNode node2 = new TreeNode(2147483647);
        TreeNode node3 = new TreeNode(2147483647);

        node1.setLeft(node2);
        node1.setRight(node3);


        List<Double> answerList = new ArrayList<>(Arrays.asList(2147483647.0,2147483647.0));
        assertArrayEquals(answerList.toArray(), t.averageOfLevels_BFS(node1).toArray());
    }
    @Test
    public void testAverageOfLevels_BFS3() {
        TreeNode node1 = new TreeNode(3);

        List<Double> answerList = new ArrayList<>(Arrays.asList(3.00000));
        assertArrayEquals(answerList.toArray(), t.averageOfLevels_BFS(node1).toArray());
    }

}
