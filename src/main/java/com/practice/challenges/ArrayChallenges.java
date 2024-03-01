package com.practice.challenges;

import java.util.*;

public class ArrayChallenges {

    public static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach((row) -> {
            System.out.print("[");
            Arrays.stream(row).forEach((el) -> System.out.print(" " + el + " "));
            System.out.println("]");
        });
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

    // 338. Counting Bits
    // Given an integer n, return an array and of length n + 1 such that for each i (0 <= i <= n),
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


    // 977. Squares of a Sorted Array
    // Given an integer array nums sorted in non-decreasing order,
    // return an array of the squares of each number sorted in non-decreasing order.
    //
    // Example 1:
    //
    // Input: nums = [-4,-1,0,3,10]
    // Output: [0,1,9,16,100]
    // Explanation: After squaring, the array becomes [16,1,0,9,100].
    // After sorting, it becomes [0,1,9,16,100].

    // Example 2:
    //
    // Input: nums = [-7,-3,2,3,11]
    // Output: [4,9,9,49,121]

    // Follow up: Squaring each element and sorting the new array is very trivial,
    // could you find an O(n) solution using a different approach?
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) { // O(n)
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums); // adds O(n logn) complexity
        return nums;
    }

    // two pointers solution
    public int[] sortedSquares_betterRuntime(int[] nums) { // not my solution
        int n, m;
        int[] result = new int[nums.length];

        int i = 0;                  // points to beginning of arr
        int j = nums.length - 1;    // points to end of arr

        int e = nums.length - 1;

        while (i < j) {
            n = (int) Math.pow(nums[j], 2);
            m = (int) Math.pow(nums[i], 2);

            if (n > m) {
                result[e] = n;
                j--;
            }
            else {
                result[e] = m;
                i++;
            }
            e--;
        }

        result[e] = ((int) Math.pow(nums[i], 2));
        return result;
    }


    // 844. Backspace String Compare
    // Given two strings s and t, return true if they are equal when both are typed into empty text editors.
    // '#' means a backspace character.
    //
    // Note that after backspacing an empty text, the text will continue empty.
    //
    // Example 1:
    //
    // Input: s = "ab#c", t = "ad#c"
    // Output: true
    // Explanation: Both s and t become "ac".
    // Example 2:
    //
    // Input: s = "ab##", t = "c#d#"
    // Output: true
    // Explanation: Both s and t become "".
    // Example 3:
    //
    // Input: s = "a#c", t = "b"
    // Output: false
    // Explanation: s becomes "c" while t becomes "b".

    // Follow up: Can you solve it in O(n) time and O(1) space?
    public boolean backSpaceCompare(String s, String t) {
        return this.delComparer(s).equals(this.delComparer(t));
    }

    public Stack<Character> delComparer(String s) {
        Stack<Character> stack = new Stack<Character>();
        //  ^ O(n) space complexity

        int delsFound = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#' && delsFound == 0) {
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i) == '#') {
                stack = this.stackPopper(stack, delsFound);
                delsFound = 0;
            }
            else {
                delsFound++;
            }
        }

        return stack;
    }

    private Stack<Character> stackPopper(Stack<Character> stack, int dels) {
        for (int i = 0; i <= dels; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return stack;
    }

    // 169. Majority Element
    // Given an array nums of size n, return the majority element.
    //
    // The majority element is the element that appears more than ⌊n / 2⌋ times.
    // You may assume that the majority element always exists in the array.
    //
    // Example 1:
    //
    // Input: nums = [3,2,3]
    // Output: 3
    // Example 2:
    //
    // Input: nums = [2,2,1,1,1,2,2]
    // Output: 2

    // Follow-up: Could you solve the problem in linear time and in O(1) space?
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); // key: nums, value: frequency
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            }
            else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        int highestFrequency = 0;
        int keyVal = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > highestFrequency) {
                highestFrequency = entry.getValue();
                keyVal = entry.getKey();
            }
        }
        return keyVal;
    }

    public int majorityElement_ConstantSpace(int[] nums) { // not my solution
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 2022. Convert 1D Array Into 2D Array
    // Easy
    // Topics
    // Companies
    // Hint
    // You are given a 0-indexed 1-dimensional (1D) integer array original, and two integers, m and n.
    // You are tasked with creating a 2-dimensional (2D) array with  m rows and n columns using all the elements from original.
    //
    // The elements from indices 0 to n - 1 (inclusive) of original should form the first row of the constructed 2D array,
    // the elements from indices n to 2 * n - 1 (inclusive) should form the second row of the constructed 2D array, and so on.
    //
    // Return an m x n 2D array constructed according to the above procedure, or an empty 2D array if it is impossible.
    //
    // Example 1:
    //
    //
    // Input: original = [1,2,3,4], m = 2, n = 2
    // Output: [[1,2],[3,4]]
    // Explanation: The constructed 2D array should contain 2 rows and 2 columns.
    // The first group of n=2 elements in original, [1,2], becomes the first row in the constructed 2D array.
    // The second group of n=2 elements in original, [3,4], becomes the second row in the constructed 2D array.

    // Example 2:
    //
    // Input: original = [1,2,3], m = 1, n = 3
    // Output: [[1,2,3]]
    // Explanation: The constructed 2D array should contain 1 row and 3 columns.
    // Put all three elements in original into the first row of the constructed 2D array.

    // Example 3:
    //
    // Input: original = [1,2], m = 1, n = 1
    // Output: []
    // Explanation: There are 2 elements in original.
    // It is impossible to fit 2 elements in a 1x1 2D array, so return an empty 2D array.
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return null;
        }
        int matrix[][] = new int[m][n];
        return null;
    }
}








