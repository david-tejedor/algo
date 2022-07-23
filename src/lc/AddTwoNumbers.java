package lc;

public class AddTwoNumbers {

    public static void main(String[] args) {
        //        Output: [7,0,8]
        //        Explanation: 342 + 465 = 807.
        System.out.println(addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
        ));

        //        Output: [0]
        System.out.println(addTwoNumbers(
                new ListNode(0),
                new ListNode(0)
        ));

        //        Output: [8,9,9,9,0,0,0,1]
        System.out.println(addTwoNumbers(
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))
        ));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sumNodes(l1, l2, 0, null);
    }

    private static ListNode sumNodes(ListNode l1, ListNode l2, int mod, ListNode prevNode) {
        if (l1 != null || l2 != null || mod > 0) {
            int sum = mod;

            ListNode nextL1 = null;
            if (l1 != null) {
                sum += l1.val;
                nextL1 = l1.next;
            }

            ListNode nextL2 = null;
            if (l2 != null) {
                sum += l2.val;
                nextL2 = l2.next;
            }

            int nextMod = sum / 10;
            int digit = sum % 10;

            ListNode newNode = new ListNode(digit);
            if (prevNode != null) {
                prevNode.next = newNode;
            }

            sumNodes(nextL1, nextL2, nextMod, newNode);

            return newNode;
        }

        return prevNode;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        String str = String.valueOf(val);

        if (next != null) {
            str = str.concat(" -> " + next);
        }

        return str;
    }
}
