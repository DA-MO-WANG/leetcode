package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode15 {
    //先脱离代码---遇到这个问题怎么想
    //3个我想不出来，1个我怎么想——》遍历每一个
    //2个——》这里面有两个变数，1个定数--从1头找，和两头分别找，后者更快
    //3个---》定住1个，转化为2个的问题


    //如何保证不重复？---先去理解什么是重复-一个元素被多次遍历到；有重复元素
    // --》把结果的呈现顺序打死了，保证只出现一种结果——先排序，所有的挑选基于有序
    //——》遍历的时候，相邻不会出现相同的

    //暴力解法：基于三重循环框架
    //优化解法：两重循环过程在一重中解决：a + b + c ,当从遍历跳过b时，b往大走，c要满足只能往小走，这就是一个制约关系，也就省事了
    //ps:问题有什么用？提的问题，虽然不一定是这个问题的直接解，但只要是从这个体
    //派生的，就是对这个未知圈的一个探索，探索多了，最终的解答也就不证自答--不要觉得问题没用，而排斥放弃


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left <= right) {
                if (nums[left] != nums[left - 1] && nums[left] + nums[right] + nums[i] == 0) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[i]);
                    arrayList.add(nums[left]);
                    arrayList.add(nums[right]);
                    list.add(arrayList);
                }
                left++;
                right--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        leetcode15 leetcode15 = new leetcode15();
        List<List<Integer>> lists = leetcode15.threeSum(nums);


    }
}
