package cci.arrays;

import java.util.HashSet;
import java.util.Set;

public class _1_8_ZeroMatrix {

    public static void main(String[] args) {
        int[][] m1 = {{1, 2, 0}, {5, 0, 7}, {9, 0, 11}, {13, 14, 15}, {}};
        printMatrix(zeroMatrix(m1));
    }

    static void printMatrix(int[][] matrix) {
        for (int[] num : matrix) {
            for (int ele : num) {
                System.out.print(" " + ele);
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    static int[][] zeroMatrix(int[][] matrix) {
        if (matrix.length == 0) return matrix;

        int[] zeroRow = new int[matrix[0].length];
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            if (!zeroRows.contains(i)) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i] = zeroRow;
                        zeroRows.add(i);
                        zeroCols.add(j);
                        j = matrix[i].length;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (!zeroRows.contains(i)) {
                for (int j: zeroCols) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

}
