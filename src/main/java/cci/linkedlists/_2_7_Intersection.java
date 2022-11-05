package cci.linkedlists;

import algos.datastructures.LinkedList;

import static algos.datastructures.LinkedList.*;

public class _2_7_Intersection {

    public static void main(String[] args) {
        Node intersectionNode = new Node(1, new Node(2));

        System.out.println(checkIfIntersect(
                new LinkedList(new Node(0, new Node(1, intersectionNode))),
                new LinkedList(new Node(5, intersectionNode))));
        System.out.println(checkIfIntersect(
                new LinkedList(new Node(0, new Node(1, new Node(1, new Node(2))))),
                new LinkedList(new Node(1, new Node(1, new Node(2))))));

        System.out.println(getIntersectionNode(
                new LinkedList(new Node(0, new Node(1, intersectionNode))),
                new LinkedList(new Node(5, intersectionNode))));
        System.out.println(getIntersectionNode(
                new LinkedList(new Node(0, new Node(1, new Node(1, new Node(2))))),
                new LinkedList(new Node(1, new Node(1, new Node(2))))));
    }

    static Node getIntersectionNode(LinkedList list1, LinkedList list2) {
        if (list1.head == null || list2.head == null) return  null;

        matchSizes(list1, list2);
        return findIntersection(list1.head, list2.head);
    }

    static Node findIntersection(Node n1, Node n2) {
        while (n1 != null && n2 != null) {
            if (n1 == n2) return n1;
            n1 = n1.next;
            n2 = n2.next;
        }

        return null;
    }

    static void matchSizes(LinkedList list1, LinkedList list2) {
        int length1 = getLength(list1);
        int length2 = getLength(list2);

        if (length1 < length2) {
            addHeadNodes(list1, length2 - length1);
        } else {
            addHeadNodes(list2, length1 - length2);
        }
    }

    static void addHeadNodes(LinkedList list, int nodes) {
        for (int i = 0; i < nodes; i++) {
            list.head = new Node(0, list.head);
        }
    }

    static int getLength(LinkedList list) {
        int length = 0;
        Node node = list.head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }


    static boolean checkIfIntersect(LinkedList list1, LinkedList list2) {
        if (list1.head == null || list2.head == null)
            return false;

        return lastNode(list1) == lastNode(list2);
    }

    static Node lastNode(LinkedList list1) {
        Node current = list1.head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

}
