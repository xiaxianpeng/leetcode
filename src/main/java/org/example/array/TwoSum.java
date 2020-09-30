package org.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2020/09/30
 * @time 15:46
 */
public class TwoSum {

    public static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (numsMap.get(sub) != null) {
                return new int[]{numsMap.get(sub), i};
            }
            numsMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] indexs = solution(nums, target);
        for (int index : indexs) {
            System.out.println(index);
        }
    }
}
