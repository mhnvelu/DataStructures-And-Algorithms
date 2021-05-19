package com.dsa.linkedlist;
/*
Problem Description:
2 numbers represented by LinkedList, each node contains single digit.
The digits are stored in reverse order. Write a function that adds these 2 numbers
and returns the sum as LinkedLists
 */

/*
Input : (7->1->6) + (5->9->2), that is 617+295
Output : 2->1->9, that is 912
 */

/*
Solution:
a)Iterate both linked lists and add each digit
b) Store the second digit of sum%10 in new LinkedList and carry the remainder.
c) Handle unequal LinkedLists as well. Append the extra digits from lengthier LL to the result LL.
d) It is O(n) time and O(n) space complexity
 */

public class AddLinkedLists {
    public static void main(String a[]) {
        AddLinkedLists obj = new AddLinkedLists();
        LinkedList l1 = new LinkedList();
        l1.appendData(7);
        l1.appendData(1);
        l1.appendData(6);

        LinkedList l2 = new LinkedList();
        l2.appendData(5);
        l2.appendData(9);
        l2.appendData(2);
        l2.appendData(8);

        System.out.println("Input Linked List 1 : " + l1.toString());
        System.out.println("Input Linked List 2 : " + l2.toString());
        System.out.println("Sum of LinkedLists : " + obj.addLinkedLists(l1, l2).toString());
    }

    public LinkedList addLinkedLists(LinkedList l1, LinkedList l2) {
        if (l1 == null || l2 == null) {
            throw new RuntimeException("Invalid Inputs");
        }

        LinkedList result = new LinkedList();
        Node head1 = l1.getHead();
        Node head2 = l2.getHead();

        int sum = 0;
        int data = 0;
        int carry = 0;

        Node current1 = head1;
        Node current2 = head2;

        while (current1 != null || current2 != null) {
            int a = 0;
            int b = 0;
            if (current1 != null) {
                a = current1.getData();
                current1 = current1.getNext();
            }

            if (current2 != null) {
                b = current2.getData();
                current2 = current2.getNext();
            }

            sum = a + b + carry;
            data = sum % 10;
            carry = sum / 10;
            result.appendData(data);
        }

        return result;

    }


}
