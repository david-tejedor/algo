package algos.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a1 = {4, 3, 5, 6, 2, 1, 2};
        sort(a1);
        System.out.println(Arrays.toString(a1));

        int[] a2 = {5, 5, 4, 5, 2, 0};
        sort(a2);
        System.out.println(Arrays.toString(a2));
    }

    public static void sort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] helper, int start, int end) {
        if (end <= start) return;

        int mid = (start + end) / 2;
        mergeSort(array, helper, start, mid);
        mergeSort(array, helper, mid + 1, end);
        merge(array, helper, start, mid, end);
    }

    private static void merge(int[] array, int[] helper, int leftStart, int leftEnd, int rightEnd) {
        int rightStart = leftEnd + 1;

        for (int i = leftStart; i <= rightEnd; i++) {
            helper[i] = array[i];
        }

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left < rightStart && right < rightEnd + 1) {
            if (helper[left] < helper[right]) {
                array[index] = helper[left];
                left++;
            } else {
                array[index] = helper[right];
                right++;
            }
            index++;
        }

        while (left < rightStart) {
            array[index] = helper[left];
            index++;
            left++;
        }
    }

}
