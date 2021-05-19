package com.dsa.linkedlist;
/*
Problem Description:
Find the kth to last element in Singly Linked List
 */

/*
Input : 1->5->3->2->6->9
Output : 6 if k=2
 */

/*
Solution:
a) Use 2 pointers
b) Keep Pointer1 and Pointer2 are k nodes are part.
c) Pointer1 is at beginning and Pointer2 is at kth node from Pointer1
d) Then, move both Pointer1 and Pointer2 at the same pace. When Pointer2 reaches the end of
LinkedList, Pointer1 would have reached kth element in the LinkedList.
e) It takes O(n) time and O(1) space.
 */

public class FindKthToLastElement {
    public static void main(String a[]) {
        FindKthToLastElement obj = new FindKthToLastElement();
        LinkedList linkedList = new LinkedList();
        linkedList.appendData(1);
        linkedList.appendData(5);
        linkedList.appendData(3);
        linkedList.appendData(2);
        linkedList.appendData(6);
        linkedList.appendData(9);
        System.out.println("Input Linked List : " + linkedList.toString());

        System.out.println(String.format("Element at position %d is %d ", 0, obj.findKthToLastElement(linkedList, 0)));
        System.out.println(String.format("Element at position %d is %d ", 1, obj.findKthToLastElement(linkedList, 1)));
        System.out.println(String.format("Element at position %d is %d ", 2, obj.findKthToLastElement(linkedList, 2)));
    }

    private int findKthToLastElement(LinkedList linkedList, int k) {
        Node head = linkedList.getHead();
        if (k < 0) {
            throw new RuntimeException("Invalid k value");
        }

        Node pointer1 = head;
        Node pointer2 = head;

        for (int i = 0; i < k; i++) {
            if (pointer2 == null) {
                throw new RuntimeException("Invalid LinkedList");
            }
            pointer2 = pointer2.getNext();
        }


        while (pointer2.getNext() != null) {
            pointer1 = pointer1.getNext();
            pointer2 = pointer2.getNext();
        }

        int data = pointer1.getData();
        return data;
    }

}
