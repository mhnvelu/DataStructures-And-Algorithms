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
d) When Pointer2 reaches end of the list, remove Node at Pointer1
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
    }

    private LinkedList deleteMiddleNode(LinkedList linkedList) {
        Node head = linkedList.getHead();

        Node pointer1 = head;
        Node pointer2 = head;
        Node previous = null;
        while (pointer2.getNext() != null && pointer2.getNext().getNext() != null) {
            pointer2 = pointer2.getNext().getNext();
            previous = pointer1;
            pointer1 = pointer1.getNext();
        }
        previous.setNext(pointer1.getNext());
        return linkedList.setHead(head);
    }
}
