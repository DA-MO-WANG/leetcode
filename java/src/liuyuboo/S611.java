package liuyuboo;


import java.util.Arrays;

public class S611 {
    public int triangleNumber(int[] nums) {
        //任意两边之和大于第三边：小小
        //任意两边之差小于第三边：大小

        //先排序--排好序的好处是校验条件转化为一个
        Arrays.sort(nums);
        int count = 0;
        //遍历最长边
        for (int j = nums.length - 1; j >= 2; j--) {
            //问题转化为0-j-1,区间内找到两个数满足和大于一个数：两数之和问题的变种
            count += count(nums,0,j - 1,nums[j]);
        }
        return count;

    }
    public int count(int[] arr, int m, int n, int target) {
        int lo = m;
        int hi = n;
        int sum = 0;
        while (lo < hi) {
            if (arr[lo] + arr[hi] <= target) {
                lo++;
            }else {
                sum += hi - lo;
                hi--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,4};
        S611 s611 = new S611();
        int i = s611.triangleNumber(arr);
        System.out.println(i);

    }
}
