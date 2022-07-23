package cci.arrays;

public class _1_7_RotateMatrix {

    public static void main(String[] args) {
        printMatrix(new int[][]{{}});
        printMatrix(new int[][]{{1}});
        printMatrix(new int[][]{{1, 2}, {3, 4}});
        printMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        printMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        printMatrix(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18,
                19, 20}, {21, 22, 23, 24, 25}});
    }

    static void printMatrix(int[][] matrix) {
        int[][] rotated = rotate(0, matrix);
        for (int[] num : rotated) {
            for (int ele : num) {
                System.out.print(" " + ele);
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    static int[][] rotate(int start, int[][] matrix) {
        if (matrix.length / 2 >= start) {
            matrix = rotateRing(start, matrix);
            return rotate(start + 1, matrix);
        }

        return matrix;
    }

    static int[][] rotateRing(int start, int[][] matrix) {
        int end = matrix.length - 1 - start;
        for (int i = 0; i < end - start; i++) {
            int temp = matrix[start][i + start];
            matrix[start][i + start] = matrix[end - i][start];
            matrix[end - i][start] = matrix[end][end - i];
            matrix[end][end - i] = matrix[i + start][end];
            matrix[i + start][end] = temp;
        }

        return matrix;
    }
}
