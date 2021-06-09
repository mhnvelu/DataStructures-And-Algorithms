package com.dsa.linkedlist;

/*
Problem Description:
Implement an algorithm to check if a linked list is palindrome or not
 */

/*
Input LinkedList : 0->1->2->1->0
Is Palindrome : true
Input LinkedList : 0->1->2->1->0->5
Is Palindrome : false
 */

/*
Solution:
a) Reverse the linked list
b) Compare the original and reversed list
c) We need to compare only the first half of the original and reversed LinkedList
d) It takes o(n) time and o(n) space
 */

public class PalindromeUsingReverseAndCompareApproach {

    public static void main(String a[]) {
        PalindromeUsingReverseAndCompareApproach obj = new PalindromeUsingReverseAndCompareApproach();

        LinkedList input1 = new LinkedList();
        input1.appendData(0);
        input1.appendData(1);
        input1.appendData(2);
        input1.appendData(1);
        input1.appendData(0);

        System.out.println("Input LinkedList : " + input1.toString());
        System.out.println("Is Palindrome : " + obj.isPalindrome(input1));

        LinkedList input2 = new LinkedList();
        input2.appendData(0);
        input2.appendData(1);
        input2.appendData(2);
        input2.appendData(1);
        input2.appendData(0);
        input2.appendData(5);

        System.out.println("Input LinkedList : " + input2.toString());
        System.out.println("Is Palindrome : " + obj.isPalindrome(input2));
    }

    public boolean isPalindrome(LinkedList input) {
        LinkedList reversed = reverseLinkedList(input);
        boolean result = isEqual(input, reversed);
        return result;
    }

    private LinkedList reverseLinkedList(LinkedList input) {
        Node head = null;
        Node inputNode = input.getHead();
        while (inputNode != null) {
            Node tmp = new Node(inputNode.getData());
            tmp.setNext(head);
            head = tmp;
            inputNode = inputNode.getNext();
        }
        return new LinkedList(head);
    }

    private boolean isEqual(LinkedList input, LinkedList reversed) {
        Node head1 = input.getHead();
        Node head2 = reversed.getHead();
        while (head1 != null && head2 != null) {
            if (head1.getData() != head2.getData()) {
                return false;
            }
            head1 = head1.getNext();
            head2 = head2.getNext();
        }
        return true;
    }

}
