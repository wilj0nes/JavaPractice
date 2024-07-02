package com.practice.challenges.singleChallengeClasses;

import java.util.*;

public class Subsets {

    // 78. Subsets
    // Medium
    // Given an integer array nums of unique elements, return all possible
    // subsets (the power set).
    //
    // The solution set must not contain duplicate subsets. Return the solution in any order.
    //
    // Example 1:
    // Input: nums = [1,2,3]
    // Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

    // Example 2:
    // Input: nums = [0]
    // Output: [[],[0]]
    //
    // Constraints:
    //
    // 1 <= nums.length <= 10
    // -10 <= nums[i] <= 10
    // All the numbers of nums are unique.
    // backtracking example
    public List<List<Integer>> subSets(int[] nums) { // not my solution
        List<List<Integer>> resultList = new ArrayList<>();
        this.backtrack_FORK(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    public void backtrack_FORK(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, int start) { // not my solution
        resultList.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            this.backtrack_FORK(resultList, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    public List<List<Integer>> subSets_ATTEMPT(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>(); // ignores duplicate values
        for (int i = 0; i < nums.length; i++) {
            this.permuteSubSets_BROKEN(nums[i], 0, nums.length-1, resultSet, nums);
        }
        resultSet.add(new ArrayList<>());

        System.out.println(resultSet);
        return new ArrayList<>(resultSet);
    }

    public void permuteSubSets_BROKEN(int val, int startIndex, int endIndex, Set<List<Integer>> resultSet, int[] nums) {
        // doesn't work

        if (startIndex < 0 || endIndex > nums.length) {
            return;
        }

        if (startIndex == endIndex) {
            resultSet.add(new ArrayList<>(Arrays.asList(val))); // end of branch
            return;
        }
        else {
            List<Integer> tempList = new ArrayList<>();
            for (int i = startIndex; i <= endIndex; i++) {
                tempList.add(nums[i]);
            }
            resultSet.add(tempList);
        }

        if (nums[startIndex] == val) { // start
            int tempVal = nums[startIndex + 1];
            nums[startIndex + 1] = val;

            this.permuteSubSets_BROKEN(val, startIndex+1, endIndex, resultSet, nums); // shift val -->
            nums[startIndex + 1] = tempVal; // backtracking
            this.permuteSubSets_BROKEN(val, startIndex, endIndex-1, resultSet, nums); // < -- shift endIndex
        }
        else if (nums[endIndex] == val) { // end
            int tempVal = nums[endIndex - 1];
            nums[endIndex - 1] = val;

            this.permuteSubSets_BROKEN(val, startIndex, endIndex-1, resultSet, nums); // <-- shift val
            nums[endIndex - 1] = tempVal; // backtracking
            this.permuteSubSets_BROKEN(val, startIndex+1, endIndex, resultSet, nums); // shift startIndex -->
        }
        else { // middle
            this.permuteSubSets_BROKEN(val, startIndex, endIndex-1, resultSet, nums); // split val left
            this.permuteSubSets_BROKEN(val, startIndex+1, endIndex, resultSet, nums); // split val right
        }
    }


}
