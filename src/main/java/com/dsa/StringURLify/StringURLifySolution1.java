package com.dsa.StringURLify;

/* Problem Description
Replace all spaces in a given string with '%20'
Assume the string has sufficient space at the end to hold additional characters and true length of the string is given.
 */

/*
Input String1 = "Mr Java Developer  "

Expected Output = Mr%20Java%20Developer
 */

/*
Solution 1:
a) In string manipulation problems, common approach is edit the string starting from end and working backwards.
b) This allows us to change characters without worrying about what we are overwriting.
c) 2 scan approach:
    i) First scan - count number of spaces. By tripling the count, we can get how many extra characters we will have in final string.
    ii) Second scan - Edit the string in reverse order, when we see a space replace it with %20. If no space, then copy the original character.
d) This solution uses the existing string char array space.
e) Time complexity - O(n) - n is length of string
 */
public class StringURLifySolution1 {
    public static void main(String a[]) {
        StringURLifySolution1 obj = new StringURLifySolution1();
        System.out.println("URLified String : " + obj.replaceSpaces("Mr Java Developer    ", 17));
    }

    String replaceSpaces(String inputString, int trueLength) {
        System.out.println("inputString length : " + inputString.length());
        System.out.println("inputString trueLength : " + trueLength);
        char[] content = inputString.toCharArray();
        int spaceCount = 0;
        int index = 0;

        //i) First scan
        for (int i = 0; i < trueLength; i++) {
            if (content[i] == ' ') {
                spaceCount++;
            }
        }

        System.out.println("spaceCount : " + spaceCount);
        index = trueLength + spaceCount * 2;
        System.out.println("index : " + index);
        
        //ii) Second scan
        for (int i = trueLength - 1; i >= 0; i--) {
            if (content[i] == ' ') {
                content[index - 1] = '0';
                content[index - 2] = '2';
                content[index - 3] = '%';
                index = index - 3;
            } else {
                content[index - 1] = content[i];
                index--;
            }
        }
        return new String(content);
    }
}
