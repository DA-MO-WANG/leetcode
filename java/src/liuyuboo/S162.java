package liuyuboo;

public class S162 {
    public int findPeakElement(int[] nums) {
        int i = -1;
        int j = nums.length;
        while (j > i) {
            int mid = i + (j - i) / 2;
            if ( mid == 0 && nums[mid] > nums[mid + 1] || mid == nums.length - 1 && nums[mid] > nums[mid - 1] || nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] < nums[mid - 1]) {
                j = mid - 1;
            }else if (nums[mid] < nums[mid + 1]) {
                i = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        S162 s162 = new S162();
        int[] arr = {1,2,1,1,2,1};
        int peakElement = s162.findPeakElement(arr);
        System.out.println(peakElement);

    }

}
