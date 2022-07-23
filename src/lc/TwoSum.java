package lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }

    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (x + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException(String.format("No existing sum for target '%s'", target));
    }
}


class TwoSumOptimized {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }

    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int diff = target - x;
            Optional<Integer> diffIndex = Optional.ofNullable(numToIndexMap.get(diff));
            if (diffIndex.isPresent()) {
                return new int[]{diffIndex.get(), i};
            }
            numToIndexMap.put(x, i);
        }
        throw new IllegalArgumentException(String.format("No existing sum for target '%s'", target));
    }
}