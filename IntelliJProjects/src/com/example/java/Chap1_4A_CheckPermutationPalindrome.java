package com.example.java;

import java.util.Scanner;

public class Chap1_4A_CheckPermutationPalindrome {


    public static void main (String [] args) {
        System.out.println("Enter a string to check if it is a permutation of palindrome: ");
        Scanner input = new Scanner(System.in);
        String str = new String (input.nextLine());

        System.out.println(str + " is permutation of palindrome? " + isPermutationOfPalindrome(str));
    }

    private static boolean isPermutationOfPalindrome (String string) {
        int[] table = getCharacterCount(string);
        return isOddElementOnlyOnce(table);
    }

    private static int[] getCharacterCount(String string) {
        //We are doing a +1 because we want to include ALL the characters from a TO z. If we don't do a +1, then
        //we will only have 25 elements in the alphabets instead of 26. Kinda like how we would count the number of
        //elements from index 21 to index 30. i.e. 30-21= 9 and then we do 9 + 1 = 10. Therefore, from 21 to 30 we
        // will have ten elements.

        //Also note that the function getNumericValue() takes care of the case insensitivity. The function would return
        //the same integer value of a characters regardless of the case.
        int val1 = Character.getNumericValue('z');
        int val2 = Character.getNumericValue('a');
        int val = val1 - val2 + 1;
        int[] table = new int[val];

        //populate the number of times each character appears in the table.
        for (char c : string.toCharArray()) {
            if (Character.getNumericValue(c) >= Character.getNumericValue('a') &&
                    Character.getNumericValue(c) <= Character.getNumericValue('z')) {
                table[Character.getNumericValue(c) - Character.getNumericValue('a')]++;
            }
        }

        return table;
    }

    // function to return false if there is more than one odd element.
    // by odd element i mean there can only be one element which occurs odd # of times.
    // all elemenets would occur an even number of times PLUS 1 odd element in a permutation of a palindrome.
    // also, note the odd element is optional when there are even number of characters in an input string.
    // there is going to be an odd element only when the string itself is odd numbered.
    private static boolean isOddElementOnlyOnce(int[] table) {
        boolean result = false;
        for (int i = 0; i < table.length ; i++) {
            if (table[i] % 2 == 1) { // true whenever the count of element is odd
                if (result) { //true ONLY when a particular table[i] element has previously been recorded as odd one.
                    return false; // hitting this condition means we just detected another odd count element.
                }
                result = true;
            }
        }
        return true;
    }
}
