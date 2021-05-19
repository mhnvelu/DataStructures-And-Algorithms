package com.dsa.linkedlist;

/*
Problem Description:
Remove duplicates from unsorted LinkedList without using extra Buffer
 */
/*
Input: 1->5->3->2->5->3
Output: 1->5->3->2
 */

/*
Solution:
a) Have 2 pointers
b) First pointer to iterate the LinkedList
c) Second pointer to check subsequent nodes for duplicates
c) It takes o(n^2) time and O(1) space
 */
public class RemoveDuplicatesWithoutUsingExtraSpace {
    public static void main(String a[]) {
        RemoveDuplicatesWithoutUsingExtraSpace obj = new RemoveDuplicatesWithoutUsingExtraSpace();
        LinkedList linkedList = new LinkedList();
        linkedList.appendData(1);
        linkedList.appendData(5);
        linkedList.appendData(3);
        linkedList.appendData(2);
        linkedList.appendData(5);
        linkedList.appendData(3);
        System.out.println("Input Linked List : " + linkedList.toString());
        System.out.println("Output Linked List : " + obj.deleteDuplicates(linkedList).toString());
    }

    private LinkedList deleteDuplicates(LinkedList linkedList) {
        Node head = linkedList.getHead();
        Node pointer1 = head;
        while (pointer1 != null) {
            Node pointer2 = pointer1;
            while (pointer2.getNext() != null) {
                if (pointer2.getNext().getData() == pointer1.getData()) {
                    pointer2.setNext(pointer2.getNext().getNext());
                } else {
                    pointer2 = pointer2.getNext();
                }
            }
            pointer1 = pointer1.getNext();
        }
        return linkedList.setHead(head);
    }
}
