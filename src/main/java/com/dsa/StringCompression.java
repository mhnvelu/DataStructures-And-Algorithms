package com.dsa;

/*
Problem Description:
Implement basic string compression using the counts of repeated characters.
Assume the string has only a-z and A-Z.
If the compressed string length is greater than or equal to original string, then the original string
 */

/*
Input String = aabccccaaaa
Compressed String = a2bc4a4
Output = a2bc4a4
 */

/*
Input String = abcdefgg
Compressed String = abcdefg2
Output = abcdefgg
 */

/*
Solution:
a) Iterate over the string and make a count of each character.
b) If next character is same as current position character, then increment the counter and continue the loop.
c) If next character is different from current position character, then store the current position character + its count in StringBuilder. Reset the counter to 0.
d) Time Complexity - O(n) - n is the length of the String.
 */

public class StringCompression {
    public static void main(String a[]) {
        StringCompression obj = new StringCompression();
        System.out.println("Compressed String : " + obj.compressString("aabccccaaaa"));
        System.out.println("Compressed String : " + obj.compressString("abcdefgg"));
    }

    String compressString(String input) {
        int consecutiveCharactersCount = 0;
        StringBuilder compressedString = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            consecutiveCharactersCount++;
            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressedString.append(input.charAt(i));
                compressedString.append(consecutiveCharactersCount);
                consecutiveCharactersCount = 0;

            }
        }
        return compressedString.length() < input.length() ? compressedString.toString() : input;
    }

}
