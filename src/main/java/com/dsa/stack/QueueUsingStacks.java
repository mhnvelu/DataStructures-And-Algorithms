package com.dsa.stack;

import java.util.NoSuchElementException;

public class QueueUsingStacks<T> {

    MyStack<T> stack1;
    MyStack<T> stack2;

    public QueueUsingStacks() {
        stack1 = new MyStack<>();
        stack2 = new MyStack<>();
    }

    public static void main(String a[]) {
        QueueUsingStacks obj = new QueueUsingStacks();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(4);
        obj.add(5);
        System.out.println("Queue : " + obj.toString());
        obj.remove();
        System.out.println("Queue : " + obj.toString());
        obj.remove();
        System.out.println("Queue : " + obj.toString());
    }

    public void add(T data) {
        stack1.push(data);
    }

    public T remove() {
        MoveFromStack1ToStack2();
        return stack2.pop();
    }

    private void MoveFromStack1ToStack2() {
        if (stack2.isEmpty() && stack1.isEmpty()) {
            throw new NoSuchElementException();
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public T peek() {
        MoveFromStack1ToStack2();
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(stack1.toString());
        builder.append(stack2.toString());

        if (!stack2.isEmpty()) {
            return builder.toString().replaceAll("<--", "-->");
        } else {
            return builder.toString();
        }
    }
}
