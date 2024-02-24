package testpackage;

import com.practice.leetcode.Challenges;
import com.practice.leetcode.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CodeChallengeTest {

    private static final Challenges c = new Challenges();

    @Test
    public void testCallTwoSumWithBetterRunTime() {
        assertArrayEquals(new int[]{2, 4}, c.twoSumWithBetterRunTime(new int[]{2, 7, 11, 15, 4}, 15));
        assertArrayEquals(new int[]{2, 4}, c.twoSumWithBetterRunTime(new int[]{-1, -2, -3, -4, -5}, -8));
        assertArrayEquals(new int[]{0, 1}, c.twoSumWithBetterRunTime(new int[]{3, 3}, 6));
        assertArrayEquals(new int[]{0, 2}, c.twoSumWithBetterRunTime(new int[]{3,2,3}, 6));
        assertArrayEquals(new int[]{1, 2}, c.twoSumWithBetterRunTime(new int[]{3,2,4}, 6));
    }

    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[]{0, 1}, c.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, c.twoSum(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{0, 1}, c.twoSum(new int[]{3, 3}, 6));
    }

    @Test
    public void testHasCycle() {
        ListNode node3 = new ListNode(-4);
        ListNode node2 = new ListNode(0);
        ListNode node = new ListNode(2);
        ListNode head = new ListNode(3);

        head.setNext(node);
        node.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node);

        assertTrue(c.hasCycle(head));
    }

    @Test
    public void callMaxProfit() {
        int n;
        n = c.betterMaxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("profit (5):" + n);
        assertEquals(n, 5);

        n = c.betterMaxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println("profit (0):" + n);
        assertEquals(n, 0);

        n = c.betterMaxProfit(new int[]{2, 4, 1});
        System.out.println("profit (2):" + n);
        assertEquals(n, 2);

        n = c.betterMaxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println("profit (0):" + n);
        assertEquals(n, 0);


        n = c.betterMaxProfit(new int[]{2, 1, 2, 0, 1});
        System.out.println("profit (1):" + n);
        assertEquals(n, 1);

        n = c.betterMaxProfit(new int[]{2, 1, 2, 1, 0, 1, 2});
        System.out.println("profit (2):" + n);
        assertEquals(n, 2);

        n = c.betterMaxProfit(new int[]{1, 2});
        System.out.println("profit (1):" + n);
        assertEquals(n, 1);

        n = c.betterMaxProfit(new int[]{2, 1, 4});
        System.out.println("profit (3):" + n);
        assertEquals(n, 3);

        n = c.betterMaxProfit(new int[]{2,1,2,1,0,0,1});
        System.out.println("profit (1):" + n);
        assertEquals(n, 1);

        n = c.betterMaxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println("profit (4):" + n);
        assertEquals(n, 4);

    }

    @Test
    public void testClimbStairs() {
        assertEquals(2, c.climbStairs(2));
        assertEquals(3, c.climbStairs(3));
        assertEquals(8, c.climbStairs(5));
    }

    @Test
    public void testClimbStairs_memoization() {
        int n;
        n = c.climbStairs_memoization(2);
        System.out.println("result (2):" + n);
        assertEquals(2, n);

        n = c.climbStairs_memoization(3);
        System.out.println("result (3):" + n);
        assertEquals(3, n);

        n = c.climbStairs_memoization(5);
        System.out.println("result (8):" + n);
        assertEquals(8, n);
    }

    @Test
    public void testFindDisappearedNumbers() {
        assertEquals(Arrays.asList(2), c.findDisappearedNumbers(new int[]{1, 1}));
        assertEquals(Arrays.asList(), c.findDisappearedNumbers(new int[]{1}));
        assertEquals(Arrays.asList(5,6), c.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    @Test
    public void testFindDisappearedNumbers_improvedMemory() {
        assertEquals(Arrays.asList(5,6), c.findDisappearedNumbers_improvedMemory(new int[]{4,3,2,7,8,2,3,1}));
        assertEquals(Arrays.asList(2), c.findDisappearedNumbers_improvedMemory(new int[]{1, 1}));
        assertEquals(Arrays.asList(), c.findDisappearedNumbers_improvedMemory(new int[]{1}));
    }
    @Test
    public void testFindDisappearedNumbers_improvedMemory2() {
        assertEquals(Arrays.asList(5,6), c.findDisappearedNumbers_improvedMemory2(new int[]{4,3,2,7,8,2,3,1}));
        assertEquals(Arrays.asList(2), c.findDisappearedNumbers_improvedMemory2(new int[]{1, 1}));
        assertEquals(Arrays.asList(), c.findDisappearedNumbers_improvedMemory2(new int[]{1}));
    }

    @Test
    public void testIsPalendrome() {
        boolean b;
        b = c.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println("A man, a plan, a canal: Panama --> " + b);
        assertTrue(b);

        b = c.isPalindrome("race a car");
        System.out.println("race a car --> " + b);
        assertFalse(b);

        b = c.isPalindrome("racecar");
        System.out.println("racecar --> " + b);
        assertTrue(b);

        b = c.isPalindrome("0P");
        System.out.println("0P --> " + b);
        assertFalse(b);
    }


    @Test
    public void callGroupAnagrams() {
        String[] arr = new String[]{"eat","tea","tan","ate","nat","bat"}; // [[eat, tea, ate], [bat], [tan, nat]]
        ArrayList<List<String>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>(Arrays.asList("eat", "tea", "ate")));
        resultList.add(new ArrayList<>(Arrays.asList("bat")));
        resultList.add(new ArrayList<>(Arrays.asList("tan", "nat")));
        assertEquals(c.groupAnagrams(arr), resultList);
    }


    @Test
    public void callCountBits() {
        assertArrayEquals(new int[]{0, 1, 1}, c.countBits(2));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, c.countBits(5));
    }

    @Test
    public void testIsAnagram() {
        assertTrue(c.isAnagram("anagram", "nagaram"));
        assertFalse(c.isAnagram("rat", "car"));
    }

    @Test
    public void testMissingNumber() {
        assertEquals(2, c.missingNumber(new int[]{3,0,1}));
        assertEquals(8, c.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    @Test
    public void callLongestPalindrome() {
        String str = "babad";
        System.out.println(str + " longest palindrome --> " + c.longestPalindrome(str));
    }



    @Test
    public void testSetZeros() {
        int[][] matrix = new int[3][];
        int[] ar1, ar2, ar3;

        ar1 = new int[]{1, 1, 1};
        ar2 = new int[]{1, 0, 1};
        ar3 = new int[]{1, 1, 1};
        matrix[0] = ar1;
        matrix[1] = ar2;
        matrix[2] = ar3;
        c.setZeros(matrix);

        matrix = new int[3][];
        ar1 = new int[]{0, 1, 2, 0};
        ar2 = new int[]{3, 4, 5, 2};
        ar3 = new int[]{1, 3, 1, 5};
        matrix[0] = ar1;
        matrix[1] = ar2;
        matrix[2] = ar3;
        c.setZeros(matrix);
    }

    @Test
    public void testMaxArea() {
        assertEquals(49, c.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        assertEquals(16, c.maxArea(new int[]{4, 3, 2, 1, 4}));
        assertEquals(1, c.maxArea(new int[]{1, 1}));
        assertEquals(2, c.maxArea(new int[]{1, 2, 1}));
    }

    @Test
    public void testImprovedMaxArea() {
        assertEquals(49, c.improvedMaxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        assertEquals(16, c.improvedMaxArea(new int[]{4, 3, 2, 1, 4}));
    }


}
