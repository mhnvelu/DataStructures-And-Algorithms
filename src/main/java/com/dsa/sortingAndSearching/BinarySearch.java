package com.dsa.sortingAndSearching;

public class BinarySearch {
    public static void main(String a[]) {
        BinarySearch binarySearch = new BinarySearch();
        int input[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch.search(input, 6));
    }

    int search(int input[], int x) {
        int low = 0;
        int high = input.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (input[mid] > x) {
                high = mid - 1;
            } else if (input[mid] < x) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
