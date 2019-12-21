package com.example.java;

import java.util.Scanner;

public class Chap1_5A_OneEditAwayString {


    public static void main (String[] string) {

        System.out.println("Enter the first string:");
        Scanner input = new Scanner(System.in);
        String str1 = input.next();

        System.out.println("Enter the second string:");
        String str2 = input.next();

        System.out.println("You entered " + str1 + " and " + str2 + ".");
        System.out.println("Are the two strings replacement edit away? " + isOneEditAway(str1, str2));
    }

    // There can possibly be only three kinds of edits: insertion, deletion and replacement.
    // Insertion and deletion are very similar when ONLY one character is diff between s1 and s2.
    // This means that s1 and s2 are exactly the same up until certain point and then after that one of the
    // two strings are shifted by one character.
    // Replacement edit results in both strings having the exact same length and ONLY one character is different.
    private static boolean isOneEditAway(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return isOneEditTheReplacement(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return isOneEditInsertion(s1, s2);
        } else if (s1.length() - 1 == s2.length()) {
            return isOneEditInsertion(s2, s1);
        } else {
            System.out.println("This is an impossible situation. Some horribly went wrong.");
            return false;
        }
    }

    private static boolean isOneEditTheReplacement (String s1, String s2) {
        boolean isOneEditReplacement = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (isOneEditReplacement) {
                    return false;
                }
                isOneEditReplacement = true;
            }
        }
        return true;
    }

    private static boolean isOneEditInsertion(String s1, String s2) {
        boolean isOneEditInsert = false;
        int index1 = 0;
        int index2 = 0;

        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (isOneEditInsert) {
                    return false;
                }
                isOneEditInsert = true;
                index2++; //index2 refers to string2 i.e. s2. s2 is larger than s1, so we are making up for that offset.
                //we make up for the offset only one time because we are interested in only one edit.
            }
            else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}


