package lc;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] test1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] test2 = {1,1};

        System.out.println(maxArea(test1));
        System.out.println(maxArea(test2));
    }

    public static int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = height.length - 1; j > 0; j--) {
                int size = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, size);
            }
        }

        return max;
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;

        do {
            int size = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, size);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        } while (i < j);

        return max;
    }
}
