package cci.linkedlists;

import algos.LinkedList;

import static algos.LinkedList.*;

public class _2_5_SumLists {

    /*
     * You have two numbers represented by a linked list, where each node contains a single digit.The digits are
     * stored in reverse order, such that the 1 's digit is at the head of the list. Write a function that adds the
     * two numbers and returns the sum as a linked list.
     * */

    public static void main(String[] args) {
        System.out.println(Reverse.sumLists(new LinkedList(), new LinkedList()));
        System.out.println(Reverse.sumLists(new LinkedList(), new LinkedList(new Node(2))));
        System.out.println(Reverse.sumLists(new LinkedList(new Node(2)), new LinkedList()));
        System.out.println(Reverse.sumLists(new LinkedList(new Node(7, new Node(1, new Node(6)))),
                                            new LinkedList(new Node(5, new Node(9, new Node(2))))));
        System.out.println(Reverse.sumLists(new LinkedList(new Node(6, new Node(1, new Node(7)))),
                                            new LinkedList(new Node(2, new Node(9, new Node(5))))));
        System.out.println(Reverse.sumLists(new LinkedList(new Node(2, new Node(3, new Node(4)))),
                                            new LinkedList(new Node(7, new Node(5)))));

        System.out.println(Forward.sumLists(new LinkedList(), new LinkedList()));
        System.out.println(Forward.sumLists(new LinkedList(), new LinkedList(new Node(2))));
        System.out.println(Forward.sumLists(new LinkedList(new Node(2)), new LinkedList()));
        System.out.println(Forward.sumLists(new LinkedList(new Node(7, new Node(1, new Node(6)))),
                                            new LinkedList(new Node(5, new Node(9, new Node(2))))));
        System.out.println(Forward.sumLists(new LinkedList(new Node(6, new Node(1, new Node(7)))),
                                            new LinkedList(new Node(2, new Node(9, new Node(5))))));
        System.out.println(Forward.sumLists(new LinkedList(new Node(2, new Node(3, new Node(4)))),
                                            new LinkedList(new Node(7, new Node(5)))));
    }

    static class Reverse {
        static LinkedList sumLists(LinkedList l1, LinkedList l2) {
            return new LinkedList(sum(l1.head, l2.head, 0));
        }

        static Node sum(Node n1, Node n2, int carry) {
            if (n1 == null && n2 == null)
                return carry != 0 ? new Node(carry) : null;

            int sum = carry;
            Node next1 = null;
            if (n1 != null) {
                sum += n1.data;
                next1 = n1.next;
            }

            Node next2 = null;
            if (n2 != null) {
                sum += n2.data;
                next2 = n2.next;
            }

            return new Node(sum % 10, sum(next1, next2, sum / 10));
        }
    }

    static class Forward {
        static LinkedList sumLists(LinkedList l1, LinkedList l2) {
            int sum = 0;

            if (l1.head != null)
                sum += sum(l1.head).value;

            if (l2.head != null)
                sum += sum(l2.head).value;

            return buildList(sum);
        }

        static Sum sum(Node n) {
            if (n.next == null) {
                return new Sum(n.data, 10);
            }

            Sum sum = sum(n.next);
            return new Sum(sum.value + n.data * sum.nextMultiplier, sum.nextMultiplier * 10);
        }

        static LinkedList buildList(int sum) {
            Node current = null;
            do {
                current = new Node(sum % 10, current);
                sum = sum / 10;
            } while (sum > 0);

            return new LinkedList(current);
        }

        static class Sum {
            public final int value;
            public final int nextMultiplier;

            Sum(int value, int nextMultiplier) {
                this.value = value;
                this.nextMultiplier = nextMultiplier;
            }
        }
    }
}

