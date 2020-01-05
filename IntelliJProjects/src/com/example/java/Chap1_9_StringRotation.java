package com.example.java;

import java.util.Scanner;


// The algorithm is very simple. s1 is the original string and s2 is the rotated string. If we were to divide s1
// into two parts- x and y. How we divide s1 into x and y depend on how s2 is rotated. If s2 is truly a rotated version
// of s1, then s2 would be yx. So if you were to rearrange y and x from s2 into xy order, you would get s1.
// Therefore, s1 = x + y = xy
// s2 = y + x = yx
// s1s1 = s1 + s1 = xy + xy = xyxy
// If you look above in s1s1 we have 'yx'. So all we now need to do is to check if s2 is a substring of s1s1.


public class Chap1_9_StringRotation {

    public static void main(String[] string) {
        System.out.println("Enter String 1");
        Scanner input = new Scanner(System.in);
        String s1 = input.next();

        System.out.println("Enter String 2 to check if it is rotated");
        String s2 = input.next();

        System.out.println("Is S2 rotated version of S1? " + isRotate(s1, s2));


    }

    private static boolean isRotate(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        String s1s1 = s1.concat(s1);
        return  isSubstring(s1s1, s2);
    }

    private static boolean isSubstring(String s1, String s2) {
        if (s1.contains(s2)) {
            return true;
        }
        else
        {
            return false;
        }
    }
}
