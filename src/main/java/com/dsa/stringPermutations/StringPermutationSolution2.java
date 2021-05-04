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

/*
Solution 1:
a) Are permutation comparision case sensitive? - Yes
b) Is white space in string significant? - Yes
c) Strings of 2 different lengths can't be permutations.
d) If 2 strings are permutations, then strings must contain same number of characters.
e) Iterate a string and make a count of characters in it. Then compare the count with other string characters count.
f) time complexity - O(n) - n is length of string, time spend for iterating it.
 */

public class StringPermutationSolution2 {
    public static void main(String a[]) {
        StringPermutationSolution2 obj = new StringPermutationSolution2();
        System.out.println("Are Strings Permutations : " + obj.arePermutations("abc", "cab"));
        System.out.println("Are Strings Permutations : " + obj.arePermutations("Abc", "cab"));
        System.out.println("Are Strings Permutations : " + obj.arePermutations("abcd", "cab"));
    }


    boolean arePermutations(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] count = new int[128];

        char[] content1 = str1.toCharArray();
        for (char i :
                content1) {
            count[i]++;
        }

        for (char i :
                str2.toCharArray()) {
            count[i]--;
            if (count[i] < 0) {
                return false;
            }

        }
        return true;
    }

}
