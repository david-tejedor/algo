package algos;

public class Queue {

    private Node first;
    private Node last;

    public void add(int element) {
        Node node = new Node(element);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public Node remove() {
        checkNonEmpty();

        Node prevFirst = first;

        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }

        return prevFirst;
    }

    public Node peek() {
        checkNonEmpty();

        return first;
    }

    public boolean isEmpty() {
        if (first == null) {
            return true;
        }

        return false;
    }

    private void checkNonEmpty() {
        if (isEmpty())
            throw new EmptyQueueException();
    }

    class Node {
        public final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}

class EmptyQueueException extends RuntimeException {

}