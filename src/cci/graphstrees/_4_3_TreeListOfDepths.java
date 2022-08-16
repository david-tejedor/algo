package cci.graphstrees;

//    Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if
//    you have a tree with depth D, you'll have D linked lists)

import algos.datastructures.Tree;
import algos.datastructures.TreeNode;

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
                depth.add(node.data);

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
