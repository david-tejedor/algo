package cci.graphstrees;

public class _4_6_Successor {

    // Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search
    // tree. You may assume that each node has a link to its parent.

    public static void main(String[] args) {
        Node root = new Node(5);
        Node rl = new Node(4);
        root.setLeft(rl);
        Node rll = new Node(2);
        rl.setLeft(rll);
        Node rlr = new Node(5);
        rl.setRight(rlr);
        Node rr = new Node(7);
        root.setRight(rr);
        Node rrl = new Node(6);
        rr.setLeft(rrl);
        Node rrr = new Node(8);
        rr.setRight(rrr);

        System.out.println(findNext(rlr).data); // next = 5 (root)
        System.out.println(findNext(rrl).data); // next = 7 (rr)
        System.out.println(findNext(rr).data); // next = 8 (rrr)
        System.out.println(findNext(root).data); // next = 6 (rrl)
    }

    static Node findNext(Node node) {
        if (node == null) return null;

        if (node.right != null) return firstIn(node.right);

        return checkParent(node);
    }

    private static Node firstIn(Node node) {
        if (node.left != null)
            return firstIn(node.left);
        return node;
    }

    private static Node checkParent(Node node) {
        Node parent = node.parent;

        if (parent.data > node.data) return parent;

        if (parent.parent == null) return null;

        return checkParent(parent);
    }

    private static class Node {
        private final int data;

        private Node parent;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public void setLeft(Node left) {
            this.left = left;
            left.parent = this;
        }

        public void setRight(Node right) {
            this.right = right;
            right.parent = this;
        }
    }
}
