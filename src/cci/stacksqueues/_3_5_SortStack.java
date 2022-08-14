package cci.stacksqueues;

import algos.Stack;

public class _3_5_SortStack {

    public static void main(String[] args) {
        //  5 - 4 - 6 - 2 - 4 - 7 - 3 - 1
        Stack stack = new Stack();
        stack.push(1);
        stack.push(3);
        stack.push(7);
        stack.push(4);
        stack.push(2);
        stack.push(6);
        stack.push(4);
        stack.push(5);

        Stack sorted = sort(stack);
        while (!sorted.isEmpty()) {
            System.out.print(sorted.pop() + " - ");
        }
    }

    public static Stack sort(Stack stack) {
        Stack tempStack = new Stack();
        while (!stack.isEmpty()) {
            int tempValue = stack.pop();
            if (tempStack.isEmpty() || tempStack.peek() >= tempValue) {
                tempStack.push(tempValue);
            } else {
                while (!tempStack.isEmpty() && tempStack.peek() < tempValue)
                    stack.push(tempStack.pop());
                tempStack.push(tempValue);
            }
        }
        return tempStack;
    }
}
