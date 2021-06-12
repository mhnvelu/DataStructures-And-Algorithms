package com.dsa.stack;


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
a) Create another stack named stack2 to hold minimum for each push operation on stack1.
b) Push the new value as minimum into stack2 if existing minimum in stack2 is greater than new value.
b) pop() the minimum from stack2 when pop() from stack1 if they are value<=min.
c)
 */
public class MinimumInStackApproach2 extends MyStack<Integer> {
    private static MyStack<Integer> stack2 = new MyStack<>();

    public static void main(String a[]) {
        MinimumInStackApproach2 stack1 = new MinimumInStackApproach2();
        stack1.push(4);
        stack1.push(5);
        stack1.push(3);
        stack1.push(2);
        System.out.println(stack1.toString());
        System.out.println("Min : " + stack1.min());
        stack1.pop();
        System.out.println(stack1.toString());
        System.out.println("Min : " + stack1.min());
        stack1.pop();
        System.out.println(stack1.toString());
        System.out.println("Min : " + stack1.min());
    }

    public void push(int data) {
        if (data <= min()) {
            stack2.push(data);
        }
        super.push(data);
    }

    public Integer pop() {
        int data = super.pop();
        if (data <= stack2.peek()) {
            stack2.pop();
        }
        return data;
    }

    public int min() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            return Integer.MAX_VALUE;
        }
    }

}
