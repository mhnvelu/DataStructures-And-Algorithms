package com.dsa;

/*
Problem Description : Given a string, write a function to check if it is a permutation of a palindrome.
 */

/*
Input String = "tact coa"
Expected Output = True (permutations : "taco cat", "atco cta",etc)
 */

/*
Solution:
a) A palindrome is a string that is the same forwards and backwards.
b) We need to have an even number of almost all characters and at most one character can have an odd count.
c) Build a table with count for each character.
d) Then ensure there is no more than one character has an odd count
e) Time complexity - O(n) - n is the length of input string
 */
public class PalindromePermutation {
    public static void main(String a[]) {
        PalindromePermutation obj = new PalindromePermutation();
        System.out.println("Is Permutation of Palindrome for 'Tact coa': " + obj.isPermutationOfPalindrome("Tact coa"));
        System.out.println("Is Permutation of Palindrome for 'Tact ca': " + obj.isPermutationOfPalindrome("Tact ca"));
        System.out.println("Is Permutation of Palindrome for 'tact coa': " + obj.isPermutationOfPalindrome("tact coa"));
        System.out.println("Is Permutation of Palindrome for 'Tact coaef': " + obj.isPermutationOfPalindrome("Tact coaef"));
        System.out.println("Is Permutation of Palindrome for 'Tact coae': " + obj.isPermutationOfPalindrome("Tact coae"));
    }

    boolean isPermutationOfPalindrome(String inputString) {
        int[] table = buildCharFrequencyTable(inputString);
        return checkMaxOneOdd(table);
    }

//   check no more than one character has an odd count
    boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count :
                table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    // Only alphabets considered. case-insensitive.
    private int getCharNumber(char character) {
        int a = (int) 'a';
        int z = (int) 'z';
        int A = (int) 'A';
        int Z = (int) 'Z';

        if (a <= character && character <= z) {
            return character - a;
        } else if (A <= character && character <= Z) {
            return character - A;
        } else {
            return -1;
        }
    }

    int[] buildCharFrequencyTable(String inputString) {
        int[] table = new int[26];
        char[] content = inputString.toCharArray();
        for (int i = 0; i < content.length; i++) {
            int value = getCharNumber(content[i]);
            if (value != -1) {
                table[value]++;
            }
        }
        return table;
    }
}
