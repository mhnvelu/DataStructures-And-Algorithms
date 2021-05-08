package com.dsa;

/*
Problem Description:
There are 3 types of edits can be performed on string - insert/replace/remove.
Given 2 strings write a function to check if they are ONE edit(or ZERO edits) away.
Assume both strings are lowercase.
 */

/*
Input String 1 = pale
Input String 2 = ple
Expected Output = true

Input String 1 = pales
Input String 2 = pale
Expected Output = true

Input String 1 = pale
Input String 2 = bale
Expected Output = true

Input String 1 = pale
Input String 2 = bae
Expected Output = false

 */

/*
Solution:
a) Insert and Remove edit are just opposite to each other.
b) Find the shortest string from the given input strings.
c) loop over the strings and compare the characters at each position in both strings.
    1) If they are not same, then increment the index of longest string and continue step c.
    2) If they are not same and indices of both strings don't match, then return false.
    3) If they are same, then increment indices of both strings and continue step c.
    4) Finally return true
d) Replace edit is handled if both strings are of same length and iterate over the string, compare each character and return true/false
e) Time complexity is O(n) - n is the length of shorter string
 */


public class CheckStringEdit {

    public static void main(String a[]) {
        CheckStringEdit obj = new CheckStringEdit();
        System.out.println("Input 1 : pale, Input 2: ple  ==> " + obj.isOneEditAway("pale", "ple"));
        System.out.println("Input 1 : pales, Input 2: pale  ==> " + obj.isOneEditAway("pales", "pale"));
        System.out.println("Input 1 : pale, Input 2: bale  ==> " + obj.isOneEditAway("pale", "bale"));
        System.out.println("Input 1 : pale, Input 2: bae  ==> " + obj.isOneEditAway("pale", "bae"));
        System.out.println("Input 1 : pale, Input 2: pale  ==> " + obj.isOneEditAway("pale", "pale"));
    }

    boolean isOneEditAway(String input1, String input2) {
        if (input1.length() == input2.length()) {
            return isOneEditReplace(input1, input2);
        } else if (input1.length() < input2.length()) {
            return isOneEditInsert(input1, input2);
        } else if (input1.length() > input2.length()) {
            return isOneEditInsert(input2, input1);
        }
        return false;
    }

    boolean isOneEditReplace(String input1, String input2) {
        boolean found = false;
        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) != input2.charAt(i)) {
                if (found) {
                    return false;
                }
                found = true;
            }
        }
        return found;
    }

    boolean isOneEditInsert(String shortStr, String longStr) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < longStr.length() && index1 < shortStr.length()) {
            if (shortStr.charAt(index1) != longStr.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;

            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
