package binarySearch;

public class S34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        //lower-ceil问题，更小的天花板
        int floor = upper_floor(nums, 0, nums.length, target);
        int first = 0;
        if (floor == nums.length) {
            first = -1;
        }else if (nums[floor] != target) {
            first = -1;
        }{
            first = floor;
        }


        //lowwer问题
        //<=target
        int second = 0;
        int ceil = lowwer_ceil(nums, -1, nums.length - 1, target);
        if (ceil == -1) {
            second = -1;
        }else if (nums[ceil] != target){
            second = -1;
        }else {
            second = ceil;
        }
        ret[0] = first;
        ret[1] = second;
        return ret;


    }
    //>=target--upper_floor
    // 0----length
    public int upper_floor(int[] arr, int lo, int hi, int target) {

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;//==可能在右边
            }else {
                hi = mid;
            }
        }
        return lo;
    }

    //lowwer_ceil问题
    //<=target
    //-1---length-1
    public int lowwer_ceil(int[] arr, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;//mid后写
            if (arr[mid] <= target) {
                lo = mid;
            }else {
                hi = mid - 1 ;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        S34 s34 = new S34();
        int[] arr = {5,7,7,8,8,10};
        int i = s34.lowwer_ceil(arr, 0, 5, 8);
        System.out.println(i);

    }
}
