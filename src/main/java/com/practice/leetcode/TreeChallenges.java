package com.practice.leetcode;

import com.practice.misc.TreeNode;
import com.sun.source.tree.Tree;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class TreeChallenges {

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

    // 100. Same Tree
    // Given the roots of two binary trees p and q, write a function to check if they are the same or not.
    // Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

    // Example 1:
    // Input: p = [1,2,3], q = [1,2,3]
    // Output: true

    // Example 2:
    // Input: p = [1,2], q = [1,null,2]
    // Output: false

    // Example 3:
    // Input: p = [1,2,1], q = [1,1,2]
    // Output: false
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        else if (p == null ^ q == null) { // one or the other, not both
            return false;
        }
        else if (p.val != q.val) {
            return false;
        }

        return this.checkNodes(p, q);
    }

    public boolean checkNodes(TreeNode pNode, TreeNode qNode) {
        if (!this.nodesAreEqual(pNode, qNode)) {
            return false;
        }

        if (pNode.left != null && qNode.right != null) {
            boolean left = this.checkNodes(pNode.left, qNode.left);
            boolean right = this.checkNodes(pNode.right, qNode.right);
            return (left && right);
        }
        else if (pNode.left != null && qNode.left != null) {
            return this.checkNodes(pNode.left, qNode.left);
        }
        else if (pNode.right != null && qNode.right != null) {
            return this.checkNodes(pNode.right, qNode.right);
        }
        else { // both children missing, leaf found
            return pNode.val == qNode.val;
        }
    }

    public boolean nodesAreEqual(TreeNode pNode, TreeNode qNode) {
        if (pNode == qNode) {
            return true;
        }

        if (pNode == null ^ qNode == null) {
            return false;
        }

        boolean valuesEqual = pNode.val == qNode.val;
        boolean sameLeft = (pNode.left != null && qNode.left != null) || (pNode.left == null && qNode.left == null);
        boolean sameRight = (pNode.right != null && qNode.right != null) || (pNode.right == null && qNode.right == null);

        return (valuesEqual && sameLeft && sameRight);
    }


    // 112. Path Sum
    // Given the root of a binary tree and an integer targetSum,
    // return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
    // A leaf is a node with no children.
    //
    //
    //
    // Example 1:
    //
    //
    // Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
    // Output: true
    // Explanation: The root-to-leaf path with the target sum is shown.
    // Example 2:
    //
    //
    // Input: root = [1,2,3], targetSum = 5
    // Output: false
    // Explanation: There two root-to-leaf paths in the tree:
    // (1 --> 2): The sum is 3.
    // (1 --> 3): The sum is 4.
    // There is no root-to-leaf path with sum = 5.
    // Example 3:
    //
    // Input: root = [], targetSum = 0
    // Output: false
    // Explanation: Since the tree is empty, there are no root-to-leaf paths.

    public boolean hasPathSum(TreeNode node, int targetSum) {
        if (node == null) {
            return false;
        }
        else if (node.val == targetSum) {
            return true;
        }
        int sum = node.val;
        return this.searchNodes(node, sum, targetSum);
    }

    public boolean searchNodes(TreeNode node, int sum, int targetSum) {
        if (sum == targetSum) {
            return true;
        }

        if (node.left != null && node.right != null) {
            sum += node.val;
            return (this.searchNodes(node.left, sum, targetSum) && this.searchNodes(node.right, sum, targetSum));
        }
        else if (node.left == null && node.right == null) { // leaf found, end of path
            sum += node.val;
            return (sum == targetSum);
        }
        else {
            TreeNode tempNode = node.left != null ? node.left : node.right;
            sum += tempNode.val;
            return this.searchNodes(tempNode, sum, targetSum);
        }
    }

}
