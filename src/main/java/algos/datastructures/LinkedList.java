package algos.datastructures;

public class LinkedList {
    public Node head;

    public LinkedList() {
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public LinkedList add(int id) {
        if (head == null) {
            head = new Node(id);
        } else {
            head.append(id);
        }

        return this;
    }

    @Override
    public String toString() {
        return head != null ? head.toString() : "";
    }

    public static class Node {

        public final int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        void append(int id) {
            Node appendNext = next;
            while (appendNext != null) {
                appendNext = appendNext.next;
            }

            appendNext = new Node(id);
        }

        void delete(int id) {
            Node node = this;
            while (node.next != null) {
                if (node.next.data == id) {
                    node.next = node.next.next;
                    return;
                }
                node = node.next;
            }
        }

        @Override
        public String toString() {
            return next != null ? data + " - " + next : String.valueOf(data);
        }
    }

}


