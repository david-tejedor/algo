package algos.datastructures;

public class Pair<T, R> {

    public final T left;
    public final R right;

    public Pair(T left, R right) {
        this.left = left;
        this.right = right;
    }

    public static <T, R> Pair<T, R> of(T left, R right) {
        return new Pair(left, right);
    }

    public T getLeft() {
        return left;
    }

    public T getKey() {
        return left;
    }

    public R getRight() {
        return right;
    }

    public R getValue() {
        return right;
    }
}
