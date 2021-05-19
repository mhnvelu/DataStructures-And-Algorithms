package com.dsa.linkedlist;

/*
Problem Description:
Remove duplicates from unsorted LinkedList using extra Buffer
 */
/*
Input: 1->5->3->2->5->3
Output: 1->5->3->2
 */

/*
Solution:
a) Track the duplicates in HashSet
b) Remove the duplicates as we iterate
c) It takes o(n) time and O(n) space
 */

import java.util.HashSet;

public class RemoveDuplicateUsingBuffer {

    public static void main(String a[]) {
        RemoveDuplicateUsingBuffer obj = new RemoveDuplicateUsingBuffer();
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
        Node current = head;
        HashSet<Integer> duplicates = new HashSet<>();
        Node previous = null;
        while (current != null) {
            if (duplicates.contains(current.getData())) {
                previous.setNext(current.getNext());
            } else {
                duplicates.add(current.getData());
                previous = current;
            }
            current = current.getNext();
        }

        return linkedList.setHead(head);
    }
}
