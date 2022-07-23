package cci.linkedlists;

import algos.LinkedList;
import javafx.util.Pair;

import static algos.LinkedList.Node;

public class _2_2_LinkedList_FindKthElement {

    // Implement an algorithm to find the kth to last element of a singly linked list

    public static void main(String[] args) {
        System.out.println(Recursive.kthToLast(new LinkedList(new Node(2, new Node(3, new Node(8)))), 2));
        System.out.println(Recursive.kthToLast(new LinkedList(
                new Node(3, new Node(8, new Node(5, new Node(2, new Node(4, new Node(4))))))), 3));
        System.out.println(Recursive.kthToLast(new LinkedList(new Node(2, new Node(3, new Node(8)))), 5));
        System.out.println(Recursive.kthToLast(new LinkedList(), 2));

        System.out.println(Iterative.kthToLast(new LinkedList(new Node(2, new Node(3, new Node(8)))), 2));
        System.out.println(Iterative.kthToLast(new LinkedList(
                new Node(3, new Node(8, new Node(5, new Node(2, new Node(4, new Node(4))))))), 3));
        System.out.println(Iterative.kthToLast(new LinkedList(new Node(2, new Node(3, new Node(8)))), 5));
        System.out.println(Iterative.kthToLast(new LinkedList(), 2));
    }

    static class Recursive {

        static Node kthToLast(LinkedList list, int k) {
            if (list.head == null) return null;

            Pair<Integer, Node> found = find(list.head, k);

            if (found.getKey() != k) return null;

            return found.getValue();
        }

        static Pair<Integer, Node> find(Node node, int k) {
            if (node.next == null) {
                return new Pair(1, node);
            }

            Pair<Integer, Node> sub = find(node.next, k);
            if (sub.getKey() == k) {
                return sub;
            }
            return new Pair(sub.getKey() + 1, node);
        }
    }

    static class Iterative {

        static Node kthToLast(LinkedList list, int k) {
            if (list.head == null) return null;

            Node n1 = list.head;
            Node n2 = list.head;

            for (int i = 0; i < k - 1; i++) {
                if (n2.next == null) {
                    return null;
                }
                n2 = n2.next;
            }

            while (n2.next != null) {
                n1 = n1.next;
                n2 = n2.next;
            }

            return n1;
        }
    }
}
