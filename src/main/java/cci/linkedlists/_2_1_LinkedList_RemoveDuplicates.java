package cci.linkedlists;

public class _2_1_LinkedList_RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new MyLinkedList(new Node(1, new Node(2, new Node(1, new Node(3)))))));
        System.out.println(removeDuplicates(new MyLinkedList(new Node(1, new Node(1)))));
        System.out.println(removeDuplicates(new MyLinkedList(new Node(1, new Node(1)))));
        System.out.println(removeDuplicates(new MyLinkedList(new Node(1))));
        System.out.println(removeDuplicates(new MyLinkedList(null)));
    }

    // remove duplicates from an unsorted linked list
    // temporary buffer not allowed

    static MyLinkedList removeDuplicates(MyLinkedList list) {
        if (list.head == null) return list;

        Node n1 = list.head;
        Node n2;
        do {
            n2 = n1;
            while (n2.next != null) {
                if (n1.id == n2.next.id) {
                    n2.next = n2.next.next;
                } else {
                    n2 = n2.next;
                }
            }
            n1 = n1.next;
        } while (n1 != null && n1.next != null);

        return list;
    }

    static class MyLinkedList {
        Node head;

        public MyLinkedList(Node head) {
            this.head = head;
        }

        @Override
        public String toString() {
            return head != null ? head.toString() : "";
        }
    }

    static class Node {
        int id;
        Node next;

        public Node(int id, Node next) {
            this.id = id;
            this.next = next;
        }

        public Node(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return next != null ? id + " - " + next : String.valueOf(id);
        }
    }
}
