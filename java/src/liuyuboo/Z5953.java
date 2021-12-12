package liuyuboo;

public class Z5953 {
    public long subArrayRanges(int[] nums) {
        return subArrayRanges(nums,0);
    }
    public long subArrayRanges(int[] nums, int index) {
        if(index == nums.length - 1) {
            return 0;
        }

        int min = Math.min(nums[index],nums[index+1]);
        int max = Math.max(nums[index],nums[index+1]);
        long ret = max - min;
        long pre = 0;
        long cur = 0;
        for (int i = index + 2; i < nums.length; i++) {
            if (nums[i] >= min && nums[i] <= max) {
                pre = ret;
                cur = pre + 0;
                ret = cur + pre;

            }else {
                if(nums[i] < min) min = nums[i];
                if(nums[i] > max) max = nums[i];
                pre = ret;
                cur = sum(max,min);
                ret = pre + cur;
            }
        }
        return ret + subArrayRanges(nums,++index);
    }

    public long sum(int max, int min) {
        return max - min;
    }

    public static void main(String[] args) {
        Z5953 z = new Z5953();
        int[]  nums = {4,-2,-3,4,1};
        long l = z.subArrayRanges(nums);
        System.out.println(l);

    }
}
