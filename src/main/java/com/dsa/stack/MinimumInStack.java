package com.dsa.stack;

import java.util.EmptyStackException;


/*
Problem Description:
Implement a method min() such that it returns minimum element in the stack.
 */

/*
Input: 2<-3<-5<-4
Output: 2

Input: 3<-5<-4
Output: 3

Input: 5<-4
Output: 4
 */

/*
Solution:
a) Create a class NodeWithMin which can hold value and min-value for each push operations.
b) min() can peek() the stack and return min value.
c) This uses extra space to hold min value for each push operations.
d) Create the stack as int types.
 */
public class MinimumInStack {
    private MyStackNodeWithMin top;

    public static void main(String a[]) {
        MinimumInStack stack = new MinimumInStack();
        stack.push(4);
        stack.push(5);
        stack.push(3);
        stack.push(2);
        System.out.println(stack.toString());
        System.out.println("Min : " + stack.min());
        stack.pop();
        System.out.println(stack.toString());
        System.out.println("Min : " + stack.min());
        stack.pop();
        System.out.println(stack.toString());
        System.out.println("Min : " + stack.min());
    }

    public void push(int data) {
        MyStackNodeWithMin node = new MyStackNodeWithMin(data);
        if (top != null && top.min < node.data) {
            node.min = top.min;
        } else {
            node.min = node.data;
        }
        node.next = top;
        top = node;
    }

    public int pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        int data = top.data;
        top = top.next;
        return data;
    }

    public int peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        int data = top.data;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int min() {
        if (top == null) {
            throw new EmptyStackException();
        }
        int min = top.min;
        return min;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        MyStackNodeWithMin current = top;
        while (current != null) {
            builder.append("<--");
            builder.append(current.data + "(min:" + current.min + ")");
            current = current.next;
        }
        return builder.toString();
    }

    private static class MyStackNodeWithMin {
        private int data;
        private int min;
        private MyStackNodeWithMin next = null;

        public MyStackNodeWithMin(int data) {
            this.data = data;
        }
    }
}
