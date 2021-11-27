package liuyuboo;

public class S162 {
    public int findPeakElement(int[] nums) {
        //这个题必然有峰值，就看在哪
        int i = -1;
        int j = nums.length;
        while (j > i) {
            int mid = i + (j - i) / 2;
            //核心检测条件
            if ( (mid == 0 && nums[mid] > nums[mid + 1]) || (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) || (mid > 0 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])) {
                return mid;
            }
            //移动分支：推出哪一端必然有
            if (mid > 0 && nums[mid] < nums[mid - 1]) {//（-1，mid)处必有峰值，单调有，不单调也有
                j = mid;//往哪个方向走，就从另外一个边出发推
            }else if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
                i = mid;
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
