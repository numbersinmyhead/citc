package com.example.java;

import java.util.Scanner;

public class Chap1_6A_StringCompressionCount {

    public static void main (String[] string) {
        System.out.println("Please enter string you want to be compressed: ");
        Scanner input = new Scanner(System.in);

        String str = input.next();
        System.out.println("The string you entered is " + str);
        System.out.println("Compressed version of the string is " + compressString(str));
    }

    private static String compressString(String str) {
        StringBuilder compressedStr = new StringBuilder();
        int countCompressedChar = 0;

        for (int i  = 0; i < str.length(); i++) {
            countCompressedChar++;

            // if we are at the last character OR if the next character doesn't match with
            // the current character, then we would like to update the count
            if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressedStr.append(str.charAt(i));
                compressedStr.append(countCompressedChar);
                countCompressedChar = 0; //reset the character counter.
            }
        }
        return compressedStr.length() <= str.length() ? compressedStr.toString() : str;
    }
}
