package cci.graphstrees;

public class _4_8_FirstCommonAncestor {

    // First Common Ancestor: Design an algorithm and write code to find the first common ancestor of two nodes in a
    // binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search
    // tree.

    static Node find(Node root, Node a, Node b) {
        return findCommon(root, a, b).commonParent;
    }

    private static CommonInfo findCommon(Node node, Node a, Node b) {
        if (node == null)
            return new CommonInfo(false, null);

        if (node == a || node == b)
            return new CommonInfo(true, null);

        CommonInfo left = findCommon(node.left, a, b);
        if (left.commonParent != null)
            return left;

        CommonInfo right = findCommon(node.right, a, b);
        if (right.commonParent != null)
            return right;

        if (left.anyChild && right.anyChild) {
            return new CommonInfo(true, node);
        }

        return new CommonInfo(false, null);
    }

    static class CommonInfo {
        public final boolean anyChild;
        public final Node commonParent;

        public CommonInfo(boolean anyChild, Node commonParent) {
            this.anyChild = anyChild;
            this.commonParent = commonParent;
        }
    }

}
