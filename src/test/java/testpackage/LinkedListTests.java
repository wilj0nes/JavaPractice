package testpackage;

import com.practice.leetcode.LinkedListChallenges;
import com.practice.misc.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class LinkedListTests {
    public static final LinkedListChallenges l = new LinkedListChallenges();

    @Test
    public void testHasCycle() {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node1);

        assertTrue(l.hasCycle(head));
    }


    @Test
    public void testMiddleNode() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        assertEquals(node2, l.middleNode(head));
    }
    @Test
    public void testMiddleNode2() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        assertEquals(node3, l.middleNode(head));
    }

    @Test
    public void testReverseList() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        ListNode ans1 = new ListNode(5);
        ListNode ans2 = new ListNode(4);
        ListNode ans3 = new ListNode(3);
        ListNode ans4 = new ListNode(2);
        ListNode ans5 = new ListNode(1);

        ans1.setNext(ans2);
        ans2.setNext(ans3);
        ans3.setNext(ans4);
        ans4.setNext(ans5);

        head = l.reverseList(head);

        while (ans1.getNext() != null && head.getNext() != null) {
            assertEquals(ans1.getVal(), head.getVal());
            ans1 = ans1.getNext();
            head = head.getNext();
        }
    }

    @Test
    public void testisPalindrome() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        assertTrue(l.isPalendrome(head));
    }

    @Test
    public void testisPalendrome_betterSpaceComplexity() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        assertTrue(l.isPalendrome_betterRuntime(head));
    }
    @Test
    public void testisPalendrome_betterSpaceComplexity2() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        assertFalse(l.isPalendrome_betterRuntime(head));
    }

    @Test
    public void testRemoveElements() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(null);


        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(null);

        ListNode ans1 = new ListNode(1);
        ListNode ans2 = new ListNode(1);
        ListNode ans3 = new ListNode(2);
        ListNode ans4 = new ListNode(3);
        ListNode ans5 = new ListNode(4);
        ListNode ans6 = new ListNode(4);

        ans1.setNext(ans2);
        ans2.setNext(ans3);
        ans3.setNext(ans4);
        ans4.setNext(ans5);
        ans5.setNext(ans6);

        ListNode resultNode = l.mergeTwoLists(node1 , node4);

        while (resultNode.getNext() != null) {
            assertEquals(ans1.getVal(), resultNode.getVal());
            ans1 = ans1.getNext();
            resultNode = resultNode.getNext();
        }
    }




}
