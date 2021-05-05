package com.dsa.StringURLify;

/* Problem Description
Replace all spaces in a given string with '%20'
Assume the string has sufficient space at the end to hold additional characters and true length of the string is given.
 */

/*
Input String1 = "Mr Java Developer  "

Expected Output = Mr%20Java%20Developer
 */

public class StringURLifySolution2 {
    public static void main(String a[]) {
        StringURLifySolution2 obj = new StringURLifySolution2();
        System.out.println("URLified String : " + obj.replaceSpaces("Mr Java Developer    "));
        System.out.println("URLified String : " + obj.replaceSpaces("Mr Java    Developer"));
        System.out.println("URLified String : " + obj.replaceSpaces("Mr Java Developer"));
    }

    String replaceSpaces(String inputString) {
        return inputString.trim().replaceAll(" ", "%20");
    }
}
