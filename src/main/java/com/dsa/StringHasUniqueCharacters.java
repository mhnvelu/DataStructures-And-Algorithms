package com.dsa;

/* Problem Description
Implement an algorithm to determine if a string has all unique characters.
 */

/*
Input String = "answer"
Expected Output = true
 */

/*
Input String = "hello"
Expected Output = false
 */

/*
Solution 1 :
a) create an array of boolean values, where the flag at index i indicates whether character i in teh alphabet is contained in the string.
b) The array length is 128-character alphabet.
c) time complexity is O(n) where n is length of input string, space complexity is O(1) bz the character set is fixed.
*/

/*
Solution 2:
a) Brute force approach - compare every character of the string to every other characters of the string.
b) time complexity is O(n^2) where n is length of input string, space complexity is O(1)
 */

// Solution 1
public class StringHasUniqueCharacters {
    public static void main(String a[]) {
        StringHasUniqueCharacters obj = new StringHasUniqueCharacters();
        System.out.println("Does string has unique characters : " + obj.isStringHasUniqueCharacters("answer"));
        System.out.println("Does string has unique characters : " + obj.isStringHasUniqueCharacters("hello"));
    }

    private boolean isStringHasUniqueCharacters(String inputString) {
        if (inputString.length() > 128) {
            return false;
        }
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < inputString.length(); i++) {
            int value = inputString.charAt(i);
            if (charSet[value]) {
                return false;
            }
            charSet[value] = true;
        }
        return true;
    }
}
