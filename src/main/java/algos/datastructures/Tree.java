package algos.datastructures;

public class Tree<T> {
    public final TreeNode<T> root;

    public Tree(T root) {
        this.root = new TreeNode<>(root);
    }
}
