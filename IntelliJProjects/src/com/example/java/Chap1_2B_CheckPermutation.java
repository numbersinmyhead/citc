package com.example.java;

import java.util.Scanner;

//Second way of checking if the two strings are permutation of each other.
//this method uses the definition of a permutation that the two strings
//are permutations of each other if they have the same character count.
public class Chap1_2B_CheckPermutation {

    public static void main (String[] str) {
        System.out.println("Enter String 1:");
        Scanner str1 = new  Scanner(System.in);
        String s1 = str1.next();

        System.out.println("Enter String 2:");
        Scanner str2 = new Scanner (System.in);
        String s2 = str2.next();

        System.out.println("Are two strings permutations of each other: " + isPermutation(s1, s2));
    }

    private static boolean isPermutation(String s1, String s2) {

        if (s1.length() != s2.length())
        {
            System.out.println("Different length!");
            return false;
        }

        char[] s1_arr = s1.toCharArray();
        int [] char_count = new int[128]; //ASCII can have 128 unique characters.
        // Java will also initialize the array with default values.
        //For type char, the default value is the null character, that is, '\u0000'.
        //https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.12.5

        for (int c : s1_arr) {
            char_count[c]++; //we will increment each index where we find that particular character
        }

        // We can easily count the cÅharacter in the second string and then compare it with
        // the character array formed by the first string. However, that is not recommended.
        // I say so because the book is using another approach which is little clever. I am
        //going to use that approach here.
        for (int i = 0; i < s1.length(); i++) {
            int c = (int) s2.charAt(i); //this is a cool function. We can access each character of a string by an index
            char_count[c]--;
            // the char_count array was already incremented previously by s1. We are gonna decrement
            // that same value now.
            // However, in cases when there is a new element discovered, we end up decrementing the original
            // value (i.e. 0) to a negative value.

            // if the value of ANY element inside char_count goes negative, then it means the element discovered is new.
            //we will return false right away.
            if (char_count[c] < 0) {
                System.out.println("char_count[" + (char) c + "] is missing from " + s1);
                return false;
            }
        }

        return true;
    }
}
