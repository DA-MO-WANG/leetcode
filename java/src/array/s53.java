package array;

import java.util.Arrays;
import java.util.HashMap;

public class s53 {
    public int maxSubArray(int[] nums) {

        //四个帮手
        //1.当前值
        //2.之前和
        //3.当前和
        //4.最大和
        int presum = 0;
        int cursum = 0;
        int maxsum = 0;
        boolean fflag = false;
        boolean zflag = false;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                fflag = true;
            }
            if (nums[i] < 0) {
                zflag = true;
            }
            if (presum < 0) {
                presum = 0;
            }
            cursum = nums[i] + presum;
            maxsum = Math.max(presum,maxsum);
            presum += nums[i];
        }
        if (!fflag) {
            Arrays.sort(nums);
            return nums[0];
        }
        if (!zflag) {
            return Arrays.stream(nums).sum();
        }
        return Math.max(presum,maxsum);
    }

    public static void main(String[] args) {
        int[] arr = {5,4,-1,7,8};
        s53 s = new s53();
        int res = s.maxSubArray(arr);
        System.out.println(res);

        HashMap hashMap = new HashMap();
        //hashMap.put()
    }
}
