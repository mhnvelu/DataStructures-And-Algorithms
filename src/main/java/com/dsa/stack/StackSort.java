package com.dsa.stack;
/*
Problem Description:
Sort the stack such that smallest items are on the top.
 */

/*
Input Stack : <--9<--1<--6<--2<--5
Sorted Stack : <--1<--2<--5<--6<--9
 */

/*
Solution:
a) Use another stack to store the sorted values.
b) pop(),say a from stack1  and compare from peek(),say b of stack2.
c) if a>b, then push b into stack1, else push a into stack2
d) finally push everything from stack2 into stack1
e) The top element in stack1 is smallest element in the stack and sorted in ascending order.
f) It takes o(n^2) time complexity and o(n) space.
e) If we can use unlimited number of temporary stacks, then we can go for merge sort or quick sort.
 */

public class StackSort {
    private MyStack<Integer> stack1;
    private MyStack<Integer> stack2;

    public StackSort() {
        this.stack1 = new MyStack<>();
        this.stack2 = new MyStack<>();
    }

    public static void main(String a[]) {
        StackSort ss = new StackSort();
        ss.push(5);
        ss.push(2);
        ss.push(6);
        ss.push(1);
        ss.push(9);

        System.out.println("Input Stack : " + ss.toString());
        System.out.println("Sorted Stack : " + ss.sort().toString());
    }

    void push(int data) {
        stack1.push(data);
    }

    int pop() {
        return stack1.pop();
    }

    MyStack sort() {
        while (!stack1.isEmpty()) {
            int value = stack1.pop();
            while (!stack2.isEmpty() && stack2.peek() > value) {
                stack1.push(stack2.pop());
            }
            stack2.push(value);
        }

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return stack1;
    }

    @Override
    public String toString() {
        return stack1.toString();
    }
}
