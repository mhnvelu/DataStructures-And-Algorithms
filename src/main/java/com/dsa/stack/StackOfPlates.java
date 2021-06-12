package com.dsa.stack;
/*
Problem Description:
Imagine a stack of plates. If the stack gets too high, it might topple. So we need to have set of stacks.
If the previous stack exceeds the threshold, create a new stack.
push and pop should behave identically to a single stack (that is pop() should return the same value as it would if there were
just a single stack)

Also implement a function popAt(int index) which performs a pop operation on a specific sub-stack
 */

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackOfPlates<T> {

    private Stack stack;
    private List<Stack> setOfStacks;

    public StackOfPlates() {
        stack = new Stack(2);
        setOfStacks = new ArrayList<>();
        setOfStacks.add(stack);
    }

    public static void main(String a[]) {
        StackOfPlates plates = new StackOfPlates();
        plates.push(1);
        plates.push(2);
        plates.push(3);
        plates.push(4);
        plates.push(5);
        plates.push(6);

        System.out.println("Stack of Plates : " + plates.toString());
        plates.pop();
        System.out.println("Stack of Plates : " + plates.toString());
        plates.pop();
        System.out.println("Stack of Plates : " + plates.toString());

        plates.popAt(0);
        System.out.println("Stack of Plates : " + plates.toString());
    }

    public void push(int data) {
        Stack lastStack = getLastStack();
        if (lastStack != null && !lastStack.isFull()) {
            lastStack.push(data);
        } else {
            Stack newStack = new Stack(2);
            newStack.push(data);
            setOfStacks.add(newStack);
        }
    }

    public int pop() {
        Stack lastStack = getLastStack();
        int value = lastStack.pop();
        if (lastStack.isEmpty()) {
            setOfStacks.remove(setOfStacks.size() - 1);
        }
        return value;
    }

    public int popAt(int index) {
        return leftShiftStack(index, true);
    }

    private int leftShiftStack(int index, boolean removeTop) {
        if (index <= setOfStacks.size() - 1) {
            Stack stack = setOfStacks.get(index);
            int removedItem;
            if (removeTop) {
                removedItem = stack.pop();
            } else {
                removedItem = stack.removeBottom();
            }
            if (stack.isEmpty()) {
                setOfStacks.remove(index);
            } else if (setOfStacks.size() > index + 1) {
                int v = leftShiftStack(index + 1, false);
                stack.push(v);
            }
            return removedItem;

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private Stack getLastStack() {
        int size = setOfStacks.size();
        if (size == 0) {
            return null;
        }
        return setOfStacks.get(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int size = setOfStacks.size();
        for (int i = size - 1; i >= 0; i--) {
            Stack stack = setOfStacks.get(i);
            builder.append(stack.toString());
        }
        return builder.toString();
    }
}


class Stack {
    private int capacity;
    private int size;
    private Node top, bottom;


    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return size >= capacity;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public void join(Node above, Node below) {
        if (below != null) {
            below.above = above;
        }
        if (above != null) {
            above.below = below;
        }
    }

    public boolean push(int data) {
        if (isFull()) {
            return false;
        } else {
            size++;
            Node n = new Node(data);
            if (size == 1) {
                bottom = n;
            }
            join(n, top);
            top = n;
            return true;
        }
    }

    public int pop() {
        if (!isEmpty()) {
            Node v = top;
            int value = v.data;
            top = v.below;
            size--;
            return value;
        } else {
            throw new EmptyStackException();
        }
    }

    public int removeBottom() {
        int value = bottom.data;
        bottom = bottom.above;
        if (bottom != null) {
            bottom.below = null;
        }
        size--;
        return value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node current = top;
        while (current != null) {
            builder.append("<--");
            builder.append(current.data);
            current = current.below;
        }
        return builder.toString();
    }

    private static class Node {
        private int data;
        private Node above;
        private Node below;

        Node(int data) {
            this.data = data;
        }
    }

}
