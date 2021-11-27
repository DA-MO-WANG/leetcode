package liuyuboo;

public class S162 {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        if(nums.length <= 2) {
            return (nums[0] > nums[1]) ? 0: 1;
        }
        if(nums[0] > nums[1]) {
            return 0;
        }
        if(nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int i = 0;
        int j = nums.length - 1;
        while (j - i >= 2) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] < nums[mid - 1]) {
                j = mid;
            }
            if (nums[mid] < nums[mid + 1]) {
                i = mid;
            }
        }
        return 0;

    }
    public int find(int[] nums, int i, int j) {
        if(j == 0) return 0;
        if(j == 1) {
            return (nums[0] > nums[1]) ? 0: 1;
        }
        if (j == nums.length - 1) {
            if(nums[nums.length - 1] > nums[nums.length - 2]) {
                return nums.length - 1;
            }
        }

        if (j- i < 2) {
            return -1;
        }

        int mid = i + (j - i) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        int ret = find(nums,i,mid);
        if(ret == -1) {
           ret =  find(nums,mid,j);
        }
        return ret;
    }

    public static void main(String[] args) {
        S162 s162 = new S162();
        int[] arr = {1,2,1,1,2,1};
        int peakElement = s162.find(arr,0,arr.length - 1);
        System.out.println(peakElement);

    }

}
