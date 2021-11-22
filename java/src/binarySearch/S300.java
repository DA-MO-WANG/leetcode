package binarySearch;

public class S300 {

    //只依赖相邻比较，会漏解
    public int lengthofLIS(int[] nums) {
        int pre = 0;

        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            pre = i;
            int j = pre + 1;
            while (j < nums.length) {
                if (nums[pre] < nums[j]) {
                    len = Math.max(len,++count);
                    pre = j;
                }
                j++;
            }
        }
        return len;
    }
    //别人的思路
    //返回最长严格递增序列长度
    public int lengthLIS(int[] nums) {
        int[] ret = new int[nums.length];
        int len = 1;
        ret[0] = nums[0];
        for (int num : nums) {
            if (ret[len - 1] < num) {
                ret[len] = num;
                len++;
            }else {
                int i = binarySearch(ret, 0,len,num);
                ret [i] = num;
            }
        }
        return len;

    }
    public int binarySearch(int[] arr, int i, int j, int target) {
        int lo = i;
        int hi = j;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        return lo;
    }


    public static void main(String[] args) {
        S300 s300 = new S300();
        //int i = s300.lengthLIS(new int[]{10,9,2,5,3,7,101,18});
        //System.out.println(i);
        System.out.println("abc".substring(0,1));


    }
}
