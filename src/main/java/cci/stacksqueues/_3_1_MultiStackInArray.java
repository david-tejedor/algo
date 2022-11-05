package cci.stacksqueues;

import java.util.Arrays;

public class _3_1_MultiStackInArray {

    public static void main(String[] args) {
        MultiStack multiStack = new MultiStack(3, 9);
        multiStack.push(0, new Data("0-1"));
        multiStack.push(0, new Data("0-2"));
        multiStack.push(2, new Data("2-1"));
        multiStack.push(1, new Data("1-1"));
        multiStack.push(1, new Data("1-2"));
        multiStack.push(0, new Data("0-3"));
        multiStack.pop(2);
        multiStack.push(0, new Data("0-4"));
        multiStack.pop(1);
        multiStack.push(2, new Data("2-2"));

        System.out.println(multiStack);
    }
}

class MultiStack {

    private final int noOfStacks;
    private final Node[] stack;

    public MultiStack(int noOfStacks, int maxSize) {
        if (noOfStacks > maxSize) {
            throw new RuntimeException();
        }

        this.noOfStacks = noOfStacks;
        stack = new Node[maxSize];
    }

    private Integer nextEmpty() {
        for (int i = noOfStacks; i < stack.length; i++) {
            if (stack[i] == null)
                return i;
        }

        return null;
    }

    public void push(int stackNo, Data data) {
        Integer nextEmpty = nextEmpty();
        if (nextEmpty == null) {
            throw new FullStackException();
        }

        Node node = new Node(data);
        if (stack[stackNo] != null) {
            stack[nextEmpty] = stack[stackNo];
            node.nextPos = nextEmpty;
        }

        stack[stackNo] = node;
    }

    public Data pop(int stackNo) {
        Node node = stack[stackNo];
        if (node != null && node.nextPos != null) {
            stack[stackNo] = stack[node.nextPos];
            stack[node.nextPos] = null;

        }

        return node.data;
    }

    public Data peek(int stackNo) {
        return stack[stackNo].data;
    }

    private class Node {
        final Data data;
        Integer nextPos;

        public Node(Data data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", nextPos=" + nextPos +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MultiStack{" +
                "noOfStacks=" + noOfStacks +
                ", stack=" + Arrays.toString(stack) +
                '}';
    }
}
class Data {
    private final String value;

    public Data(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

class FullStackException extends RuntimeException {
}
