package lc;

public class Median {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2})); // 2
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})); // 2.5
        System.out.println(findMedianSortedArrays(new int[]{7, 8, 9, 10, 11, 12, 14, 15}, new int[]{3, 4, 5}));
        System.out.println(findMedianSortedArrays(new int[]{3, 8, 9}, new int[]{4, 7, 10})); // 7.5
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // taken from NeetCode: https://www.youtube.com/watch?v=q6IEA26hvXc&t=556s

        if (nums1.length < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        if (nums2.length == 0) {
            int half = nums1.length / 2;
            return nums1.length % 2 == 0 ? (double) (nums1[half - 1] + nums1[half]) / 2 : nums1[half];
        }

        int size = nums1.length + nums2.length;
        int half = size / 2;

        int l = 0;
        int r = nums1.length - 1;
        do {
            int i = (l + r) / 2;
            int j = half - i - 2;

            int aLeft = i < 0 ? Integer.MIN_VALUE : nums1[i];
            int aRight = i + 1 >= nums1.length ? Integer.MAX_VALUE : nums1[i + 1];
            int bLeft = j < 0 ? Integer.MIN_VALUE : nums2[j];
            int bRight = j + 1 >= nums2.length ? Integer.MAX_VALUE : nums2[j + 1];

            if (aLeft <= bRight && bLeft <= aRight) {
                if (size % 2 == 0) {
                    return (double) (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2;
                }
                return Math.min(aRight, bRight);
            } else if (aLeft > bRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        } while (true);
    }
}
