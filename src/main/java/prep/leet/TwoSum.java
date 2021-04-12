package prep.leet;

import java.util.*;

public class TwoSum {

    static public List<Integer> twoSumB(int[] nums, int target) {
        for(int i=0; i< nums.length-1; i++) {
            for (int j = i; j < nums.length; j++) {
                if(nums[i] + nums[j] == target)
                    return Arrays.asList(i, j);
            }
        }
        return null;
    }

    static public List<Integer>  twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return Arrays.asList(map.get(target - nums[i]), i);
            map.put(nums[i], i);
        }
        return null;
    }

    static public List<Integer> twoSumSort(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i=0; i< nums.length; i++) {
            int siblingIndex = Arrays.binarySearch(nums, target - nums[i]);
//            System.out.println(siblingIndex);
            if(siblingIndex > -1 && siblingIndex != i)
                return Arrays.asList(i, siblingIndex);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15,23,33,44,55,66,31,49,22,3};
        long start = System.nanoTime();
        System.out.println(twoSumB(arr, 5));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(twoSumHash(arr, 5));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(twoSumSort(arr, 33));
        System.out.println(System.nanoTime() - start);
    }
}
