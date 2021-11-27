package liuyuboo;

public class S162 {
    public int findPeakElement(int[] nums) {
        int ret = find(nums, 0, nums.length - 1);
        return ret;

    }
    public int find(int[] nums, int i, int j) {
        if (j- i < 2) {
            return -1;
        }
        int ret = 0;
        int mid = i + (j - i) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        find(nums,i,mid);
        find(nums,mid,j);
    }

    public static void main(String[] args) {
        S162 s162 = new S162();
        int[] arr = {1,2,1,3,5,6,4};
        int peakElement = s162.findPeakElement(arr);
        System.out.println(peakElement);

    }

}
