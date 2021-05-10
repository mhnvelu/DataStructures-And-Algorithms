package com.dsa.utils;

public class Utils {

    public static void printMatrix(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
