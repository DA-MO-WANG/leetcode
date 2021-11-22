package liuyuboo;

import java.util.Arrays;

public class S875 {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = getMax(piles);//可以用流封装的api
        int hi1 = Arrays.stream(piles).max().getAsInt();
        System.out.println(hi);

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (!check(piles,mid,h)) {
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        return lo + (hi - lo) / 2;
    }
    public boolean check(int[] arr, int k, int h) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            //这里有一种边界情况需要考虑
            sum += ((arr[i] % k) > 0 || (arr[i] < k) ? 1 : 0) + arr[i] / k;
            System.out.println("中间sum结果："+ sum);
        }
        System.out.println("实际吃的时间： "+sum);
        return sum <= h;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,7,11};
        S875 s875 = new S875();
        int i = s875.minEatingSpeed(arr, 8);
        System.out.println(i);

    }
    public int getMax(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return arr[max];
    }
}
