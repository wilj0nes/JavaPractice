package com.practice.challenges.singleChallengeClasses;

import com.practice.misc.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {

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

    public List<double[]> store = new ArrayList<>();
    public List<Double> averageOfLevels_DFS(TreeNode node) { // not my solution

        List<Double> resultList = new ArrayList<>();
        traverse(node, 0);
        for (double[] val : store) {
            resultList.add(val[0] / val[1]);
        }
        return resultList;
    }

    private void traverse(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (store.size() <= level) {
            store.add(new double[2]);
        }

        store.get(level)[0] += node.val;
        store.get(level)[1]++;

        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }

}
