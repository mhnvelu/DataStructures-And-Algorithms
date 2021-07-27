package com.dsa.sortingAndSearching;

public class MergeSort {
    public static void main(String a[]) {
        int input[] = {10, 8, 2, 6, 3, 5, 9, 1, 7};
        MergeSort mergeSort = new MergeSort();
        int result[] = new int[input.length];
        mergeSort.mergeSort(input, result, 0, input.length - 1);

        for (int i = 0; i < input.length; i++) {
            System.out.println(result[i]);
        }
    }

    private void mergeSort(int input[], int result[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(input, result, low, mid);
            mergeSort(input, result, mid + 1, high);
            merge(input, result, low, mid, high);
        }

    }

    private void merge(int input[], int result[], int low, int mid, int high) {
        // get start and end positions
        int leftStart = low;
        int rightStart = mid + 1;
        int k = 0;

        while (leftStart <= mid && rightStart <= high) {
            if (input[leftStart] <= input[rightStart]) {
                result[k] = input[leftStart];
                k += 1;
                leftStart += 1;
            } else {
                result[k] = input[rightStart];
                k += 1;
                rightStart += 1;
            }
        }

        while (leftStart <= mid) {
            result[k] = input[leftStart];
            k += 1;
            leftStart += 1;
        }

        while (rightStart <= high) {
            result[k] = input[rightStart];
            k += 1;
            rightStart += 1;
        }

        for (int i = low; i <= high; i++) {
            input[i] = result[i - low];
        }
    }
}
