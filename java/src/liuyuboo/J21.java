package liuyuboo;

public class J21 {
    public int[] exchange(int[] nums) {
        exchange1(nums);
        return nums;
    }
    public void exchange1(int[] nums) {
        int l = 0;
        int gt = nums.length - 1;
        for (int i = l; i < gt;) {
            if ((nums[i] & 1) == 1) {
                i++;
            }else {
                swap(nums,i,gt);
                gt--;
            }
        }
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
