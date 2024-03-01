package testpackage;

import com.practice.challenges.TreeChallenges;
import com.practice.misc.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestIsSameTree {
    public static final TreeChallenges t = new TreeChallenges();

    @Test
    public void testIsSameTree() {
        TreeNode pNode1 = new TreeNode(1);
        TreeNode pNode2 = new TreeNode(2);
        TreeNode pNode3 = new TreeNode(3);

        pNode1.setLeft(pNode2);
        pNode1.setRight(pNode3);

        TreeNode qNode1 = new TreeNode(1);
        TreeNode qNode2 = new TreeNode(2);
        TreeNode qNode3 = new TreeNode(3);

        qNode1.setLeft(qNode2);
        qNode1.setRight(qNode3);

        assertTrue(t.isSameTree(pNode1, qNode1));
    }
    @Test
    public void testIsSameTree2() {
        TreeNode pNode1 = new TreeNode(1);
        TreeNode pNode2 = new TreeNode(2);

        pNode1.setLeft(pNode2);
        pNode1.setRight(null);

        TreeNode qNode1 = new TreeNode(1);
        TreeNode qNode2 = new TreeNode(2);

        qNode1.setLeft(null);
        qNode1.setRight(qNode2);

        assertFalse(t.isSameTree(pNode1, qNode1)); // trees have same vals but are asymmetrical
    }
    @Test
    public void testIsSameTree3() {
        TreeNode pNode1 = new TreeNode(1);
        TreeNode pNode2 = new TreeNode(2);
        TreeNode pNode3 = new TreeNode(1);

        pNode1.setLeft(pNode2);
        pNode1.setRight(pNode3);

        TreeNode qNode1 = new TreeNode(1);
        TreeNode qNode2 = new TreeNode(1);
        TreeNode qNode3 = new TreeNode(2);

        qNode1.setLeft(qNode2);
        qNode1.setRight(qNode3);

        assertFalse(t.isSameTree(pNode1, qNode1));
    }
    @Test
    public void testIsSameTree4() {
        assertTrue(t.isSameTree(null, null));
    }
    @Test
    public void testIsSameTree5() {
        assertTrue(t.isSameTree(new TreeNode(), new TreeNode()));
    }
}
