package com.practice.challenges;

import java.util.*;

public class BacktrackingChallenges {


    // 46. Permutations
    // Medium
    // Topics
    // Companies
    // Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
    //
    //
    // Example 1:
    //
    // Input: nums = [1,2,3]
    // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    //
    // Example 2:
    //
    // Input: nums = [0,1]
    // Output: [[0,1],[1,0]]
    // Example 3:
    //
    // Input: nums = [1]
    // Output: [[1]]
    //
    //
    // Constraints:
    //
    // 1 <= nums.length <= 6
    // -10 <= nums[i] <= 10
    // All the integers of nums are unique.
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        return resultList;
    }



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


    // 79. Word Search
    // Medium
    // Given an m x n grid of characters board and a string word, return true if word exists in the grid.
    // The word can be constructed from letters of sequentially adjacent cells,
    // where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
    //
    // Example 1:
    //
    // Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    // Output: true

    // Example 2:
    // Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    // Output: true

    // Example 3:
    // Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
    // Output: false

    // board and word consists of only lowercase and uppercase English letters.
    // Follow up: Could you use search pruning to make your solution faster with a larger board?
    //Constraints:
    //
    // m == board.length
    // n = board[i].length
    // 1 <= m, n <= 6
    // 1 <= word.length <= 15
    // backtracking example
    public boolean exist(char[][] board, String word) {
//        HashMap<String, Character> coordinateMap = new HashMap<String, Character>();
        for (int i = 0; i < board.length; i++) { // find matching node first
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
//                    if (this.traverseBoard(board, i, j, "", word, 0, coordinateMap)) {
//                        return true;
//                    }
                    if (this.traverseBoard_fork(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    public boolean traverseBoard_fork(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) { // found
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) { // out of bounds
            return false;
        }

        // before exploring neighboring cells the char at position i, j is temporarily replaced by a ' ' to indicate it's been visited
        char tempChar = board[i][j];
        board[i][j] = ' ';
        index++;

        boolean found = this.traverseBoard_fork(board, word, i-1, j, index) || // up
                this.traverseBoard_fork(board, word, i+1, j, index) || // down
                this.traverseBoard_fork(board, word, i, j-1, index) || // left
                this.traverseBoard_fork(board, word, i, j+1, index); // right

        board[i][j] = tempChar; // backtracking, this undoes the change so the next call isn't using corrupted data
        return found;
    }



    // 784. Letter Case Permutation
    // Medium
    // Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
    //
    // Return a list of all possible strings we could create. Return the output in any order.
    //
    // Example 1:
    //
    // Input: s = "a1b2"
    // Output: ["a1b2","a1B2","A1b2","A1B2"]

    // Example 2:
    //
    // Input: s = "3z4"
    // Output: ["3z4","3Z4"]
    //
    // Constraints:
    // 1 <= s.length <= 12
    // s consists of lowercase English letters, uppercase English letters, and digits.
    // backtracking example
    public List<String> letterCasePermutation(String s) { // not my solution
        List<String> resultList = new ArrayList<>();
        this.recurse(s.toCharArray(), 0, resultList);

        return resultList;
    }

    public void recurse(char[] str, int index, List<String> result) {
        if (index == str.length) { // leaf found
            result.add(new String(str));
            return;
        }

        if (Character.isLetter(str[index])) {
            if (Character.isUpperCase(str[index])) { // if uppercase make it lowercase that recurse
                str[index] = Character.toLowerCase(str[index]);

                // start new branch in tree,
                this.recurse(str, index + 1, result);

                // backtracking, undo the change so the code can start a new branch in the recursion tree.
                str[index] = Character.toUpperCase(str[index]);
            }
            else { // else make it uppercase
                str[index] = Character.toUpperCase(str[index]);
                this.recurse(str, index + 1, result);

                // backtracking again for same reason
                str[index] = Character.toLowerCase(str[index]);
            }
        }
        // this branch explores options that are possible
        this.recurse(str, index + 1, result);
    }

    public List<String> letterCasePermutation_attempt(String s) { // failed attempt
        if (s.isEmpty()) {
            return new ArrayList<>();
        }
        Set<String> resultSet = new HashSet<>();
        List<String> resultList = new ArrayList<>();

        s = s.toLowerCase();
        resultSet.add(s);
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {
                String x = this.convertCharArray(charArray, i, Character.toUpperCase(charArray[i]));
                resultSet.add(x);
                resultList.add(x);
            }
        }
        s = s.toUpperCase();
        resultSet.add(s);
        charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {
                String x = this.convertCharArray(charArray, i, Character.toLowerCase(charArray[i]));
                resultSet.add(x);
                resultList.add(x);
            }
        }

        return new ArrayList<>(resultSet);
    }

    public String convertCharArray(char[] charArray, int index, char ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (i != index) {
                sb.append(charArray[i]);
            }
            else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }



}
