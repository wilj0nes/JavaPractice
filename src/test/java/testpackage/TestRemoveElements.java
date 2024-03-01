package testpackage;

import com.practice.challenges.LinkedListChallenges;
import com.practice.misc.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestRemoveElements {

    public static final LinkedListChallenges l = new LinkedListChallenges();

    @Test
    public void testRemoveElements() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        ListNode ans1 = new ListNode(1);
        ListNode ans2 = new ListNode(2);
        ListNode ans3 = new ListNode(3);
        ListNode ans4 = new ListNode(4);
        ListNode ans5 = new ListNode(5);

        ans1.setNext(ans2);
        ans2.setNext(ans3);
        ans3.setNext(ans4);
        ans4.setNext(ans5);

        ListNode resultNode = l.removeElements_improved(head, 6);

        while (resultNode.getNext() != null) {
            assertEquals(ans1.getVal(), resultNode.getVal());
            ans1 = ans1.getNext();
            resultNode = resultNode.getNext();
        }
    }

    @Test
    public void testRemoveElements2() {
        ListNode head = new ListNode(7);
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(7);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        ListNode resultNode = l.removeElements_improved(head, 7);

        assertNull(resultNode);
    }
    @Test
    public void testRemoveElements3() {
        ListNode head = new ListNode(1);
        ListNode resultNode = l.removeElements_improved(head, 2);
        assertEquals(new ListNode(1, null).getVal(), resultNode.getVal());
        assertEquals(new ListNode(1, null).getNext(), resultNode.getNext());
    }

    @Test
    public void testRemoveElements4() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.setNext(node1);

        ListNode ans1 = new ListNode(2);

        ListNode resultNode = l.removeElements_improved(head, 1);
        assertEquals(ans1.getVal(), resultNode.getVal());
        assertEquals(ans1.getNext(), resultNode.getNext());

    }


}
