package com.example.java;

//In the previous solution we were using 2 1-D arrays to keep track of which row and column had a zero element. We
//were using that as our lookup tool. However, now we are using the first row and first column to keep track of zero
//element in a row or column.

public class Chap1_8B_ZeroMatrix {

    public static void main(String[] string) {

        int[][] mat1 = {
                {1, 3, 4, 52},
                {12, 13, 15, 18},
                {20, 21, 0, 25},
                {29, 31, 34, 39}};
        nullifyMatrix(mat1);

        int[][] mat2 = {{1,2,3,4,5,6},
                {8,7,6,5,4,3},
                {19,8,7,6,0,1}};
        nullifyMatrix(mat2);

        int[][] mat3 = {{1,2,0},
                {2,4,4},
                {9,8,7},
                {5,0,1}};
        nullifyMatrix(mat3);
    }

    private static void nullifyMatrix(int[][] mat) {
        int numRows = mat.length;
        int numCols = mat[0].length;

        System.out.println("Matrix before operation:");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");

        // To keep track of zero element in the first row and first column respectively.
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        for (int i = 0; i < numCols; i++) {
            if (mat[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < numRows; i++) {
            if (mat[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // We will use this condition in confunction with firstRowHasZero/firstColHasZero to zero out all rows
        // columns that have an element which is a zero.
        for (int i = 1; i < numRows; i++) {
            // this is very important that we start from 1 for i and j otherwise we will zero out the entire matrix if
            // the element in first row/column is zero. This zeros outs the whole matrix because all the elements in
            // the first row/column are set to zero. This results in all other elements in that row/column getting set
            // to zero. It's like an explosion. lol
            for (int j = 1; j < numCols; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // we will iterate through all the rows in the first column and nullify the row if the first element in that
        // row is zero.
        for (int i = 0; i < numRows; i++) {
            if (mat[i][0] == 0) {
                for (int c = 0; c < numCols; c++) {
                    mat[i][c] = 0;
                }
            }
        }

        // we will iterate through all the columns in the first row and nullify the column if the first element in the
        // column is zero.
        for (int j = 0; j < numCols; j++) {
            if (mat[0][j] == 0) {
                for (int r = 0; r < numRows; r++) {
                    mat[r][j] = 0;
                }
            }
        }

        // we will now check that if the first row and first column initially had zero elements themselves. If they did,
        // then we will nullify them.
        if (firstRowHasZero) {
            for (int i = 0; i <numCols; i++) {
                mat[0][i] = 0;
            }
        }
        if (firstColHasZero) {
            for (int i = 0; i <numRows; i++) {
                mat[i][0] = 0;
            }
        }

        System.out.println("Matrix after operation:");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
