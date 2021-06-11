package com.dsa.stack;

import java.util.EmptyStackException;

public class MyStack<T> {

    private MyStackNode<T> top;

    public static void main(String a[]) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
    }

    public void push(T data) {
        MyStackNode node = new MyStackNode(data);
        node.next = top;
        top = node;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T data = top.data;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        MyStackNode current = top;
        while (current != null) {
            builder.append("<--");
            builder.append(current.data);
            current = current.next;
        }
        return builder.toString();
    }

    private static class MyStackNode<T> {
        private T data;
        private MyStackNode<T> next = null;

        public MyStackNode(T data) {
            this.data = data;
        }
    }
}
