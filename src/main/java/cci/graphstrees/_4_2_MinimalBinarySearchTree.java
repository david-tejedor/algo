package cci.graphstrees;

public class _4_2_MinimalBinarySearchTree {

    // Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.
    static Graph buildMinimal(int[] sortedArray) {
        return new Graph(build(sortedArray, 0, sortedArray.length));
    }

    private static Node build(int[] array, int start, int end) {
        int length = end - start;
        if(length == 0)
            return null;

        if (length == 1)
            return new Node(array[start]);

        int mid = start + length / 2;
        Node node = new Node(mid);
        node.left = build(array, start, mid);
        node.right = build(array, mid + 1, end);

        return node;
    }


}

class Graph {
    Node root;

    public Graph(Node root) {
        this.root = root;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
