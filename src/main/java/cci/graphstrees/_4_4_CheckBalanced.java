package cci.graphstrees;

import algos.datastructures.TreeNode;

public class _4_4_CheckBalanced {

//    Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of this question,
//    a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by
//    more than one.

    static boolean isBalanced(algos.datastructures.Tree tree) {
        if (tree == null || tree.root == null)
            return false;

        return check(tree.root).isBalanced;
    }

    static NodeInfo check(TreeNode node) {
        if (node == null)
            return new NodeInfo(true, 0);

        NodeInfo left = check(node.left);
        NodeInfo right = check(node.right);
        int height = Math.max(left.height, right.height) + 1;

        if (left.isBalanced && right.isBalanced
                && (Math.abs(left.height - right.height) < 2)) {
            return new NodeInfo(true, height);
        }

        return new NodeInfo(false, height);
    }

    static class NodeInfo {
        boolean isBalanced;
        int height;

        public NodeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
