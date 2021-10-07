package com.dsa;

public class Test {
    public static void main(String a[]) {
        int i = 0;
        int j = 0;
        int index = 2 % 5;
        int quo = 2 / 4;
        System.out.println("index : " + index);
        System.out.println("quo : " + quo);

        int arr[] = {10, 15, 20, 0, 5};
        for (i = 0; i < 5; i++) {
            if (arr[i] > arr[(i + 1) % 5]) {
                System.out.println("pivot : " + i);
            }
        }
    }
}
