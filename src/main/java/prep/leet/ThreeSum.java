package prep.leet;

import java.util.*;

public class ThreeSum {
    static boolean zeroesDone = false;
    static boolean existingCombination(List<List<Integer>> usedKeys, Integer i1, Integer i2, Integer i3){
        if(!zeroesDone && i1 == 0 && i2 == 0 && i3 == 0){
            zeroesDone = true;
            return false;
        }
        System.out.println("existingCombination>>>");
        for(List<Integer> combs : usedKeys){
            if(combs.contains(i1) && combs.contains(i2) && combs.contains(i3))
                return true;
        }
        return false;
    }

    static public List<List<Integer>> threesSumHash(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> usedKeys = new ArrayList<>();
        for(int i=0; i< nums.length-1; i++) {
            for(int j=i+1; j< nums.length; j++) {
                int key = 0 - (nums[i] + nums[j]);

                if (map.containsKey(key) &&
                        !existingCombination(usedKeys, map.get(key), i, j) &&
                        !existingCombination(result, key, nums[i], nums[j]) ) {
                    result.add(Arrays.asList(key, nums[i], nums[j]));
                    usedKeys.add(Arrays.asList(map.get(key), i, j));
                }
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,0};//{-1,0,1,2,-1,-4};//{2,7,11,15,23,33,44,55,66,31,49,22,3};
        long start = System.nanoTime();
//        System.out.println(twoSumB(arr, 5));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(threesSumHash(arr, 0));
        System.out.println(System.nanoTime() - start);
    }
}
