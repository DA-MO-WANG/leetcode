package liuyuboo;

public class S75 {
    public void sortColors(int[] nums) {
        if (nums == null) return;
        if (nums.length == 1) {
            return;
        }
        //if (nums.length)

        //分成三部分
        //boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums,i,0);
                break;
                //flag = true;
            }
        }
        int v = nums[0];
        int lt = 0;
        int gt = nums.length;
        int i = 1;
        while (i < gt) {
            //lt+1-i-1   =v
            while (i < nums.length && nums[i] == v) {
                System.out.print("=v "+i+" " + nums[i]);
                i++;
            }
            //l+1-lt  <v
            while (i < nums.length && nums[i] < v) {
                System.out.println();
                System.out.println("<v " );
                swap(nums,lt + 1,i);
                lt++;
                i++;

            }
            //gt-r  >v
            if (i < nums.length && nums[i] > v) {
                System.out.println();
                System.out.println(">v " );
                swap(nums,gt - 1,i);
                gt--;
            }
        }
        swap(nums,0,lt);
    }
    public void swap(int[] arr, int i , int j) {
        System.out.println("交换："+arr[i]+"<->"+arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2,1,1,0};
        S75 s75 = new S75();
        s75.sortColors(arr);
        for (int i : arr) {
            System.out.print(i+ " ");
        }
    }
}
