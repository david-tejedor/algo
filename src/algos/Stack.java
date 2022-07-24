package algos;

public class Stack {

    public Node last;

    public void push(int data) {
        Node newLast = new Node(data);
        if (last != null) {
            newLast.next = last;
        }
        last = newLast;
    }

    public int pop() {
        if (last == null) {
            throw new EmptyStackException();
        }

        Node oldLast = last;
        last = last.next;
        return oldLast.data;
    }

    public int peek() {
        if (last == null)
            throw new EmptyStackException();

        return last.data;
    }

    public boolean isEmpty() {
        return (last == null);
    }

    static class Node {
        public final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}

class EmptyStackException extends RuntimeException {

}