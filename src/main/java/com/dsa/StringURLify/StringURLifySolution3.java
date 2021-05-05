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
d) This solution doesn't assume the input string has additional spaces at the end. Instead it creates additional spaces.
e) Time complexity - O(n) - n is length of string, Space complexity - O(n) - created new array
 */
public class StringURLifySolution3 {
    public static void main(String a[]) {

        StringURLifySolution3 obj = new StringURLifySolution3();
        System.out.println("URLified String : " + obj.replaceSpaces("Mr Java Developer    "));
        System.out.println("URLified String : " + obj.replaceSpaces("Mr Java    Developer"));
        System.out.println("URLified String : " + obj.replaceSpaces("Mr Java Developer"));

    }

    String replaceSpaces(String inputString) {
        char[] content = inputString.trim().toCharArray();
        int spaceCount = 0;
        int index = 0;

        //i) First scan
        int inputStringLength = inputString.trim().length();
        for (int i = 0; i < inputStringLength; i++) {
            if (content[i] == ' ') {
                spaceCount++;
            }
        }

        System.out.println("spaceCount : " + spaceCount);
        index = inputStringLength + spaceCount * 2;
        System.out.println("index : " + index);

        char[] newArray = new char[index];
        System.arraycopy(content,0,newArray,0,inputStringLength);
        for (int i = inputStringLength - 1; i >= 0; i--) {
            if (newArray[i] == ' ') {
                newArray[index - 1] = '0';
                newArray[index - 2] = '2';
                newArray[index - 3] = '%';
                index = index - 3;
            } else {
                newArray[index - 1] = newArray[i];
                index--;
            }
        }
        return new String(newArray);
    }
}
