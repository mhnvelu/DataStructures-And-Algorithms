package com.dsa.stringPermutations;

/* Problem Description
Given 2 strings, Implement an algorithm to determine if one string is permutation of other string.
 */

/*
Input String1 = "abc"
Input String2 = "cab"
Expected Output = true
 */
/*
Input String1 = "Abc"
Input String2 = "cab"
Expected Output = false
 */
/*
Input String1 = "abcd"
Input String2 = "cab"
Expected Output = false
 */

import java.util.Arrays;

/*
Solution 1:
a) Are permutation comparision case sensitive? - Yes
b) Is white space in string significant? - Yes
c) Strings of 2 different lengths can't be permutations.
d) If 2 strings are permutations, then strings must contain same characters but in different order.
e) Sort both the strings and compare.
f) time complexity - O(nlogn) - time spent for sorting
 */
public class StringPermutationSolution1 {
    public static void main(String a[]) {
        StringPermutationSolution1 obj = new StringPermutationSolution1();
        System.out.println("Are strings permutations : " + obj.arePermutations("abc", "cab"));
        System.out.println("Are strings permutations : " + obj.arePermutations("Abc", "cab"));
        System.out.println("Are strings permutations : " + obj.arePermutations("abcd", "cab"));
    }

    boolean arePermutations(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        return sort(str1).equals(sort(str2));
    }

    private String sort(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

}
