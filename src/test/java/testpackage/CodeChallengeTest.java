package testpackage;

import com.practice.leetcode.Challenges;
import com.practice.leetcode.ListNode;
import com.practice.leetcode.NumArray;
import com.practice.leetcode.TreeNode;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CodeChallengeTest {

    public static final Challenges c = new Challenges();

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
    public void testSearch() {
        assertEquals(4, c.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(-1, c.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
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

        assertEquals(node2, c.middleNode(head));
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

        assertEquals(node3, c.middleNode(head));
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

        head = c.reverseList(head);

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

        assertTrue(c.isPalendrome(head));
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

        assertTrue(c.isPalendrome_betterRuntime(head));
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

        assertFalse(c.isPalendrome_betterRuntime(head));
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

        ListNode resultNode = c.mergeTwoLists(node1 , node4);

        while (resultNode.getNext() != null) {
            assertEquals(ans1.getVal(), resultNode.getVal());
            ans1 = ans1.getNext();
            resultNode = resultNode.getNext();
        }
    }

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

        assertTrue(c.hasCycle(head));
    }

    @Test
    public void callMaxProfit() {
        assertEquals(c.betterMaxProfit(new int[]{7, 1, 5, 3, 6, 4}), 5);
        assertEquals(c.betterMaxProfit(new int[]{7, 6, 4, 3, 1}), 0);
        assertEquals(c.betterMaxProfit(new int[]{2, 4, 1}), 2);
        assertEquals(c.betterMaxProfit(new int[]{7, 6, 4, 3, 1}), 0);
        assertEquals(c.betterMaxProfit(new int[]{2, 1, 2, 0, 1}), 1);
        assertEquals(c.betterMaxProfit(new int[]{2, 1, 2, 1, 0, 1, 2}), 2);
        assertEquals(c.betterMaxProfit(new int[]{1, 2}), 1);
        assertEquals(c.betterMaxProfit(new int[]{2, 1, 4}), 3);
        assertEquals(c.betterMaxProfit(new int[]{2,1,2,1,0,0,1}), 1);
        assertEquals(c.betterMaxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}), 4);
    }

    @Test
    public void testClimbStairs() {
        assertEquals(2, c.climbStairs(2));
        assertEquals(3, c.climbStairs(3));
        assertEquals(8, c.climbStairs(5));
    }

    @Test
    public void testClimbStairs_memoization() {
        assertEquals(2, c.climbStairs_memoization(2));
        assertEquals(3, c.climbStairs_memoization(3));
        assertEquals(8, c.climbStairs_memoization(5));
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
        assertTrue(c.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(c.isPalindrome("race a car"));
        assertTrue(c.isPalindrome("racecar"));
        assertFalse(c.isPalindrome("0P"));
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
        assertEquals(str, c.longestPalindrome(str));
    }

    @Test
    public void callLetterCombinations() {  // not done
        List<String> str;
        str = c.letterCombinations("23"); //Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        System.out.println("answer: " + str);

        str = c.letterCombinations("234"); // ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
        System.out.println("answer: " + str);
    }


    @Test
    public void callIntToRoman() {
        assertEquals("MMM", c.intToRoman(3000));
        assertEquals("MCMXCIV", c.intToRoman(1994));
        assertEquals("IX", c.intToRoman(9));
        assertEquals("IX", c.intToRoman(8));
//        assertEquals("//", c.intToRoman(7));
        assertEquals("LVIII", c.intToRoman(58));
        assertEquals("MDCCCXCIV", c.intToRoman(99));
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
    public void callSingleNumber() {
        System.out.println("[2,2,1] : " + c.singleNumber(new int[]{2, 2, 1})); // 1
        System.out.println("[4,1,2,1,2] : " + c.singleNumber(new int[]{4,1,2,1,2})); // 4
        System.out.println("[1,1,2,3,3,4] : " + c.singleNumber(new int[]{1,1,3,3,4})); //
        // somehow XOR bitwise operations on each element magically returns the fucking solution
    }


    @Test
    public void callNumIdenticalPairs() {
        int n;
        n = c.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3});
        System.out.println("pairCount: " + n);
        n = c.numIdenticalPairs(new int[]{1,1,1,1});
        System.out.println("pairCount: " + n);
        n = c.numIdenticalPairs(new int[]{1,2,3});
        System.out.println("pairCount: " + n);
    }

    @Test
    public void callPermute() {
        int[] intArr;
        intArr = new int[]{1,2,3};
        System.out.println(c.permute(intArr));
        //  [1,2,3],
        //  [1,3,2],
        //  [2,1,3],
        //  [2,3,1],
        //  [3,1,2],
        //  [3,2,1]

//        intArr = new int[] {1,2,3,4};
//        System.out.println(permute(intArr));
    }

    @Test
    public void callLengthOfLastWord() {
        int answer;
        answer = c.lengthOfLastWord("Hello world");
        System.out.println("length of last word: " + answer);
        answer = c.lengthOfLastWord("     ");
        System.out.println("length of last word: " + answer);
    }

    @Test
    public void callIsValid() {
        System.out.println("() --> " + c.isValid("()")); // true
        System.out.println(")) --> " + c.isValid("))")); // false
        System.out.println("()) --> " + c.isValid("())")); // false
        System.out.println("()[]{} --> " + c.isValid("()[]{}")); // true
        System.out.println("([)] --> " + c.isValid("([)]")); // false
        System.out.println("{ { ( { } ) } } --> " + c.isValid("{{({})}}")); // true
        System.out.println("[ --> " + c.isValid("[")); // false
    }

    @Test
    public void callReverseInteger() {
        long x;
        x = c.reverseInteger(123); // output: 321
        System.out.println("reversed int: " + x);

        x = c.reverseInteger(-123); // output: 321
        System.out.println("reversed int: " + x);

        // 9,646,324,351 --> 1,534,236,469
//        x = reverse(9646324351); // 9646324351 --> 1534236469

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

    @Test
    public void testMaxSubArray() {
        assertEquals(6, c.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, c.maxSubArray(new int[]{1}));
    }

    @Test
    public void callContainsDuplicate() {
        assertTrue(c.containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void callProductExceptSelf() {
        int[] arr;
        arr = c.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void callNumArray() {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        assertEquals(1 ,numArray.sumRange(0, 2));
        assertEquals(-1, numArray.sumRange(2, 5));
        assertEquals(-3, numArray.sumRange(0, 5));
    }



    @Test
    public void callMinPathSum() {
        int[][] grid = new int[3][];
        int[] ar1 = new int[]{1,3,1};
        int[] ar2 = new int[]{1,5,1};
        int[] ar3 = new int[]{4,2,1};
        grid[0] = ar1;
        grid[1] = ar2;
        grid[2] = ar3;
        System.out.println(c.minPathSum(grid));
    }

    @Test
    public void testRotate() {
        int[][] matrix = new int[3][];
        int[] ar1, ar2, ar3;

        ar1 = new int[]{1, 2, 3};
        ar2 = new int[]{4, 5, 6};
        ar3 = new int[]{7, 8, 9};
        matrix[0] = ar1;
        matrix[1] = ar2;
        matrix[2] = ar3;

        printMatrix(matrix);
        System.out.println("\n");
        printMatrix(c.rotate(matrix));

        int[][] bigMatrix = new int[4][];
        bigMatrix[0] = new int[]{5, 1, 9, 11};
        bigMatrix[1] = new int[]{2, 4, 8, 10};
        bigMatrix[2] = new int[]{13, 3, 6, 7};
        bigMatrix[3] = new int[]{15, 14, 12, 16};

        System.out.println("\n");

        printMatrix(bigMatrix);
        System.out.println("\n");
        printMatrix(c.rotate(bigMatrix));
    }

    public static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach((row) -> {
            System.out.print("[");
            Arrays.stream(row).forEach((el) -> System.out.print(" " + el + " "));
            System.out.println("]");
        });
    }

}