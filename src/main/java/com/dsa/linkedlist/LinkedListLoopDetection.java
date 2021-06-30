package com.dsa.linkedlist;

/*
Problem Description:
Given a LinkedList, detect it has a loop and return the node at the beginning of the loop.
 */

/*
Input:
1->2->3->4->5->3[SAME 3 AS EARLIER]

Output:
3
 */

/*
Solution:
a) Use Fast/Slow runner approach. At some point, both will collide.
b) When the slow runner enters the loop after k nodes, fast runner is already k nodes in the loop.
c) Fast and Slow runners are (LOOP_SIZE - k) nodes away from each other.
d) If Fast runner moves 2 nodes for each node that Slow runner moves, they move 1 node closer to each other on each turn. They
will meet after (LOOP_SIZE - k) turns. Both runners will be k nodes from the start of the loop.
e) The head of LL is also k nodes from the front of the loop. So, if we keep one runner where it is and move the other runner
to the head of the LL, then they will meet at the front of the loop.
 */

public class LinkedListLoopDetection {

    public static void main(String a[]) {
        LinkedListLoopDetection obj = new LinkedListLoopDetection();
        LinkedList input = new LinkedList();
        input.appendData(1);
        input.appendData(2);
        Node node_3 = new Node(3);
        input.appendData(node_3);
        input.appendData(4);
        input.appendData(5);
        input.appendData(node_3);

        System.out.println("Input Linked List : " + "1->2->3->4->5->3[SAME 3 AS EARLIER]");
        System.out.println("Vertex at Beginning of Loop : " + obj.findBeginningOfLoop(input.getHead()).getData());

    }

    private Node findBeginningOfLoop(Node head) {
        Node slowRunner = head;
        Node fastRunner = head;

        while (fastRunner != null && fastRunner.getNext() != null) {
            fastRunner = fastRunner.getNext().getNext();
            slowRunner = slowRunner.getNext();

            if (slowRunner == fastRunner) { // Collision
                break;
            }
        }

        // No meeting point and no loop
        if (fastRunner == null || fastRunner.getNext() == null) {
            return null;
        }

        // Move to slow runner to Head. Keep fast runner at meeting point. Each runners are k steps from the Loop start. If
        // they move at same pace, then they must meet at loop start.
        slowRunner = head;
        while (slowRunner != fastRunner) {
            slowRunner = slowRunner.getNext();
            fastRunner = fastRunner.getNext();
        }

        //both runners point to start of the loop
        return fastRunner;
    }

}
