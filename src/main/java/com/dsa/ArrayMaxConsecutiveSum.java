package com.dsa;

/* Problem Description
Given an array of integers, find the maximum possible SUM you can get it from its contiguous
subarray. The subarray from which this sum comes must contain at least 1 element
 */

/*
Input array = [-2,2,5,-11,6]
 */

/*
Expected Output = 7
 */

/*
Kadane's Algorithm
 */
public class ArrayMaxConsecutiveSum {
    private static int ArrayMaxConsecutiveSum(int[] inputArray) {
        int current_sum = inputArray[0];
        int max_sum = current_sum;
        for (int i = 1; i < inputArray.length; i++) {
            current_sum = Math.max(current_sum + inputArray[i], inputArray[i]);
            max_sum = Math.max(max_sum, current_sum);
        }
        return max_sum;
    }

    public static void main(String a[]) {
        int[] input = {-2, 2, 5, -11, 7};
        System.out.println(ArrayMaxConsecutiveSum(input));
    }

}
