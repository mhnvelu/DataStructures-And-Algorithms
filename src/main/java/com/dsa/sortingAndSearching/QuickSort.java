package com.dsa.sortingAndSearching;

public class QuickSort {
    public static void main(String a[]) {
        QuickSort quickSort = new QuickSort();
        int input[] = {10, 8, 2, 6, 3, 5, 9, 1, 7};
        quickSort.sort(input, 0, input.length - 1);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    void sort(int input[], int start, int end) {
        int index = partition(input, start, end);
        if (start < index - 1) {
            sort(input, start, index - 1);
        }
        if (index < end) {
            sort(input, index, end);
        }
    }

    int partition(int input[], int start, int end) {
        int pivotIndex = (start + end) / 2;
        int pivot = input[pivotIndex];

        while (start <= end) {
            //check from left
            {
                while (input[start] < pivot) {
                    start++;
                }
            }

            // check from right
            while (input[end] > pivot) {
                end--;
            }

            if (start <= end) {
                swap(input, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private void swap(int input[], int from, int to) {
        int temp = input[from];
        input[from] = input[to];
        input[to] = temp;
    }
}
