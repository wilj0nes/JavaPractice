package com.practice.challenges;

import com.practice.misc.TreeNode;

import java.util.*;

public class TreeChallenges {

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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        else if (root.left == null && root.right == null && root.val == 0) {
            return false;
        }

        return this.searchNodes(root, 0, targetSum);
    }

    public boolean searchNodes(TreeNode node, int sum, int targetSum) {
        sum += node.val;

        if (node.left != null && node.right != null) {          // left and right
            return (this.searchNodes(node.left, sum, targetSum) || this.searchNodes(node.right, sum, targetSum));
        }
        else if (node.left == null && node.right == null) {     // leaf found, end of path
            return (sum == targetSum);
        }
        else {                                                  // left or right
            TreeNode tempNode = node.left != null ? node.left : node.right;
            return this.searchNodes(tempNode, sum, targetSum);
        }
    }


    // 257. Binary Tree Paths
    // Given the root of a binary tree, return all root-to-leaf paths in any order.
    // A leaf is a node with no children.
    //
    // Example 1:
    //
    // Input: root = [1,2,3,null,5]
    // Output: ["1->2->5","1->3"]
    // Example 2:
    //
    // Input: root = [1]
    // Output: ["1"]
    public List<String> binaryTreePaths(TreeNode root) {
        return root != null? List.of(this.traverseTreePath(root, "").split("#")) : null;
    }
    public String traverseTreePath(TreeNode node, String str) { //  use StringBuilder next time??

        if (node.left != null && node.right != null) {
            str += node.val + "->";
            return traverseTreePath(node.left, str) + traverseTreePath(node.right, str);
        }
        else if (node.left == null && node.right == null) { // leaf found
            return str + node.val + "#";
        }
        else {
            str += node.val + "->";
            TreeNode tempNode = node.left != null ? node.left : node.right;
            return this.traverseTreePath(tempNode, str);
        }
    }

    // 104. Maximum Depth of Binary Tree
    // Given the root of a binary tree, return its maximum depth.
    // A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    //
    // Example 1:
    // Input: root = [3,9,20,null,null,15,7]
    // Output: 3
    // Example 2:
    //
    // Input: root = [1,null,2]
    // Output: 2
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else if (root.left == null && root.right == null && root.val == 0) {
            return 1;
        }
        return this.findMaxDepth(root, 0);
    }

    public int findMaxDepth(TreeNode node, int depth) {
        depth++;

        if (node.left == null && node.right == null) {
            return depth;
        }
        else if (node.left != null && node.right != null) {
            return Math.max(this.findMaxDepth(node.left, depth), this.findMaxDepth(node.right, depth));
        }
        else {
            return this.findMaxDepth(node.left != null ? node.left : node.right, depth);
        }
    }

    public int findMaxDepth_fork(TreeNode root) { // not my solution
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(this.maxDepth(root.left), this.maxDepth(root.right));
    }

}
