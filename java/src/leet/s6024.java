package leet;

import java.util.HashMap;

public class s6024 {
    public int mostFrequent(int[] nums, int key) {
        //HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>()；
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == key) {
                if(!map.containsKey(nums[i + 1])) {
                    map.put(nums[i+1],0);
                }else {
                    Integer integer = map.get(nums[i + 1]);
                    map.put(nums[i+1],integer++);
                }
                //map.put(nums[i + 1],1);
            }
        }
        int max = 0;
        for(Integer k : map.keySet()) {
            if(map.get(k) > max) {
                max = map.get(k);
            }
        }
        return max;
    }

}
