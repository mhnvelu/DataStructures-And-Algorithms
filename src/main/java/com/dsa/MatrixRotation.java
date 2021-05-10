package com.dsa;

/*
Problem Description:
An image represented by an N*N matrix. Write a method to rotate the image by 90 degrees.
Perform the rotation in place without new space.
 */

/*
Input Image :
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

Output Image :
13 9 5 1
14 10 6 2
15 11 7 3
16 12 8 4
 */


/*
Solution 1:
a) Copy the top edge to an tmp array. Then move the left to the top, bottom to the top, right to the bottom and tmp array to the right.
b) But it requires O(N) space.
 */

/*
Solution 2:
a) Swap index by index. so it happens in place without new space.
b) Perform the swap on each layer, starting from outermost layer and working our way inwards.
Alternatively we can start from inner layer and work outwards
c) Time complexity - O(N^2)
 */

import com.dsa.utils.Utils;

/*
Solution 2
 */
public class MatrixRotation {

    public static void main(String a[]) {
        MatrixRotation obj = new MatrixRotation();
        int[][] image = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println("Input Image : ");
        Utils.printMatrix(image);
        System.out.println("Output Image : ");
        Utils.printMatrix(obj.rotateImage(image));
    }

    int[][] rotateImage(int[][] image) {
        if (image.length == 0 || image.length != image[0].length) {
            throw new RuntimeException("Image is not square");
        }
        int size = image.length;
        for (int layer = 0; layer < size / 2; layer++) {
            int first = layer;
            int last = size - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                // save top
                int top = image[first][i];

                // left -> top
                image[first][i] = image[last - offset][first];

                // bottom -> left
                image[last - offset][first] = image[last][last - offset];

                // right -> bottom
                image[last][last - offset] = image[i][last];

                // top -> right
                image[i][last] = top;
            }
        }
        return image;
    }
}
