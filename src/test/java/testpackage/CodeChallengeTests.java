package testpackage;

import com.practice.challenges.*;
import com.practice.misc.NumArray;
import com.practice.udemy.UdemyPractice;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CodeChallengeTests {

    public static final Challenges c = new Challenges();
    public static final ArrayChallenges a = new ArrayChallenges();
    public static final LinkedListChallenges l = new LinkedListChallenges();
    public static final StringChallenges s = new StringChallenges();
    public static final UdemyPractice u = new UdemyPractice();
    public static final OtherChallenges o = new OtherChallenges();

    @Test
    public void testTwoSumWithBetterRunTime() {
        assertArrayEquals(new int[]{2, 4}, c.twoSumWithBetterRunTime(new int[]{2, 7, 11, 15, 4}, 15));
        assertArrayEquals(new int[]{2, 4}, c.twoSumWithBetterRunTime(new int[]{-1, -2, -3, -4, -5}, -8));
        assertArrayEquals(new int[]{0, 1}, c.twoSumWithBetterRunTime(new int[]{3, 3}, 6));
        assertArrayEquals(new int[]{0, 2}, c.twoSumWithBetterRunTime(new int[]{3,2,3}, 6));
        assertArrayEquals(new int[]{1, 2}, c.twoSumWithBetterRunTime(new int[]{3,2,4}, 6));
    }

    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[]{0, 1}, a.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, a.twoSum(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{0, 1}, a.twoSum(new int[]{3, 3}, 6));
    }

    @Test
    public void testSearch() {
        assertEquals(4, a.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(-1, a.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    @Test
    public void testMaxProfit() {
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
        assertEquals(Arrays.asList(2), a.findDisappearedNumbers(new int[]{1, 1}));
        assertEquals(Arrays.asList(), a.findDisappearedNumbers(new int[]{1}));
        assertEquals(Arrays.asList(5,6), a.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    @Test
    public void testFindDisappearedNumbers_improvedMemory() {
        assertEquals(Arrays.asList(5,6), c.findDisappearedNumbers_improvedMemory(new int[]{4,3,2,7,8,2,3,1}));
        assertEquals(Arrays.asList(2), c.findDisappearedNumbers_improvedMemory(new int[]{1, 1}));
        assertEquals(Arrays.asList(), c.findDisappearedNumbers_improvedMemory(new int[]{1}));
    }
    @Test
    public void testFindDisappearedNumbers_improvedMemory2() {
        assertEquals(Arrays.asList(5,6), a.findDisappearedNumbers_improvedMemory2(new int[]{4,3,2,7,8,2,3,1}));
        assertEquals(Arrays.asList(2), a.findDisappearedNumbers_improvedMemory2(new int[]{1, 1}));
        assertEquals(Arrays.asList(), a.findDisappearedNumbers_improvedMemory2(new int[]{1}));
    }

    @Test
    public void testIsPalendrome() {
        assertTrue(c.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(c.isPalindrome("race a car"));
        assertTrue(c.isPalindrome("racecar"));
        assertFalse(c.isPalindrome("0P"));
    }

    @Test
    public void testGroupAnagrams() {
        String[] arr = new String[]{"eat","tea","tan","ate","nat","bat"}; // [[eat, tea, ate], [bat], [tan, nat]]
        ArrayList<List<String>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>(Arrays.asList("eat", "tea", "ate")));
        resultList.add(new ArrayList<>(Arrays.asList("bat")));
        resultList.add(new ArrayList<>(Arrays.asList("tan", "nat")));
        assertEquals(c.groupAnagrams(arr), resultList);
    }


    @Test
    public void testCountBits() {
        assertArrayEquals(new int[]{0, 1, 1}, a.countBits(2));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, a.countBits(5));
    }

    @Test
    public void testIsAnagram() {
        assertTrue(c.isAnagram("anagram", "nagaram"));
        assertFalse(c.isAnagram("rat", "car"));
    }

    @Test
    public void testMissingNumber() {
        assertEquals(2, a.missingNumber(new int[]{3,0,1}));
        assertEquals(8, a.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    @Test
    public void testLongestPalindrome() {
        assertEquals("babad", c.longestPalindrome("babad"));
    }

    @Test
    public void testLetterCombinations() {  // not done
        List<String> str;
        str = c.letterCombinations("23"); //Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        System.out.println("answer: " + str);
        str = c.letterCombinations("234"); // ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
        System.out.println("answer: " + str);
    }

    @Test
    public void testIntToRoman() { // not done
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
        a.setZeros(matrix);

        matrix = new int[3][];
        ar1 = new int[]{0, 1, 2, 0};
        ar2 = new int[]{3, 4, 5, 2};
        ar3 = new int[]{1, 3, 1, 5};
        matrix[0] = ar1;
        matrix[1] = ar2;
        matrix[2] = ar3;
        a.setZeros(matrix);
    }


    @Test
    public void testSingleNumber() {
        assertEquals(1, a.singleNumber(new int[]{2, 2, 1}));
        assertEquals(4, a.singleNumber(new int[]{4,1,2,1,2}));
        assertEquals(4, a.singleNumber(new int[]{1,1,3,3,4}));
        // somehow XOR bitwise operations on each element magically returns the fucking solution
    }


    @Test
    public void testlNumIdenticalPairs() {
        assertEquals(4, a.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        assertEquals(6, a.numIdenticalPairs(new int[]{1,1,1,1}));
        assertEquals(0, a.numIdenticalPairs(new int[]{1,2,3}));
    }

    @Test
    public void testPermute() {
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
    public void testLengthOfLastWord() {
        assertEquals(5, s.lengthOfLastWord("Hello world"));
        assertEquals(5, s.lengthOfLastWord("     "));
    }

    @Test
    public void testIsValid() {
        assertTrue(s.isValid("()"));
        assertFalse(s.isValid("))"));
        assertFalse(s.isValid("())"));
        assertTrue(s.isValid("()[]{}"));
        assertFalse(s.isValid("([)]"));
        assertTrue(s.isValid("{{({})}}"));
        assertFalse(s.isValid("["));
    }

    @Test
    public void testReverseInteger() {
        assertEquals(321, c.reverseInteger(123));
        assertEquals(321, c.reverseInteger(-123));

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
    public void testContainsDuplicate() {
        assertTrue(a.containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void testProductExceptSelf() {
        assertArrayEquals(new int[]{24, 12, 8, 6}, c.productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testNumArray() {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        assertEquals(1 ,numArray.sumRange(0, 2));
        assertEquals(-1, numArray.sumRange(2, 5));
        assertEquals(-3, numArray.sumRange(0, 5));
    }

    @Test
    public void testMinPathSum() {
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
    public void testRunningSum() {
        assertArrayEquals(new int[]{1, 3, 6, 10}, a.runningSum(new int[]{1,2,3,4}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, a.runningSum(new int[]{1,1,1,1,1}));
        assertArrayEquals(new int[]{3, 4, 6, 16, 17}, a.runningSum(new int[]{3,1,2,10,1}));
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

    @Test
    public void testFindReoccurringNumber() {
        int[] arr1 = new int[]{2,5,1,2,3,5,1,2,4}; // should return 2
        u.findReoccurringNumber(arr1);
        int[] arr2 = new int[]{2,1,1,2,3,5,1,2,4}; // should return 1
        u.findReoccurringNumber(arr2);
        int[] arr3 = new int[]{2,3,4,5}; // should return default
        u.findReoccurringNumber(arr3);
    }

    @Test
    public void callLengthOfLongestSubstring() {
        int n;
        n = o.lengthOfLongestSubstring("abcabcbb"); // 'abc' is the longest substring return 3
        System.out.println("answer: " +n + " -- 3");
        n = o.lengthOfLongestSubstring("");
        System.out.println("answer: " +n + " -- 0");
        n = o.lengthOfLongestSubstring(" ");
        System.out.println("answer: " +n + " -- 1");
        n = o.lengthOfLongestSubstring("au");
        System.out.println("answer: " +n + " -- 2");
        n = o.lengthOfLongestSubstring("bbbbb"); // 1
        System.out.println("answer: " +n + " -- 1");
        n = o.lengthOfLongestSubstring("dvdf"); // 3
        System.out.println("answer: " +n + " -- 3");
        n = o.lengthOfLongestSubstring("pwwkew"); // 3
        System.out.println("answer: " +n + " -- 3");
    }

    @Test
    public static void testRearrangeWord() {
        System.out.println("abc --> " + o.rearrangeWord("abc")); // bcaa
        System.out.println("baca --> " + o.rearrangeWord("baca")); // bcaa
        System.out.println("hefg --> " + o.rearrangeWord("hefg")); // hegf
    }

    public static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach((row) -> {
            System.out.print("[");
            Arrays.stream(row).forEach((el) -> System.out.print(" " + el + " "));
            System.out.println("]");
        });
    }

}
