package leet;

import java.util.HashMap;

public class S6024 {
    public  int mostFrequent(int[] nums, int key) {
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

    public static void main(String[] args) {
        int x[] = {1,100,200,1,100};
        S6024 s = new S6024();
        int i = s.mostFrequent(x,1);
        System.out.println(i);

    }


}
