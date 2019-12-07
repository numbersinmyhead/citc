package com.example.java;

import java.util.Scanner;

public class Chap1Prog3URLfy {
    public static void main (String[] string) {
        System.out.println("Enter a path to convert it to URL");
        Scanner input1 = new Scanner(System.in);
        String str = input1.nextLine();

        System.out.println("Enter the true length: ");
        Scanner input2 = new Scanner(System.in);
        int len = input2.nextInt();

        convertToURL(str.toCharArray(), len);
    }

    private static void convertToURL(char[] strArr, int len) {
        int numSpaces = 0;
        for (char c: strArr) {
            if (c == ' ') {
                numSpaces++;
            }
        }

        // Each space requires two additional characters. i.e. '%', '2', and '0'
        int newLength = strArr.length + (2*numSpaces);
        char[] newStrArr = new char[newLength];
        //strArr[newLength] = '\0'; //this is java, so strings don't need to be null-terminated

        for (int i = len - 1; i >= 0; i--) {
            if (strArr[i] == ' ') {
                newStrArr[newLength-1] = '0';
                newStrArr[newLength-2] = '2';
                newStrArr[newLength-3] = '%';
                newLength = newLength-3;
            }
            else {
                newStrArr[--newLength] = strArr[i];
            }
        }
        String newStr = new String(newStrArr);
        System.out.println("The URLfyed string is " + newStr);
    }
}
