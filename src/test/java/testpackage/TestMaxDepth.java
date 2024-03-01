package testpackage;

import com.practice.challenges.TreeChallenges;
import com.practice.misc.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestMaxDepth {

    public static final TreeChallenges t = new TreeChallenges();

    @Test
    public void testMaxDepth() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);

        assertEquals(3, t.maxDepth(node1));
    }
    @Test
    public void testMaxDepth2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        node1.setLeft(null);
        node1.setRight(node2);

        assertEquals(2, t.maxDepth(node1));
    }

    @Test
    public void testMaxDepth3() {
        assertEquals(0, t.maxDepth(null));
    }
    @Test
    public void testMaxDepth4() {
        assertEquals(1, t.maxDepth(new TreeNode(0)));
    }

}
