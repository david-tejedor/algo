package cci.graphstrees;

public class _4_10_CheckSubtree {

    // Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
    // algorithm to determine if T2 is a subtree of Tl.
    // A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2. That
    // is, if you cut off the tree at node n, the two trees would be identical.

    public static void main(String[] args) {
        Node r = new Node(2);
        Node rl = new Node(2);
        Node rr = new Node(4);
        Node rll = new Node(3);
        Node rlr = new Node(1);
        Node rlll = new Node(2);
        Node rllr = new Node(4);
        Node rlrl = new Node(3);
        Node rlrr = new Node(3);
        Node rllll = new Node(2);
        Node rlllll = new Node(3);
        Node rllllr = new Node(1);
        Node rllllll = new Node(2);
        Node rlllllr = new Node(3);
        Node rrl = new Node(6);
        Node rrll = new Node(2);
        Node rrlr = new Node(4);
        Node rrr = new Node(3);

        r.left = rl;
        r.right = rr;
        rl.left = rll;
        rl.right = rlr;
        rr.left = rrl;
        rr.right = rrr;
        rll.left = rlll;
        rll.right = rllr;
        rlr.left = rlrl;
        rlr.right = rlrr;
        rrl.left = rrll;
        rrl.right = rrlr;
        rlll.left = rllll;
        rllll.left = rlllll;
        rllll.right = rllllr;
        rlllll.left = rllllll;
        rlllll.right = rlllllr;

        Node subr = new Node(2);
        Node subrl = new Node(3);
        Node subrr = new Node(1);
        Node subrll = new Node(2);
        Node subrlr = new Node(3);

        subr.left = subrl;
        subr.right = subrr;
        subrl.left = subrll;
        subrl.right = subrlr;

        System.out.println(isSubtree(r, subr));
    }

    static boolean isSubtree(Node t1, Node t2) {
        if (t1 == null || t2 == null)
            return false;

        return checkSubtree(t1, t2);
    }

    private static boolean checkSubtree(Node t1, Node t2) {
        if (t1 == null || t2 == null)
            return false;

        if (t1.data == t2.data) {
            if (exactMatch(t1.left, t2.left) && exactMatch(t1.right, t2.right))
                return true;
        }

        return checkSubtree(t1.left, t2) || checkSubtree(t1.right, t2);
    }

    private static boolean exactMatch(Node t1, Node t2) {
        if (t1 == null && t2 == null)
            return true;

        if (t1 == null || t2 == null)
            return false;

        if (t1.data == t2.data)
            return exactMatch(t1.left, t2.left) && exactMatch(t1.right, t2.right);

        return false;
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
