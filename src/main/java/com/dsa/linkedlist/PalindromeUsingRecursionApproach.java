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
a) We want to compare element at 0 with element at n-1, element at 1 with element at n-2 so on.
b) We need to know the middle element as this will form a base case. If we recurse the linked list, the length of list can be
reduced by 2. (i.e.,) length -2 each time for N/2 recurse times. When the length is 0 or 1, we are center of linked list.
c) Then rewind the stack. Compare the Result(contains next node in LL) returned from previous one with current rewind node.
 */

public class PalindromeUsingRecursionApproach {

    public static void main(String a[]) {
        PalindromeUsingRecursionApproach obj = new PalindromeUsingRecursionApproach();

        LinkedList input1 = new LinkedList();
        input1.appendData(0);
        input1.appendData(1);
        input1.appendData(2);
        input1.appendData(1);
        input1.appendData(0);

        System.out.println("Input LinkedList : " + input1.toString());
        System.out.println("Is Palindrome : " + obj.isPalindrome(input1.getHead(), input1.size()).isPalindrome);

        LinkedList input2 = new LinkedList();
        input2.appendData(0);
        input2.appendData(1);
        input2.appendData(2);
        input2.appendData(1);
        input2.appendData(0);
        input2.appendData(5);

        System.out.println("Input LinkedList : " + input2.toString());
        System.out.println("Is Palindrome : " + obj.isPalindrome(input2.getHead(), input2.size()).isPalindrome);

    }

    Result isPalindrome(Node head, int length) {
        if (head == null || length <= 0) { // even number of nodes
            return new Result(head, true);
        } else if (length == 1) { // odd number of nodes
            return new Result(head.getNext(), true);
        }

        Result result = isPalindrome(head.getNext(), length - 2);
        if (!result.isPalindrome || result.node == null) {
            return result;
        }

        result.isPalindrome = head.getData() == result.node.getData();
        result.node = result.node.getNext();
        return result;
    }
}

class Result {
    Node node;
    boolean isPalindrome = false;

    Result(Node node, boolean isPalindrome) {
        this.node = node;
        this.isPalindrome = isPalindrome;
    }
}
