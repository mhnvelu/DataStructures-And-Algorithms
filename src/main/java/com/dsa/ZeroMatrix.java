package com.dsa;

/*
Problem Description:
Write an algorithm such that if an element in M*N matrix is 0, then its entire row and column are set to 0.
 */

/*
Input Matrix :
1 2 3 4
5 0 7 8
9 10 11 12
13 14 0 16

Output Matrix :
1 0 0 4
0 0 0 0
9 0 0 12
0 0 0 0
 */


import com.dsa.utils.Utils;

/*
Solution:
a) We need to know which row or column has 0. Based on this, we will set entire or column to 0.
b) we can have 2 arrays - one for row and other for column to keep track of which row/column has 0.
c) Then using these 2 arrays, set 0's appropriately.
 */
public class ZeroMatrix {
    public static void main(String a[]) {
        ZeroMatrix obj = new ZeroMatrix();
        int[][] matrix = {{1, 2, 3, 4}, {5, 0, 7, 8}, {9, 10, 11, 12}, {13, 14, 0, 16}};
        System.out.println("Input Matrix : ");
        Utils.printMatrix(matrix);
        System.out.println("Output Matrix : ");
        Utils.printMatrix(obj.setZeros(matrix));
    }

    int[][] setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // Set 0 in rows
        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set 0 in columns

        for (int i = 0; i < column.length; i++) {
            if (column[i]) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        return matrix;
    }
}
