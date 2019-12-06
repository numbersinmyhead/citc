package com.example.java;

import java.util.Arrays;
import java.util.Scanner;

public  class Chap1_2A_CheckPermutation{


    public static void main (String[] string){

        System.out.println("Enter String 1: ");
        Scanner input1 = new Scanner (System.in);
        String s1 = input1.next();

        System.out.println("Enter String 2:");
        Scanner input2 = new Scanner(System.in);
        String s2 = input2.next();

        System.out.print("Is Permutation: " + isPermutation(s1, s2));

    }


    public static boolean isPermutation(String s1, String s2)
    {
        if (s1.length() != s2.length()){
            return false;
        }

        if (compare(s1, s2)){
            return true;
        }
     return false;
    }

    public static boolean compare(String s1, String s2) {
        char[] strArr1 = s1.toCharArray();
        char[] strArr2 = s2.toCharArray();

        Arrays.sort(strArr1);
        Arrays.sort(strArr2);

        s1 = new String(strArr1);
        s2 = new String(strArr2);

        if (s1.equals(s2)){
            return true;
        }

        return false;
    }
}


//the approach below works fine as well.


///*
//package com.example.java;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Chap1_2A_CheckPermutation {
//
//    public static void main (String[] argv)
//    {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter string 1 of your choice: ");
//        String string1 = input.next();
//        System.out.println("Enter String 2 of your choice: ");
//        String string2 = input.next();
//        System.out.print("Two strings are permutation: ");
//        System.out.println(isPermutation(string1, string2) ? "Yes": "No");
//    }
//
//    static boolean isPermutation (String s1, String s2)
//    {
//        if (s1.length() != s2.length())
//        {
//            System.out.println("Not permutation because the length is different");
//            return false;
//        }
//
//        if(sortInputString(s1).equals(sortInputString(s2)))
//        {
//            return true;
//        }
//        return false;
//    }
//
//    static String sortInputString(String str)
//    {
//        char[] charStr = str.toCharArray();
//        Arrays.sort(charStr);
//        return new String(charStr);
//    }
//}
//*/
