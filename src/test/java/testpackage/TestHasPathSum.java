package testpackage;

import com.practice.challenges.TreeChallenges;
import com.practice.misc.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestHasPathSum {
    public static final TreeChallenges t = new TreeChallenges();

    @Test
    public void testHasPathSum1() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);

        node1.setLeft(node2); // 5
        node1.setRight(node3);

        node2.setLeft(node4);  // 4
        node2.setRight(null);

        node3.setLeft(node5); // 8
        node3.setRight(node6);

        node4.setLeft(node7); // 11
        node4.setRight(node8);

        node6.setLeft(null); // 4
        node6.setRight(node9);

        assertTrue(t.hasPathSum(node1, 22));
    }
    @Test
    public void testHasPathSum2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.setLeft(node2); // 5
        node1.setRight(node3);

        assertFalse(t.hasPathSum(node1, 5));
    }

    @Test
    public void testHasPathSum3() {
        assertFalse(t.hasPathSum(new TreeNode(), 0));
    }

    @Test
    public void testHasPathSum4() {
        assertTrue(t.hasPathSum(new TreeNode(1), 1));
    }

}
