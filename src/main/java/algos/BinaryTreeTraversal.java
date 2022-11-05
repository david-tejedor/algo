package algos;

public class BinaryTreeTraversal {

    public static void inOrderTraversal(BinaryNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            visit(node); // often just printing
            inOrderTraversal(node.right);
        }
    }

    public static void preOrderTraversal(BinaryNode node) {
        if (node != null) {
            visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public static void postOrderTraversal(BinaryNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            visit(node);
        }
    }

    private static void visit(BinaryNode node) {
        System.out.println(node.value);
    }
    
    class BinaryNode {
        public final int value;
        public BinaryNode left;
        public BinaryNode right;

        BinaryNode(int value) {
            this.value = value;
        }
    }
}

