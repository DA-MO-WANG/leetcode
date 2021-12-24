package liuyuboo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //这种查找题，要提高效率---有一个技巧就是先排序
        //排序方便资源配置和管理操作，大大减少成本
        Arrays.sort(nums);

        //三数之和分治成两数之和
        //两数之和用双指针解决

        List<List<Integer>> ret = new ArrayList<>();
        int n = nums.length;
        //以三元组中第一个位置开始讨论
        int i = 0;
        for (i = 0; i < n - 2; i++) {
            //枚举时不重复
            if (i > 0 && nums[i] - nums[i-1] == 0) {
                continue;
            }
        }
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            if (left < right && nums[left] + nums[right] > -nums[i]) {
                right--;
            }
            if (left < right && nums[left] + nums[right] < -nums[i]) {
                left++;
            }
            if (left < right && nums[left] + nums[right] == -nums[i]) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(left);
                list.add(right);
                ret.add(list);
            }
        }

        return ret;






    }

}
