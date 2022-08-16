package cci.graphstrees;

//    Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if
//    you have a tree with depth D, you'll have D linked lists)

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class ListOfDepths {

    static <T> List<LinkedList<T>> listOfDepths(Tree<T> tree) {
        if (tree == null || tree.root == null) {
            return Collections.emptyList();
        }

        List<LinkedList<T>> listOfDepths = new ArrayList();

        List<TreeNode> nextLevel = new ArrayList();
        nextLevel.add(tree.root);

        while (!nextLevel.isEmpty()) {
            LinkedList<T> depth = new LinkedList();

            List<TreeNode> currentLevel = nextLevel;
            nextLevel = new ArrayList();

            for (TreeNode<T> node : currentLevel) {
                depth.add(node.value);

                if (node.left != null)
                    nextLevel.add(node.left);

                if (node.right != null) {
                    nextLevel.add(node.right);
                }

                listOfDepths.add(depth);
            }
        }

        return listOfDepths;
    }
}

class Tree<T> {
    TreeNode<T> root;

    public Tree(T root) {
        this.root = new TreeNode<>(root);
    }
}

class TreeNode<T> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }
}
