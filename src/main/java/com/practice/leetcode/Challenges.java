package com.practice.leetcode;

import java.util.*;

public class Challenges {

    public int climbStairs_memoization(int n ) {
        int memo[] = new int[n + 1];
        return climb_memo(0, n, memo);
    }

    public int climb_memo(int i, int n, int memo[]) { // https://leetcode.com/problems/climbing-stairs/
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }

        // the result of each step is stored in the memo array
        // and returning result the result from array when fcn is called again
        // this way the recursion tree is reduced reducing runtime to O(n)
        memo[i] = climb_memo(i + 1, n, memo) + climb_memo(i + 2, n, memo);
        System.out.println(Arrays.toString(memo));

        System.out.println("returning: " + memo[i]);
        return memo[i];
    }
    // You are climbing a staircase. It takes n steps to reach to the top.
    //Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    public int climbStairs(int n) { // brute force solution | O(2^n) time complexity
        return climb( 0, n);
    }
    public int climb(int i, int n) {
        System.out.println("climb( " + i + ", " + n + " )");
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb(i + 1, n) + climb(i + 2, n);
    }


    // 448. Find All Numbers Disappeared in an Array
    // Given an array nums of n integers where nums[i] is in the range [1, n],
    // return an array of all the integers in the range [1, n] that do not appear in nums

    //Example 1:
    //
    //Input: nums = [4,3,2,7,8,2,3,1]
    //Output: [5,6]

    //Example 2:
    //
    //Input: nums = [1,1]
    //Output: [2]

    // Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>(); // adds space complexity
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 1; i <= length; i++) {
            if (hashMap.get(i) == null) {
                result.add(i);
            }
        }

//        System.out.println(result);
        return result;
    }


    public List<Integer> findDisappearedNumbers_improvedMemory2(int[] nums) { // not my solution
        List<Integer> result = new ArrayList<>();
        int index = 0;

        while (index < nums.length) {
            int correct = nums[index] - 1;

            if (nums[index] != nums[correct]) {
                int temp = nums[index];
                nums[index] = nums[correct];
                nums[correct] = temp;
            }
            else {
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) { // check if vals are in sequental order
                result.add(i + 1);
            }
        }

        return result;
    }

    public List<Integer> findDisappearedNumbers_improvedMemory(int[] nums) { // this works but leetcode is a cunt
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {        // 1 .. num.length
            for (int j = 0; j < nums.length; j++) {     // 0 .. num.length-1
                if (i == nums[j]) {
                    break;
                }
                else if (j == nums.length-1 && i != nums[j]) {
                    result.add(i);
                }
            }
        }

//        System.out.println(result);
        return result;
    }


    // 704. Binary Search
    // Given an array of integers nums which is sorted in ascending order, and an integer target,
    // write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
    // You must write an algorithm with O(log n) runtime complexity.

    //Example 1:
    //Input: nums = [-1,0,3,5,9,12], target = 9
    //Output: 4
    //Explanation: 9 exists in nums and its index is 4

    //Example 2:
    //Input: nums = [-1,0,3,5,9,12], target = 2
    //Output: -1
    //Explanation: 2 does not exist in nums so return -1

    public int search(int[] nums, int target) {
        // // O(n) runtime, it wants O(log n)
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                return i;
//            }
//        }
        int low = 0;
        int high = nums.length - 1;

        return binarySearch(nums, low, high, target);
    }

    public int binarySearch(int[] nums, int low, int high, int target) { // not my solution
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        else if (target > nums[mid]) {
            return binarySearch(nums, mid+1, high, target);
        }
        else {
            return binarySearch(nums, low, mid-1, target);
        }
    }

    // 744. Find Smallest Letter Greater Than Target
    // You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
    // There are at least two different characters in letters.
    // Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist,
    // return the first character in letters.

    // Example 1:
    // Input: letters = ["c","f","j"], target = "a"
    // Output: "c"
    // Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.

    // Example 2:
    // Input: letters = ["c","f","j"], target = "c"
    // Output: "f"
    // Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.

    // Example 3:
    // Input: letters = ["x","x","y","y"], target = "z"
    // Output: "x"
    // Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
    public char nextGreatestLetter(char[] letters, char target) {
        char result = 'z';
        boolean found = false;

        for (char c: letters) {
            if (c > target && c <= result) {
                result = c;
                found = true;
            }
        }

        if (!found) {
            return letters[0];
        }
        return result;
    }

    public char nextGreatestLetter_binarySearch(char[] letters, char target) { // not my solution
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return letters[start % letters.length];
    }

    // 637. Average of Levels in Binary Tree
    // Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
    // Answers within 10-5 of the actual answer will be accepted.

    // Example 1:
    // Input: root = [3,9,20,null,null,15,7]
    // Output: [3.00000,14.50000,11.00000]
    // Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
    // Hence return [3, 14.5, 11].

    // Example 2:
    // Input: root = [3,9,20,15,7]
    // Output: [3.00000,14.50000,11.00000]
    public List<Double> averageOfLevels_BFS(TreeNode root) {
        // level order traversal
        // uses a q to keep track of nodes to visit. after visiting each node it's children are put in a queue
        // to get a new node to traverse we take out elements from the q

        List<Double> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        resultList.add((double) root.val);

        int level = 0;
        int count = 0;
        double sum = 0;

        queue.add(root);
        queue.add(null); // add null at the end of each level, so when all nodes in that level are reached, reset count/sum

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                level++;

                Double result = sum / (double) count;
                if (!result.isNaN()) {
                    resultList.add(result);
                }
                count = 0;
                sum = 0;

                queue.add(null);
                if (queue.peek() == null) {
                    break; // two consecutive nulls means all nodes have been visited
                }
                else {
                    continue;
                }
            }

            if (temp.left != null) {
                count++;
                sum += temp.left.val;
                queue.add(temp.left);
            }

            if (temp.right != null) {
                count++;
                sum += temp.right.val;
                queue.add(temp.right);
            }
        }

        return resultList;
    }


    // 2,147,483,647.0

    // Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    public void setZeros(int[][] matrix) {
        HashMap<Integer, Integer> hashCols = new HashMap<>();

        boolean zeroFound;
        for (int i = 0; i < matrix.length; i++) {
            zeroFound = false;

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    hashCols.put(j, i); // keep track of j, the column value
                    zeroFound = true;
                }
            }

            if (zeroFound) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (hashCols.get(j) != null) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


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

    // Given a string s, return the longest palindromic substring in s.
    // A string is palindromic if it reads the same forward and backward.
    //    Input: s = "babad"
    //    Output: "bab"
    //    Explanation: "aba" is also a valid answer.
    public String longestPalindrome(String s) {
        return s;
    }

    public boolean isPal(String str) {
        String strReversed = new StringBuilder(str).reverse().toString();
        return str.equals(strReversed);
    }



    // Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", ""); // regex will remove everything that's NOT alphanumeric
        StringBuilder revStr = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            revStr.append(s.charAt(i));
        }

        return s.toUpperCase().equals(revStr.toString().toUpperCase());
    }



    // Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    // An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    // typically using all the original letters exactly once.
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> resultList = new ArrayList<>();
        if (strs.length == 1) {
            resultList.add(new ArrayList<>(Arrays.asList(strs[0])));
            return resultList;
        }

        HashMap<String, String> stringHash = new HashMap<>();
        for (String s : strs) {
            String[] arr = s.split("");
            Arrays.sort(arr);
            String sortedString = Arrays.toString(arr).replaceAll("[^a-z]", "");

            if (stringHash.get(sortedString) == null) {
                stringHash.put(sortedString, s);
            }
            else {
                String str = stringHash.get(sortedString);
                str += "/" + s;
                stringHash.put(sortedString, str);
            }
        }

        for (Map.Entry<String, String> entry : stringHash.entrySet()) {
            resultList.add(new ArrayList<>(Arrays.asList(entry.getValue().split("/"))));
        }

        System.out.println(resultList);
        return resultList;
    }


    // 338. Counting Bits
    // Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
    // ans[i] is the number of 1's in the binary representation of i.

    // Example 1:
    //
    // Input: n = 2
    // Output: [0,1,1]
    // Explanation:
    // 0 --> 0
    // 1 --> 1
    // 2 --> 10

    // Example 2:
    //
    // Input: n = 5
    // Output: [0,1,1,2,1,2]
    // Explanation:
    // 0 --> 0
    // 1 --> 1
    // 2 --> 10
    // 3 --> 11
    // 4 --> 100
    // 5 --> 101

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
//            String str = Integer.toBinaryString(i).replace("0", "");
//            str = str.replace("0", "");
//            result[i] = str.length();
            result[i] = Integer.bitCount(i); // this returns number of "one" bits in an int
            // much faster
        }

        return result;
    }


    // Given two strings s and t , write a function to determine if t is an anagram of s.
    public boolean isAnagram(String s, String t) {
        int length = 0;
        if (s.length() != t.length()) {
            return false;
        }
        else {
            length = s.length();
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (sMap.get(s.charAt(i)) == null) {
                sMap.put(s.charAt(i), 1);
            }
            else {
                int quantity = sMap.get(s.charAt(i));
                sMap.put(s.charAt(i), ++quantity);
            }

            if (tMap.get(t.charAt(i)) == null) {
                tMap.put(t.charAt(i), 1);
            }
            else {
                int quantity = tMap.get(t.charAt(i));
                tMap.put(t.charAt(i), ++quantity);
            }
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
//            System.out.println(entry);
            if (tMap.get(entry.getKey()) == null) {
                return false;
            }
            else if (tMap.get(entry.getKey()) != null && !tMap.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }

        return true;
    }


    public int improvedMaxArea(int[] height) { // not my solution
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right-left));
            if (height[left] < height[right]) {
                left++;
            }
            else {
                 right--;
            }
        }
        return maxArea;
    }


    public int maxArea(int[] height) {
        int widthVal;
        int maxArea = 0;
        int tempArea;

        for (int i = 0; i < height.length; i++) {
            System.out.println("i ==> height[" + i + "] = " + height[i]);

            for (int j = height.length-1; j > i; j--) {
                System.out.println("j ==> height[" + j + "] = " + height[j]);
                widthVal = j - i;
                System.out.println("widthVal: " + widthVal);
                tempArea = widthVal * Math.min(height[j], height[i]);
                System.out.println("tempArea: " + tempArea);

                if (tempArea > maxArea) {
                    maxArea = tempArea;
                    System.out.println("maxArea: " + maxArea);
                }
            }
        }

        return maxArea;
    }


    // Given an integer array nums, find the contiguous subarray (containing at least one number)
    // which has the largest sum and return its sum.
    // Follow up: If you have figured out the O(n) solution,
    // try coding another solution using the divide and conquer approach, which is more subtle.
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) { // <-- Kadane's algorithm
            currentSum = Math.max(0, currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }


    // Given an array nums of n integers where n > 1,
    // return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
    // Constraint: It's guaranteed that the product of the elements of any prefix
    // or suffix of the array (including the whole array) fits in a 32 bit integer.
    // Note: Please solve it without division and in O(n).
    public int[] productExceptSelf(int[] nums) { // not my solution
        int numsLength = nums.length;
        int[] result = new int[numsLength];
        int right = 1, left = 1;

        System.out.println(Arrays.toString(nums));
        Arrays.fill(result, 1);
        System.out.println(Arrays.toString(result));

        for (int i = 0; i < numsLength; i++) {
            result[i] *= left;
            System.out.println("result[i] * left ==> " + result[i] + " * " + left);
            left *= nums[i];
//            System.out.println("left is: " + left  + " * " + nums[i]);
        }
        System.out.println(Arrays.toString(result));

        for (int i = numsLength - 1; i >= 0; i--) {
            result[i] *= right;
            System.out.println("result[i] * right ==> " + result[i] + " * " + right);
            right *= nums[i];
//            System.out.println("right is: " + right + " * " + nums[i]);
        }

        return result;
    }



    // Given an array of integers, find if the array contains any duplicates.
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) != null) {
                return true;
            }
            else {
                hashMap.put(nums[i], i);
            }
        }
        return false;
    }



    // Say you have an array for which the ith element is the price of a given stock on day i.
    // If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock)
    // design an algorithm to find the maximum profit.

    public int betterMaxProfit(int[] prices) { // not my solution
        System.out.println("prices: " + Arrays.toString(prices));
        int lowest = Integer.MAX_VALUE;
        int currentProfit;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (lowest > prices[i]) {
                lowest = prices[i];
            }

            currentProfit = prices[i] - lowest;

            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }

        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int buyVal = Integer.MAX_VALUE;
        int sellVal = 0;

        if (prices.length == 1) {
            return sellVal;
        }

        for (int i = 0; i < prices.length; i++) { // O(n^2)
            if (buyVal > prices[i]) {
                for (int j = i; j < prices.length; j++) { // check the future
                    if (prices[j] - prices[i] > sellVal - buyVal) {
                        buyVal = prices[i];
                        sellVal = prices[j];
                        break;
                    }
                }
            }
            else if (sellVal < prices[i]) {
                sellVal = prices[i];
            }
        }
        System.out.println("buyVal: " + buyVal);
        System.out.println("sellVal: " + sellVal);

        if (sellVal == 0 || buyVal > sellVal) {
            return 0;
        }

        return sellVal - buyVal;
    }


    // 1. Two Sum
    // Given an array of integers nums and integer target,
    // return the indices of the two numbers such that they add up to target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    // You can return the answer in any order.

    public int[] twoSumWithBetterRunTime(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) != null) {
                int hashNum = hashMap.get(nums[i]);

                if (nums[i] + nums[hashNum] == target && i != hashNum) {
                    result[0] = i;
                    result[1] = hashNum;
                    return result;
                }
            }
        }

        return result;
    }


    public int[] twoSum(int[] nums, int target) {
        int[] resultArr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) { // O(n^2)

                if (nums[i] + nums[j] == target) {
                    resultArr[0] = i;
                    resultArr[1] = j;
                    return resultArr;
                }
            }
        }

        // somehow this solution used less memory than all other submissions on leetcode
        // but leetcode is retarded so prob doesn't matterr
        return null;
    }



    // Given an m x n grid filled with non-negative numbers,
    // find a path from top left to bottom right which minimizes the sum of all numbers along its path.
    // Note: You can only move either down or right at any point in time.
    public int minPathSum(int[][] grid) { // TODO investigate further
        System.out.println(Arrays.deepToString(grid));
        for(int i = 1; i < grid.length; i++) {
            System.out.println("-- > " + Arrays.toString(grid[i]));
            grid[i][0] = grid[i-1][0] + grid[i][0];
            System.out.println(grid[i-1][0] + " + " + grid[i][0]);
        }
        System.out.println(Arrays.deepToString(grid));
        for(int j = 1; j < grid[0].length; j++) {
            grid[0][j] = grid[0][j-1] + grid[0][j];
        }

        System.out.println(Arrays.deepToString(grid));
        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }
        System.out.println(Arrays.deepToString(grid));
        return grid[grid.length-1][grid[0].length-1];

    }


    // You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    // You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
    // DO NOT allocate another 2D matrix and do the rotation

    // Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    // Output: [[7,4,1],[8,5,2],[9,6,3]]

    // Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
    // Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

    public int[][] rotate(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        else if (matrix.length == 1) {
            return matrix;
        }

        for (int i = 0; i < matrix.length; i++) { // transpose matrix
            for (int j = 0; j < matrix[i].length; j++) {
                if (j >= i) {
                    System.out.print(matrix[i][j] + " <--> " + matrix[j][i] + "\t\t\t" + "i:" + i + ", j:" + j  + "\n");
                    int x = matrix[i][j];
                    int y = matrix[j][i];
                    matrix[i][j] = y;
                    matrix[j][i] = x;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) { // reverse each sub array
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = temp;
            }
        }
        return matrix;
    }


    // Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    //    Symbol       Value
    //    I             1
    //    V             5
    //    X             10
    //    L             50
    //    C             100
    //    D             500
    //    M             1000

    //    For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II.
    //    The number 27 is written as XXVII, which is XX + V + II.

    //    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
    //    Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
    //    The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    //    I can be placed before V (5) and X (10) to make 4 and 9.
    //    X can be placed before L (50) and C (100) to make 40 and 90.
    //    C can be placed before D (500) and M (1000) to make 400 and 900.
    //    Constraints: 1 <= num <= 3999

    public String intToRoman(int num) { // not finished
        int numHolder = num;
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> map = new LinkedHashMap<>(); // preserves the insertion order
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);

        while (num > 0) {
            int tempNum = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (num >= entry.getValue() && num >= num - entry.getValue()) {
                    answer.append(entry.getKey());
                    num = num - entry.getValue();
                    System.out.println("num: " + num + ", answer: " + answer);
                    break;
                }
            }
        }

        System.out.println("answer: " + answer.toString());
        String str = answer.toString();
        if (numHolder < 10) {
            str = str.replace("VIIII", "IX");
        }
        else {
            str = str.replace("DCCCC", "CM").replace("LXXXX", "XC").replace("IIII", "IV");
        }
        return str;
    }


    // 136. Single Number

    // Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    // You must implement a solution with a linear runtime complexity and use only constant extra space.
    // Example 1:
    //
    //Input: nums = [2,2,1]
    //Output: 1
    //Example 2:
    //
    //Input: nums = [4,1,2,1,2]
    //Output: 4
    //Example 3:
    //
    //Input: nums = [1]
    //Output: 1

    public int singleNumber(int[] nums) { // not my solution
        int answer = nums[0];

        int i = 0;

        while (i < nums.length - 1) {
            int n = nums[i + 1];
            answer = answer ^ n; // XOR bit manipulation
            i++;
        }

        return answer;
    }


    // 268. Missing Number
    // Given an array nums containing n distinct numbers in the range [0, n],
    // return the only number in the range that is missing from the array.
    // Input: nums = [3,0,1]
    // Output: 2
    // Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
    // 2 is the missing number in the range since it does not appear in nums.

    public int missingNumber(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            count = count - nums[i];
            count = count + i+1;

        }

        return count;
    }

    public void callRunningSum() {
        int[] arr;
        arr = runningSum(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(arr));
        arr = runningSum(new int[]{1,1,1,1,1});
        System.out.println(Arrays.toString(arr));
        arr = runningSum(new int[]{3,1,2,10,1});
        System.out.println(Arrays.toString(arr));
    }

    // Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    // Return the running sum of nums.
    // Input: nums = [1,2,3,4]
    // Output: [1,3,6,10]
    // Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
    public int[] runningSum(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int[] resultArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                resultArr[i] = nums[i];
            }
            else {
                int temp = 0;
                for (int j = 0; j <= i; j++) {
                    temp += nums[j];
                }
//                System.out.println("temp: " + temp);
                resultArr[i] = temp;
            }
        }
        return resultArr;
    }


    // Given an array of integers nums.
    // A pair (i,j) is called good if nums[i] == nums[j] and i < j.
    // Return the number of good pairs.
    public int numIdenticalPairs(int[] nums) {
        int pairCount = 0;
        if (nums.length < 2) {
            return pairCount;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    pairCount++;
                }
            }
        }
        return pairCount;
    }



    // Given a collection of distinct integers, return all possible permutations.
    public List<List<Integer>> permute(int[] nums) { // TODO investigate further
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> finalResult = new ArrayList<>();
        permuteRecur(nums, finalResult, new ArrayList<>(), new boolean[nums.length]);
        return finalResult;
    } // not my solution

    private void permuteRecur(int[] nums, List<List<Integer>> finalResult, List<Integer> currResult, boolean[] used) {
        System.out.println("currResult: " + currResult);
        System.out.println("used: " + Arrays.toString(used));
        System.out.println("nums: " + Arrays.toString(nums) + " \n");

        System.out.println(finalResult.get(0).get(0));

        if (currResult.size() == nums.length) {
            finalResult.add(new ArrayList<>(currResult));
            System.out.println("finalResult: " + finalResult);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue; // go to next iteration
            }
            currResult.add(nums[i]);
            used[i] = true;
            permuteRecur(nums, finalResult, currResult, used);
            used[i] = false;
            currResult.remove(currResult.size() - 1);
        }
        System.out.println("----------------------------------------------");
    }


    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        if (s.length() == 1) {
            return 0;
        }
        else if (arr.length == 0 || arr.length == 1) {
            return s.length();
        }

        return arr[arr.length-1].length();
    }


    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid.
    public boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        if (s.startsWith(")") || s.startsWith("]") || s.startsWith("}") ||
            s.endsWith("(") || s.endsWith("[") || s.endsWith("{")) {

            return false;
        }
        if (!(s.length() % 2 == 0)) {
            return false;
        }

        String str = removeProperty(s);
        if (str.length() > 0) {
            return false;
        }
        return true;
    }

    public String removeProperty(String str) {
        System.out.println("Calling... removeProperty: " + str);
        ArrayList<String> openerList = new ArrayList<>(Arrays.asList("(", "[", "{"));
        ArrayList<String> closerList = new ArrayList<>(Arrays.asList(")", "]", "}"));

        String[] arr = str.split("");

        for (int i = 0; i < arr.length-1; i++) {
            if (openerList.indexOf(arr[i]) == closerList.indexOf(arr[i+1]) && openerList.indexOf(arr[i]) > -1 && closerList.indexOf(arr[i+1]) > -1) {
                str = str.replace(arr[i]+arr[i+1], "");
                return removeProperty(str);
            }
        }
        return str;
    }



    public int reverse(int x) {
        long reverseNum=0;
        do {
            long remainder = x % 10;
            x = x/10;
            reverseNum = reverseNum*10 + remainder;
        }
        while (x!=0);

        if (reverseNum >= Integer.MIN_VALUE && reverseNum <= Integer.MAX_VALUE) {
            return (int) reverseNum;
        }
        return 0;
    }


    // Given a 32-bit signed integer, reverse digits of an integer.
    public int reverseInteger(int x) { // finished but has shit test cases on leetCode, so fuck you close enough
        System.out.println("reverseInteger( " + x + " )");

        String str = String.valueOf(x);
        if (str.length() == 1) {
            return x;
        }

        char[] charArray = str.toCharArray();
        String newStr = "";

        for (int i = charArray.length - 1; i >= 0; i--) {
            newStr = newStr + ""+charArray[i];
        }

        if (newStr.contains("-")) {
            newStr = newStr.replaceAll("-", "");
            newStr = "-" + newStr;
        }

        return Integer.parseInt(newStr);
    }



    //    Given a string containing digits from 2-9 inclusive,
    //    return all possible letter combinations that the number could represent.
    public List<String> letterCombinations(String digits) {
        System.out.println("Calling... letterCombinations( " + digits + " )");
        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();
        hashMap.put(2, new ArrayList(Arrays.asList("a", "b", "c")));
        hashMap.put(3, new ArrayList(Arrays.asList("d", "e", "f")));
        hashMap.put(4, new ArrayList(Arrays.asList("g", "h","i")));
        hashMap.put(5, new ArrayList(Arrays.asList("j", "k","l")));
        hashMap.put(6, new ArrayList(Arrays.asList("m", "n", "o")));
        hashMap.put(7, new ArrayList(Arrays.asList("p", "q", "r", "s")));
        hashMap.put(8, new ArrayList(Arrays.asList("t", "u", "v")));
        hashMap.put(9, new ArrayList(Arrays.asList("w", "x", "y", "z")));

        ArrayList<String> firstLetterList = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();

        if (digits == null || digits.equals("") || digits.equals(" ")) {
            return answer;
        }
        else if (digits.length() == 1) {
            return hashMap.get(Integer.parseInt(digits));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            nums.add(Integer.parseInt(""+digits.charAt(i)));
        }

        firstLetterList.addAll(hashMap.get(nums.get(0)));
        nums.remove(nums.get(0));



        for (Integer i : nums) { // "2", "3"
            System.out.println(hashMap.get(i));
            for (String firstChar : firstLetterList) { // [a, b, c]

                for (String str : hashMap.get(i)) {
                    System.out.println(firstChar + " + " + str);
//                    answer.add(tempStr + str);

                    if (answer.size() > 0) {
                        answer.add(firstChar + str);

                        for (String ans : answer) {
                            if (!ans.contains(str) && ans.length() < digits.length()) {
                                System.out.println("ans : " + ans + " + " + str);
//                                answer.get(answer.indexOf(ans))
                                answer.set(answer.indexOf(ans), ans + str);
                            }
                            else {
                                // check "str" in each "ans"
//                                System.out.println(" -->" + firstChar + str);
//                                for ()
                            }
                        }

                    }
                    else {
                        answer.add(firstChar + str);
                    }
                    System.out.println(answer);
                }
            }
        }

        return answer;
    }

    public static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach((row) -> {
            System.out.print("[");
            Arrays.stream(row).forEach((el) -> System.out.print(" " + el + " "));
            System.out.println("]");
        });
    }



}











