package cci.linkedlists;

import algos.LinkedList;

import static algos.LinkedList.*;

public class _2_8_DetectLoop {

    // without using extra data structure (hashtable)

    /*
    * slowRunner 1x speed
    * fastRunner 2x speed
    * loopStart = k
    * when slowRunner in loopStart -> slowRunner = k; fastRunner = 2k = loopSize - k = loopStart - k
    * fastRunner "eats" pos per move, so they collide in another k moves
    * collision: both in pos 2k = loopSize = k
    * point one to head, move both at 1x speed, next collision in k moves, at loopStart
    * */

    public static void main(String[] args) {
        Node lastInLoop = new Node(6);
        Node startLoop = new Node(4, new Node(5, lastInLoop));
        lastInLoop.next = startLoop;
        LinkedList list = new LinkedList(new Node(1, new Node(2, new Node(3, startLoop))));

        System.out.println(findLoopStart(list).data);
    }

    static Node findLoopStart(LinkedList list) {
        if (list.head == null || list.head.next == null)
            return null;

        Node slowRunner = list.head.next;
        Node fastRunner = list.head.next.next;
        while (slowRunner != fastRunner) {
            if (fastRunner == null || fastRunner.next == null)
                return null;
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

        slowRunner = list.head;
        while (slowRunner != fastRunner) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }

        return slowRunner;
    }
}
