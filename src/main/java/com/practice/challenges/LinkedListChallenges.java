package com.practice.challenges;

import com.practice.misc.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LinkedListChallenges {

    // 141. Linked List Cycle
    // Given head, the head of a linked list, determine if the linked list has a cycle in it.
    //
    // There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
    // Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
    // Note that pos is not passed as a parameter.
    //
    // Return true if there is a cycle in the linked list. Otherwise, return false.
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashMap<ListNode, Integer> hashMap = new HashMap<>();

        while (head.next != null) {
            if (hashMap.get(head) == null) {
                hashMap.put(head, head.val);
            }
            else if (hashMap.get(head) != null){
                return true;
            }

            head = head.next;
        }

        return false;
    }

    // 876. Middle of the Linked List
    // Given the head of a singly linked list, return the middle node of the linked list.
    //
    // If there are two middle nodes, return the second middle node.
    // Example 1:
    // Input: head = [1,2,3,4,5]
    // Output: [3,4,5]
    // Explanation: The middle node of the list is node 3.
    // Example 2:
    // Input: head = [1,2,3,4,5,6]
    // Output: [4,5,6]
    // Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        List<ListNode> nodeList = new ArrayList<>();

        do {
            nodeList.add(head);
            head = head.next;
        } while (head != null);

        // equivalent to nodeList.size() / 2 but result is rounded up, returning the middle value
        return nodeList.get((nodeList.size() >> 1));
    }

    // 206. Reverse Linked List
    // Given the head of a singly linked list, reverse the list, and return the reversed list.
    // Example 1:
    // Input: head = [1,2,3,4,5]
    // Output: [5,4,3,2,1]

    // Example 2:
    // Input: head = [1,2]
    // Output: [2,1]
    public ListNode reverseList(ListNode head) {
        // put them in a list
        // iterate on the list backwards

        List<ListNode> nodeLists = new ArrayList<>();

        while (head != null) {
            nodeLists.add(head);
            if (head.next == null) {
                break;
            }
            head = head.next;
        }
        for (ListNode node : nodeLists) {
            node.next = null;
        }
        Collections.reverse(nodeLists); // O(n)

        ListNode ptr = head;

        for (int i = 0; i < nodeLists.size()-1; i++) {
            ptr = nodeLists.get(i);
            ptr.next = nodeLists.get(i + 1);
            ptr = ptr.next;
        }

        return head;
    }


    // 234. Palindrome Linked List
    // Given the head of a singly linked list, return true if it is a palindrome or false otherwise

    // A palindrome is a sequence that reads the same forward and backward.

    // Example 1:
    //Input: head = [1,2,2,1]
    //Output: true

    // Example 2:
    //Input: head = [1,2]
    //Output: false
    public boolean isPalendrome(ListNode head) { // O(n) runtime, O(n) space
        if (head.next == null) {
            return true;
        }

        List<ListNode> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }

        List<ListNode> newArr = new ArrayList<>(nodeList);
        Collections.reverse(nodeList); // reverse list;

        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).val != newArr.get(i).val) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalendrome_betterRuntime(ListNode head) { // not my solution, faster but uses more memory
        if (head.next == null) {
            return true;
        }

        ListNode node = new ListNode(head.val);
        ListNode i = head.next;

        while (i.next != null) {
            // this builds out new LL by adding node to head
            // resulting in reversed ll
            node = new ListNode(i.val, node); // build out new linked list by adding new i at beginning of ll
            i = i.next;
        }
        // i now pointing to last node

        node = new ListNode(i.val, node);  // ???
        ListNode j = node;
        i = head;

        while (i != null) {
            if(i.val != j.val) {
                return false;
            }

            i =  i.next;
            j =  j.next;
        }

        return true;
    }


    // 203. Remove Linked List Elements
    // Given the head of a linked list and an integer val,
    // remove all the nodes of the linked list that has Node.val == val, and return the new head.
    //
    //Example 1:
    //Input: head = [1,2,6,3,4,5,6], val = 6
    //Output: [1,2,3,4,5]

    //Example 2:
    //Input: head = [], val = 1
    //Output: []

    //Example 3:
    //Input: head = [7,7,7,7], val = 7
    //Output: []
    public ListNode removeElements(ListNode head, int val) { // shit solution, too messy, too many hard coded edge cases
        if (head == null) {
            return null;
        }
        else if (head.next == null && head.val != val) {
            return head;
        }

        List<Integer> listNodes = new ArrayList<>();
        // ^ better to use int instead of ListNode so any unwanted node references are not passed into this array

        ListNode ptr = head;
        while(ptr != null) {
            if (ptr.val != val) {
                listNodes.add(ptr.val);
            }
            ptr = ptr.next;
        }

        if (listNodes.isEmpty()) {
            return null;
        }
        else if (listNodes.size() < 2) {
            return new ListNode(listNodes.get(0));
        }

        ListNode newHead = new ListNode();
        ListNode node = newHead;
        for (int i = 0; i < listNodes.size()-1; i++) {
            node.val = listNodes.get(i);
            node.next = new ListNode(listNodes.get(i + 1));
            node = node.next;
        }

        return newHead;
    }

    public ListNode removeElements_improved(ListNode head, int val) { // not my solution
        ListNode dummy = new ListNode();
        dummy.next = head; // head node placeholder
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            }
            else {
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }

    // 21. Merge Two Sorted Lists
    // You are given the heads of two sorted linked lists list1 and list2.
    // Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
    // Return the head of the merged linked list.

    // Example 1:
    // Input: list1 = [1,2,4], list2 = [1,3,4]
    // Output: [1,1,2,3,4,4]

    // Example 2:
    // Input: list1 = [], list2 = []
    // Output: []

    // Example 3:
    // Input: list1 = [], list2 = [0]
    // Output: [0]
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { // not my solution
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        ListNode nodeHead, nodeTail;

        if (l1.val < l2.val) {
            nodeHead = l1;
            nodeTail = this.mergeTwoLists(l1.next, l2);
        }
        else {
            nodeHead = l2;
            nodeTail = this.mergeTwoLists(l1, l2.next);
        }

        nodeHead.next = nodeTail;
        return nodeHead;
    }

}
