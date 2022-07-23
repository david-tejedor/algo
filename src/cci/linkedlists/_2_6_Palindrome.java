package cci.linkedlists;

import algos.LinkedList;

import static algos.LinkedList.*;

public class _2_6_Palindrome {

    public static void main(String[] args) {
        System.out.println(Iterative.isPalindrome(new LinkedList()));
        System.out.println(Iterative.isPalindrome(new LinkedList(new Node(1))));
        System.out.println(Iterative.isPalindrome(new LinkedList(
                new Node(1, new Node(2, new Node(3, new Node(2, new Node(1))))))));
        System.out.println(Iterative.isPalindrome(new LinkedList(
                new Node(1, new Node(2, new Node(2, new Node(1)))))));
        System.out.println(Iterative.isPalindrome(new LinkedList(
                new Node(1, new Node(2, new Node(1, new Node(2)))))));

        System.out.println();

        System.out.println(Recursive.isPalindrome(new LinkedList()));
        System.out.println(Recursive.isPalindrome(new LinkedList(new Node(1))));
        System.out.println(Recursive.isPalindrome(new LinkedList(
                new Node(1, new Node(2, new Node(3, new Node(2, new Node(1))))))));
        System.out.println(Recursive.isPalindrome(new LinkedList(
                new Node(1, new Node(2, new Node(2, new Node(1)))))));
        System.out.println(Recursive.isPalindrome(new LinkedList(
                new Node(1, new Node(2, new Node(1, new Node(2)))))));
    }

    static class Recursive {
        static boolean isPalindrome(LinkedList list) {
            int length = length(list);
            return isPalindrome(list.head, length).result;
        }

        static Result isPalindrome(Node n, int currentLength) {
            if (currentLength == 0)
                return new Result(true, n);

            if (currentLength == 1)
                return new Result(true, n.next);

            Result backward = isPalindrome(n.next, currentLength - 2);
            boolean match = backward.result && (backward.node.data == n.data);
            return new Result(match, backward.node.next);
        }

        static int length(LinkedList list) {
            int length = 0;
            Node n = list.head;
            while (n != null) {
                length ++;
                n = n.next;
            }
            return length;
        }

        static class Result {
            public final boolean result;
            public final Node node;

            Result(boolean result, Node node) {
                this.result = result;
                this.node = node;
            }
        }
    }

    static class Iterative {
        static boolean isPalindrome(LinkedList list) {
            if (list.head == null)
                return false;

            Node reversed = reverse(list.head);

            return equal(list.head, reversed);
        }

        static Node reverse(Node node) {
            Node reverse = new Node(node.data);
            while (node.next != null) {
                node = node.next;
                reverse = new Node(node.data, reverse);
            }
            return reverse;
        }

        static boolean equal(Node n1, Node n2) {
            while (n1 != null && n2 != null) {
                if (n1.data != n2.data)
                    return false;
                n1 = n1.next;
                n2 = n2.next;
            }

            if (n1 != null || n2 != null) {
                return false;
            }

            return true;
        }
    }
}
