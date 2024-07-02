package com.practice.challenges;

import java.util.*;
import java.util.function.IntToDoubleFunction;

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
        this.backtrackPermute(resultList, new ArrayList<>(), nums);
        return resultList;
    }

    public void backtrackPermute(List<List<Integer>> list, List<Integer> tempList, int[] nums) { // todo not done learning this
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue; // element already exists
                }

                tempList.add(nums[i]);
                this.backtrackPermute(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
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

    public boolean traverseBoard(char[][] board, int i, int j, String str, String word, int index, HashMap<String, Character> map) { // mostly correct solution
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || str.length() == word.length() || map.get(i + "," + j) != null) {
            return str.equals(word);
        }
        else if (word.charAt(index) == board[i][j]) {
            map.put(i + "," + j, word.charAt(index)); // save coordinates of visited node
            str += word.charAt(index);
            index++;

            // issue with this solution is likely it's returning to early
            return this.traverseBoard(board, i-1, j, str, word, index, map) || // up
                    this.traverseBoard(board, i+1, j, str, word, index, map) || // down
                    this.traverseBoard(board, i, j-1, str, word, index, map) || // left
                    this.traverseBoard(board, i, j+1, str, word, index, map); // right
            // this also failed because it lacks any backtracking implementation
        }

        return false;
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
