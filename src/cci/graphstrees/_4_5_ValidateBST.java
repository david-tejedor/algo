package cci.graphstrees;

import algos.datastructures.Tree;
import algos.datastructures.TreeNode;

public class _4_5_ValidateBST {

    // Validate BST: Implement a function to check if a binary tree is a binary search tree.

    static boolean validateBST(Tree<Integer> tree) {
        if (tree == null || tree.root == null)
            return false;

        return isValid(tree.root, null, null);
    }

    private static boolean isValid(TreeNode<Integer> node, Integer min, Integer max) {
        if (node == null)
            return true;

        if ((max != null && node.data > max) || (min != null && node.data <= min))
            return false;

        return isValid(node.left, min, node.data) && isValid(node.right, node.data, max);
    }
}
