package com.dsa.sortingAndSearching;

public class SortedMatrixSearch {
    public static void main(String a[]) {
        SortedMatrixSearch sortedMatrixSearch = new SortedMatrixSearch();
        int input[][] = {{15, 20, 40, 85}, {20, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}};
        System.out.println("55 exists : " + sortedMatrixSearch.findElement(input, 55));
    }

    public boolean findElement(int input[][], int element) {
        int row = 0;
        int col = input[0].length - 1;

        while (row < input.length && col >= 0) {
            if (input[row][col] == element) {
                return true;
            } else if (input[row][col] > element) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
