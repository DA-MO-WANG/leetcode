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
        //while (left < right) {//因为要枚举b，定一议二==》left是不能动的，用while不对
        for(left = i + 1; left < n - 1; left++) {

            //难点：各个比较的细节--有点容易混乱
            //重复的只走一次
            //如果相等的话，left left-1 结果一样
            if(left < right && nums[left] == nums[left - 1]) {
                continue;
            }
            //定住了left， 开始找right的位置
            //因为是排序的，所以right一直往左走
            while (left < right && nums[left] + nums[right] > -nums[i]) {
                right--;
            }
            //以前走过的，不需要重复再走了
            if(left == right) break;
            //发现两个重合的，同解，跳过一个
            if(right < n - 1 && nums[right] == nums[right + 1]) {
                continue;
            }
            //把最后的解放在最后
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
