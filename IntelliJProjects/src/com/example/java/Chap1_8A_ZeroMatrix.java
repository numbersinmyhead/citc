package com.example.java;

// we will use an two 1-D arrays to track rows and columns with zero(s) in them.
// the above is the whole trick for solving the problem.
public class Chap1_8A_ZeroMatrix {

    public static void main (String[] string) {
        int[][] mat = {
                { 1,  2,  3, 4},
                { 5,  0,  7, 8},
                { 9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}};
        startZeroMatrix(mat);

        mat = new int[][]{
                {5, 0, 7, 8},
                {9, 10, 11, 12},
                {17, 18, 19, 20}};
        startZeroMatrix(mat);



        int[][] mat1 = {
                {1, 3, 4, 52},
                {12, 13, 15, 18},
                {20, 21, 0, 25},
                {29, 31, 34, 39}};
        startZeroMatrix(mat1);

        int[][] mat2 = {{1,2,3,4,5,6},
                {8,7,6,5,4,3},
                {19,8,7,6,0,1}};
        startZeroMatrix(mat2);

        int[][] mat3 = {{1,2,0},
                {2,4,4},
                {19,8,7},
                {5,0,1}};
        startZeroMatrix(mat3);
    }

    private static void startZeroMatrix(int[][] mat) {
        System.out.println("INPUT");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }

        zeroMatrix(mat);
    }

    private static void zeroMatrix(int[][] mat) {
        boolean[] nullifyRowList = new boolean[mat.length];
        boolean[] nullifyColList = new boolean[mat[0].length];

        // find the zero elements and update the list.
        for (int i = 0; i < mat.length; i++) {
            for (int j =0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    nullifyRowList[i] = true;
                    nullifyColList[j] = true;
                }
            }
        }

        //nullify row
        for (int i = 0; i < mat.length; i++) {
            if (nullifyRowList[i]) {
                for (int j = 0; j < nullifyColList.length; j++) {
                    mat[i][j] = 0;
                }
            }
        }

        //nullify col
        for (int i = 0; i < mat[0].length; i++) {
            if (nullifyColList[i]) {
                for (int j =0; j < mat.length; j++) {
                    mat[j][i] = 0;
                }
            }
        }

        System.out.println("OUTPUT");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
