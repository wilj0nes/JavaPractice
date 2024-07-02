package com.practice.challenges.singleChallengeClasses;

import com.practice.misc.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {

    // 111. Minimum Depth of Binary Tree
    // Given a binary tree, find its minimum depth.
    // The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
    // Note: A leaf is a node with no children.

    // Example 1:
    // Input: root = [3,9,20,null,null,15,7]
    // Output: 2

    // Example 2:
    // Input: root = [2,null,3,null,4,null,5,null,6]
    // Output: 5
    public int minDepth_BFS(TreeNode root) {
        // since this measures depth just do the same thing in averageOfLevels_BFS
        int minLevel = Integer.MAX_VALUE;
        int level = 0;
        if (root == null) {
            return level;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        level++;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp == null) {
                level++;
                queue.add(null);
                if (queue.peek() == null) {
                    break; // we are at the end of the tree, all nodes have been visited
                }
                else {
                    continue;
                }
            }
            else if (temp.left == null && temp.right == null) {
                if (level < minLevel) {
                    minLevel = level;
                }
            }

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        return minLevel;
    }

    public int minDepth_DFS(TreeNode root) {
        // a leaf is a node with no children
        int level = 0;
        if (root == null) {
            return level;
        }
        else {
            level++;
        }

        return this.traverseTree(root, level);
    }

    public int traverseTree(TreeNode node, int level) { // this passed all tests on the FIRST FUCKING TRY!!!
        if (node.left == null && node.right == null) { // no children, leaf found
            return level;
        }

        if (node.left != null && node.right != null) {
            return Math.min(this.traverseTree(node.left, level+1), this.traverseTree(node.right, level+1));
        }
        else if (node.left != null) { // traverse the left branch
            return this.traverseTree(node.left, level+1);
        }
        else { // traverse the right branch
            return this.traverseTree(node.right, level+1);
        }
    }

}
