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
a) Insert elements from LinkedList(LL) on to Stack until we reach the middle element of LL.
b) Use Fast/Slow Runner approach to find the middle element if length of the LL is unknown.
c) Once reached the middle element, for each step of slow runner, pop a value from stack and compare. If they are same,
continue the loop. Else return false
d) It takes o(n) time and o(n) space
 */

import java.util.Stack;

public class PalindromeUsingIterativeApproach {

    public static void main(String a[]) {
        PalindromeUsingIterativeApproach obj = new PalindromeUsingIterativeApproach();

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
        Stack<Integer> stack = new Stack<>();

        Node slowRunner = input.getHead();
        Node fastRunner = input.getHead();
        while (fastRunner != null && fastRunner.getNext() != null) {
            stack.push(slowRunner.getData());

            slowRunner = slowRunner.getNext();
            fastRunner = fastRunner.getNext().getNext();
        }

        if (fastRunner != null) {
            slowRunner = slowRunner.getNext();
        }

        while (slowRunner != null) {
            int top = stack.pop().intValue();
            if (top != slowRunner.getData()) {
                return false;
            }
            slowRunner = slowRunner.getNext();
        }
        return true;
    }
}
