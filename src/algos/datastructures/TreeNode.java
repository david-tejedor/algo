package algos.datastructures;

public class TreeNode<T> {
    public final T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T value) {
        this.data = value;
    }
}
