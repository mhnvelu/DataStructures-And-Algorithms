package com.dsa.linkedlist;
/*
Problem Description:
Delete middle node in the Linked List
 */

/*
Input : 1->2->3->4->5->6
Output : 1->2->4->5->6
 */

/*
a) Use 2 pointers - Pointer1 and Pointer2
b) For each iteration, move Pointer1 by one position and Pointer2 by two position.
c) Track the previous node of Pointer1 while traversal.
d) When Pointer2 reaches end of the list, remove Vertex at Pointer1
e) It takes O(n) time and O(1) space.
 */
public class DeleteMiddleNode {

    public static void main(String a[]) {

        DeleteMiddleNode obj = new DeleteMiddleNode();
        LinkedList linkedList = new LinkedList();
        linkedList.appendData(1);
        linkedList.appendData(5);
        linkedList.appendData(3);
        linkedList.appendData(2);
        linkedList.appendData(6);
        System.out.println("Input Linked List : " + linkedList.toString());
        System.out.println("Output Linked List : " + obj.deleteMiddleNode(linkedList).toString());

        LinkedList linkedList2 = new LinkedList();
        linkedList2.appendData(1);
        linkedList2.appendData(5);
        linkedList2.appendData(3);
        linkedList2.appendData(2);
        linkedList2.appendData(6);
        linkedList2.appendData(9);
        System.out.println("Input Linked List : " + linkedList2.toString());
        System.out.println("Output Linked List : " + obj.deleteMiddleNode(linkedList2).toString());

    }

    private LinkedList deleteMiddleNode(LinkedList linkedList) {
        Node head = linkedList.getHead();

        Node slowRunner = head;
        Node fastRunner = head;
        Node previous = null;
        while (fastRunner!= null && fastRunner.getNext() != null) {
            fastRunner = fastRunner.getNext().getNext();
            previous = slowRunner;
            slowRunner = slowRunner.getNext();
        }
        previous.setNext(slowRunner.getNext());
        return linkedList.setHead(head);
    }
}
