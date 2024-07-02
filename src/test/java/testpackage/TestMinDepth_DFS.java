package testpackage;

import com.practice.challenges.TreeChallenges;
import com.practice.challenges.singleChallengeClasses.MinDepth;
import com.practice.misc.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMinDepth_DFS {
    public static final MinDepth t = new MinDepth();

    @Test
    public void testMinDepth() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node3.setLeft(node4);
        node3.setRight(node5);

        node1.setLeft(node2);
        node1.setRight(node3);

        assertEquals(2, t.minDepth_DFS(node1));
    }
    @Test
    public void testMinDepth2() {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        node1.setLeft(null);
        node1.setRight(node2);

        node2.setLeft(null);
        node2.setRight(node3);

        node3.setLeft(null);
        node3.setRight(node4);

        node4.setLeft(null);
        node4.setRight(node5);

        assertEquals(5, t.minDepth_DFS(node1));

    }
    @Test
    public void testMinDepth3() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.setLeft(null);
        node1.setRight(node2);

        assertEquals(2, t.minDepth_DFS(node1));
    }
    @Test
    public void testMinDepth4() {
        assertEquals(0, t.minDepth_DFS(null));
    }

}
