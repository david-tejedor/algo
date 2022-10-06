package cci.dynamicprogramming;

import java.util.Stack;

public class _8_6_TowersOfHanoi {

    public static void main(String[] args) {
        Stack<Integer> origin = new Stack();
        origin.push(5);
        origin.push(4);
        origin.push(3);
        origin.push(2);
        origin.push(1);

        Stack<Integer> middle = new Stack<>();
        Stack<Integer> target = new Stack();

        System.out.println(origin);

        move(origin, middle, target);

        System.out.println(origin);
        System.out.println(middle);
        System.out.println(target);
    }

    public static void move(Stack<Integer> t1, Stack<Integer> t2, Stack<Integer> t3) {
        move(t1.size(), t1, t2, t3);
    }

    private static void move(int num, Stack<Integer> origin, Stack<Integer> middle, Stack<Integer> target) {
        if (num == 1) {
            target.push(origin.pop());
            return;
        }

        move(num - 1, origin, target, middle);
        target.push(origin.pop());
        move(num - 1, middle, origin, target);
    }
}
