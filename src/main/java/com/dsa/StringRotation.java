package com.dsa;

/*
Problem Description:
Assume we have a method 'isSubstring' which checks if one word is a substring of another.
Given 2 strings s1 and s2, write a method to check if s2 is a rotation of s1 using only one call to
isSubstring.
 */

/*
s1 = waterbottle
s2 = erbottlewat
Result = true
 */

/*
Solution:
If s2 is the rotation of s1, we need to know the rotation point.
If we rotate 'waterbottle' after 'wat', we get 'erbottlewat'
In the rotation we cut s1 into 2 parts x and y and rearrange them to get s2
s1 = xy= waterbottle
x = wat
y = erbottle
s2 = yx = erbottlewat

We need to find a way to split s1 into x and y such that xy = s1 and yx = s2.
Regardless of where the division between x and y is, we can see that yx is always a substring of xyxy.
That is, s2 is always be a substring of s1s1.

Time complexity : its based on runtime of substring which can be O(A + B), A and B are length of strings A and B.
Then the runtime of rotation is o(N)
 */
public class StringRotation {
    public static void main(String a[]) {
        StringRotation obj = new StringRotation();
        System.out.println("Is erbottlewat rotation of waterbottle : " + obj.isRotation("waterbottle", "erbottlewat"));
        System.out.println("Is ebrottlewat rotation of waterbottle : " + obj.isRotation("waterbottle", "ebrottlewat"));
    }

    boolean isRotation(String s1, String s2) {
        int length = s1.length();
        if (length == s2.length() && length > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    boolean isSubstring(String s1s1, String s2) {
        System.out.println(s1s1);
        for (int i = 0; i < s1s1.length() / 2; i++) {
            String tmp = s1s1.substring(i, s2.length()+i);
            System.out.println(tmp);
            if (tmp.equals(s2)) {
                return true;
            }
        }
        return false;
    }
}
