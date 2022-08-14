package cci.stacksqueues;

import algos.Stack;

public class _3_4_MyQueueDoubleStack {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);
        System.out.println(myQueue.peek());
        myQueue.delete();
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());
    }
}

class MyQueue {
    private final Stack oldest = new Stack();
    private final Stack newest = new Stack();

    public void add(int data) {
        newest.push(data);
    }

    public int peek() {
        moveData();
        return oldest.peek();
    }

    public void delete() {
        moveData();
        oldest.pop();
    }

    public void moveData() {
        if (oldest.isEmpty()) {
            while(!newest.isEmpty()) {
                oldest.push(newest.pop());
            }
        }
    }

    public boolean isEmpty() {
        return oldest.isEmpty() && newest.isEmpty();
    }
}

