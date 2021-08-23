package array;

import java.util.HashMap;

public class leetcode1 {
    //暴力解法
    //暴力解法就是勤奋解法，也就是只要坚持做就能解决的思路，是最基本的做的体现
    //不做，后续的各种精巧的算法也不会出现
    public int[] twoSum(int[] nums, int target) {
        //把说法倒过来，说法是先目标值再两个数，解决思路就是先连个数，再谈目标值
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        throw new IllegalArgumentException("不存在满足条件的两个数！");
    }

    //方式二：取表法
    //方式一效率低在很多数据不必遍历很多次，第一次就遍历了，所以记录起来后面就不用遍历了。
    //把第一次遍历的数据存到第三方表里，然后需要的时候从表里求出来再操作
    //这里的表用HashMap结构

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i,(Integer)map.get(target - nums[i])};
            }
            map.put((target - nums[i]),nums[i]);
        }
        throw new IllegalArgumentException("不存在满足条件的两个数！");
    }

}
