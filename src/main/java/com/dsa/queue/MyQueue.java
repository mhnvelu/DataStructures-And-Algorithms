package com.dsa.queue;

import java.util.NoSuchElementException;

public class MyQueue<T> {

    MyQueueNode<T> head;
    MyQueueNode<T> tail;

    public static void main(String a[]) {
        MyQueue queue = new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.toString());
        queue.remove();
        System.out.println(queue.toString());

    }

    public void add(T data) {
        MyQueueNode node = new MyQueueNode(data);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        MyQueueNode current = head;
        while (current != null) {
            builder.append(current.data);
            builder.append("-->");
            current = current.next;
        }
        return builder.toString();
    }

    private static class MyQueueNode<T> {
        private T data;
        private MyQueueNode next;

        public MyQueueNode(T data) {
            this.data = data;
        }
    }

}
