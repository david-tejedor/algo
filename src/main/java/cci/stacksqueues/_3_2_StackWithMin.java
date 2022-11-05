package cci.stacksqueues;

import java.util.EmptyStackException;

public class _3_2_StackWithMin {

    public static void main(String[] args) {
        StackMin stack = new StackMin();
        stack.push(3);
        stack.push(5);
        stack.push(5);
        stack.push(3);
        stack.push(2);
        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
    }

}

class StackMin {

    private Node min;
    private Node last;

    public void push(int data) {
        Node node = new Node(data);
        if (last != null) {
            node.next = last;
        }

        if (min == null || min.data >= node.data) {
            node.prevMin = min;
            min = node;
        }

        last = node;
    }

    public int pop() {
        checkNonEmpty();

        if (last == min) {
            min = min.prevMin;
        }

        int data = last.data;
        last = last.next;

        return data;
    }

    public int peek() {
        checkNonEmpty();
        return last.data;
    }

    public int min() {
        checkNonEmpty();
        return min.data;
    }

    private void checkNonEmpty() {
        if (last == null)
            throw new EmptyStackException();
    }

    private class Node {
        public final int data;
        Node next;
        Node prevMin;

        public Node(int data) {
            this.data = data;
        }
    }
}
