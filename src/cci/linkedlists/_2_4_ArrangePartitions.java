package cci.linkedlists;

import algos.datastructures.LinkedList;

import static algos.datastructures.LinkedList.*;

public class _2_4_ArrangePartitions {

    /*
     * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes
     * greater than or equal to x. If x is contained within the list, the values of x only need to be after the
     * elements less than x (see below). The partition element x can appear anywhere in the "right partition"; it
     * does not need to appear between the left and right partitions.
     * */

    public static void main(String[] args) {
        System.out.println(arrangePartitions(new LinkedList(
                new Node(3, new Node(5, new Node(8, new Node(5, new Node(10, new Node(2, new Node(1)))))))), 5));
    }

    static LinkedList arrangePartitions(LinkedList list, int partition) {
        if (list.head == null)
            return list;

        Node p = list.head;
        while (p.next != null && p.data != partition) {
            p = p.next;
        }

        if (p.data != partition)
            return list;

        Node check = list.head;
        Node firstChanged = null;
        while (check.data != partition) {
            if (check.data > partition) {
                firstChanged = firstChanged == null ? check : firstChanged;
                Node next = check.next;
                check.next = p.next;
                p.next = check;
                list.head = next;
                check = next;
            } else {
                check = check.next;
            }
        }

        check = firstChanged != null ? firstChanged : p;
        while (check.next != null) {
            if (check.next.data < partition) {
                Node next = check.next.next;
                check.next.next = list.head;
                list.head = check.next;
                check.next = next;
            } else {
                check = check.next;
            }
        }

        return list;
    }
}
