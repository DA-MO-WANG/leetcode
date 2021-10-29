package liuyuboo;

public class S75 {
    public void sortColors(int[] nums) {
        if (nums)
        //分成三部分
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums,i,0);
            }
        }
        int lt = 0;
        int gt = nums.length;
        int i = 1;
        while (i < gt) {
            if (nums[i] == 1) {
                i++;
            }
            if (nums[i] < 1) {
                swap(nums,lt + 1,i);
                lt++;
                i++;
            }
            if (nums[i] > 1) {
                swap(nums,gt - 1,i);
                gt--;
            }
        }
        swap(nums,0,lt);
    }
    public void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1,0,1,0,2,1,0};
        S75 s75 = new S75();
        s75.sortColors(arr);
        for (int i : arr) {
            System.out.print(i+ " ");
        }
    }
}
