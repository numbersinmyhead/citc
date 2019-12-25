package com.example.java;
// Refer to picture(s) in iphone taken on December 24th at the place where i usually study at. That picture
// is for rotating an array 90degrees anti-clockwise. This program tries to rotate an array clockwise by 90 degrees.

// if you are having issues understanding the code below, please draw a 4x4 matrix and rotate it manually one
// square at a time.  Since the first square is the biggest, you would need multiple iterations for that outermost
// loop.
public class Chap1_7_RotateMatrix {

    public static void main(String[] string) {
        int[][] mat = {
                { 1,  2,  3, 4},
                { 5,  6,  7, 8},
                { 9, 10, 11, 12},
                {13, 14, 15, 16}};

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("After clockwise rotation by 90degrees");

        rotateMatrix(mat);




    }

    private static void rotateMatrix(int[][] mat) {
        int N = mat.length; //number of rows in the matrix.
        if (N < 1) {
            System.out.println("Matrix size makes it insufficient to rotate");
            return;
        }

        if (N != mat[0].length) {
            System.out.println("The matrix should have the same number of rows and columns");
            return;
        }

        // You can think of i as the identifier for a row.
        for (int i = 0; i < N/2; i++) // i is limited by N/2 because the algorithm we have only needs to
                                      // run half the number of rows/columns in the matrix. The algorithm
                                      // dictates that we rotate elements in outermost square first followed by
                                      // inner squares. We will continue moving inwards (to inner sqaures) until we
                                      // reach inner most square. From experience we have known that we will keep
                                      // moving inward N/2 number of times.
        {
            // you can think of j as the identifier for a column.
            for (int j = i; j < N-i-1; j++) // When we move inwards, we would like to start our column from where
                                                // the row currently is. If the row is at 0th index, we start from 0th
                                                // 0th column. If the row is at 1st indext, then we start from the
                                                // first column.
                                                // The delimiter (j < N-i-1) for column is because of how we want to
                                                // limit ourselves to an even square. For example if we have a matrix
                                                // 6X6 and we start an inner square from the 3rd column (j = 2),
                                                // then we would like to limit that inner square to the 4th (j=3)
                                                // column because we have already processed the elements in 5th and 6th
                                                // column when we were processing 1st and 2nd column respectively.
            {
                int tmp = mat[i][j];//corner-most element in a square. Store it in a temp variable.

                //replacing the top row with left-most column.
                mat[i][j] = mat[N-1-j][i]; // if you look at the diagram you drew of 4x4 matrix, you would see that
                                           // the elements in the first column are replacing the elements in the first
                                           // row. The replacement elements (ie. elements from 1st column) are on the
                                           // right side of the statement in this line of code. Replacement elements
                                           // are all in the same column, so the the column is constant. Since the
                                           // column is constant, we use 'i' as the value for the column. i will remain
                                           // the same i.e. constant throughout the inner loop i.e. j loop.

                                            // Also, the reason for N-1-j is: N-1 because we start from index 0 and N-1
                                            // is for that offset. We subtract j from N-1 i.e. N-1-j because we wanna
                                            // change the row number with each iteration of j loop.

                mat[N-1-j][i] = mat[N-1-i][N-1-j]; // row remains the same,column changes.
                                                    // replacing the left most column with the bottom row.

                mat[N-1-i][N-1-j] = mat[j][N-1-i]; //replacing the bottom row with right-most column.
                                                    // notice the row changes with j AND row stars with j. 

                mat[j][N-1-i] = tmp;
            }

            for (int k = 0; k < N; k++) {
                for (int l = 0; l < N; l++) {
                    System.out.print(mat[k][l] + " ");
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
}
